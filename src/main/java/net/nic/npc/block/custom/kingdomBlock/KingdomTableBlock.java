package net.nic.npc.block.custom.kingdomBlock;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.nic.npc.NpcMain;
import net.nic.npc.gui.kingdomInterface.MenuKIC;
import net.nic.npc.kingdom.Kingdom;
import net.nic.npc.kingdom.events.KingdomEventManager;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;


public class KingdomTableBlock extends Block implements EntityBlock {

    private Player player;

    public KingdomTableBlock(Properties prop) {
        super(prop);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        this.player = (Player) placer;
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.has(DataComponents.FOOD) && KingdomEventManager.getInstance().isInKingdom(player.getUUID())) {
            KingdomEventManager.getInstance().addFood(player.getUUID(),stack.get(DataComponents.FOOD).nutrition(), stack);
            return InteractionResult.SUCCESS;

        } else {
            useWithoutItem(state, level, pos, player, hitResult);
        }
        return InteractionResult.FAIL;

    }

    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (player != null) {
            UUID kingdomID = KingdomEventManager.getInstance().getUser(player.getUUID()).getKingdomID();
            Kingdom kingdom = KingdomEventManager.getInstance().getKingdom(kingdomID);
            if (kingdom != null && !(kingdom.getCitizens().isEmpty())) {
                int value = kingdom.getCitizens().size() * 2;
                if (kingdom.getFoodSupply() >= value)
                kingdom.removeFoodSupply(value);
                NpcMain.LOGGER.error("removed food");
            }

        }
    }


    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            serverPlayer.openMenu(getMenu());
        }

        return InteractionResult.SUCCESS;
    }

    protected MenuProvider getMenu() {
        MenuProvider kingdomInterface = new SimpleMenuProvider((containerId, playerInventory, player1) -> new MenuKIC(containerId, playerInventory), Component.translatable("npc.gui.menu.menukic"));
        return kingdomInterface;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new KingdomTableBE(pos, state);
    }

}



