package net.nic.npc.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.nic.npc.gui.inviteKingdom.MenuIK;
import net.nic.npc.item.MDataComponents;
import net.nic.npc.kingdom.ColorStorage;
import net.nic.npc.kingdom.Kingdom;
import net.nic.npc.kingdom.events.KingdomEventManager;
import net.nic.npc.kingdom.users.KingdomUser;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;

public class InviteItem extends MItem {


    public InviteItem(ResourceLocation kingdomInvite, Item.Properties properties) {
        super(kingdomInvite,properties);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        if (stack.has(MDataComponents.KINGDOM_ID)) {
            return true;
        }
        return super.isFoil(stack);
    }

    public void createInvite(ItemStack invite, UUID kingdomID){
        invite.set(MDataComponents.KINGDOM_ID, kingdomID);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        ItemStack stack = context.getItemInHand();

        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            UUID playerID = serverPlayer.getUUID();
            KingdomUser user = KingdomEventManager.getInstance().getUser(playerID);

            if (user.isInKingdom()) {
                UUID kingdomID = user.getKingdomID();
                stack.set(MDataComponents.KINGDOM_ID, kingdomID);
                player.displayClientMessage(Component.literal("Kingdom ID set on item."), true);
                return InteractionResult.SUCCESS;
            } else {
                player.displayClientMessage(Component.literal("You are not in a kingdom."), true);
                return InteractionResult.FAIL;
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            Optional<UUID> optionalKingdomID = Optional.ofNullable(stack.get(MDataComponents.KINGDOM_ID));

            if (optionalKingdomID.isPresent()) {
                UUID kingdomID = optionalKingdomID.get();
                KingdomEventManager manager = KingdomEventManager.getInstance();
                Kingdom kingdom = manager.getKingdom(kingdomID);
                KingdomUser user = manager.getUser(serverPlayer.getUUID());

                if (kingdom != null && (!user.isInKingdom() || !user.getKingdomID().equals(kingdomID))) {
                    // Open the invitation GUI
                    player.openMenu(getMenu());
                    return InteractionResult.SUCCESS;
                } else {
                    serverPlayer.displayClientMessage(Component.literal("You are already in this kingdom."), true);
                    return InteractionResult.FAIL;
                }
            } else {
                serverPlayer.displayClientMessage(Component.literal("This item has no kingdom ID."), true);
                return InteractionResult.FAIL;
            }
        }
        return InteractionResult.PASS;
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltipDisplay, tooltipAdder, flag);

        if (stack.has(MDataComponents.KINGDOM_ID)) {
            UUID hostKingdomID = stack.get(MDataComponents.KINGDOM_ID);
            Kingdom kingdom = KingdomEventManager.getInstance().getKingdom(hostKingdomID);

            if (kingdom != null) {
                tooltipAdder.accept(Component.literal(kingdom.getName()).withColor(ColorStorage.gold));
            } else {
                tooltipAdder.accept(Component.literal("Invalid Kingdom").withColor(ColorStorage.gray40));
            }
        } else {
            tooltipAdder.accept(Component.literal("No data").withColor(ColorStorage.gray40));
        }
    }


    protected MenuProvider getMenu() {
        MenuProvider inviteKingdom = new SimpleMenuProvider((containerId, playerInventory, player1) -> new MenuIK(containerId, playerInventory), Component.translatable("npc.gui.menu.menukic"));
        return inviteKingdom;
    }
}
