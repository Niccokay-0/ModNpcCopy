package net.nic.npc.gui.inviteKingdom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.nic.npc.gui.MMenus;
import net.nic.npc.item.MDataComponents;
import net.nic.npc.kingdom.Kingdom;
import net.nic.npc.kingdom.events.KingdomEventManager;
import net.nic.npc.kingdom.users.KingdomUser;

import java.util.UUID;

public class MenuIK extends AbstractContainerMenu {

    public MenuIK(int containerId, Inventory playerInventory) {
        super(MMenus.MENUIK.get(), containerId);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    public void joinKingdom(Player player, UUID playerUUID) {
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (!stack.has(MDataComponents.KINGDOM_ID)) return;

        UUID kingdomID = stack.get(MDataComponents.KINGDOM_ID);
        Kingdom target = KingdomEventManager.getInstance().getKingdom(kingdomID);
        if (target == null) return;

        KingdomUser user = KingdomEventManager.getInstance().getAllUsers()
                .computeIfAbsent(playerUUID, KingdomUser::new);

        if (!KingdomEventManager.getInstance().isInKingdom(playerUUID)) {
            user.leaveKingdom();
            user.joinKingdom(kingdomID, target.getGovernment(), false);
        }
    }

    public void destroyInvite(Player player) {
        ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
        if (!stack.isEmpty()) {
            stack.shrink(1);
        }
    }
}
