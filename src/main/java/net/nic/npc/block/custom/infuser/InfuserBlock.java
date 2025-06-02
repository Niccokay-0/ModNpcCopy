package net.nic.npc.block.custom.infuser;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.nic.npc.block.custom.MBlock;
import net.nic.npc.item.MDataComponents;
import net.nic.npc.item.custom.CustomItemTags;
import net.nic.npc.item.custom.equipment.tools.general.MTool;
import org.jetbrains.annotations.Nullable;

public class InfuserBlock extends MBlock implements EntityBlock {

    private ItemStack tool;
    private ItemStack ingredient;

    public InfuserBlock(ResourceLocation name, Properties properties) {
        super(name, properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new InfuserBlockBE(pos, state);
    }


    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        boolean shouldConsume = false;
        // Ensure tool is initialized
        if (this.tool == null) {
            this.tool = ItemStack.EMPTY;
        }

        // If the player is holding a tool
        if (stack.getItem() instanceof MTool toolItem) {
            this.tool = stack.copy(); // Save the tool being upgraded
            player.getInventory().removeItem(stack); // Remove it from inventory
            return InteractionResult.SUCCESS;
        }

        // If the player is holding an upgrade material
        if (stack.is(CustomItemTags.UPGRADING_MATERIALS)) {
            if (!this.tool.isEmpty() && this.tool.getItem() instanceof MTool itemToUpgrade) {

                if (stack.is(Items.QUARTZ)) {
                    if (!this.tool.has(MDataComponents.DIG_MINING_UPGRADE)) {
                        itemToUpgrade.addMiningSpeed(this.tool, stack); //mining speed max 64
                        shouldConsume = true;
                    }
                }

                if (stack.is(Items.EMERALD_BLOCK)) {
                    if (!this.tool.has(MDataComponents.ISENDURED)) {
                        switch (stack.getCount()) {
                            case 1 -> {
                                itemToUpgrade.upgradeDurability(this.tool, 1);
                                stack.shrink(1); // Consume the upgrade material
                            }
                            case 2 -> {
                                itemToUpgrade.upgradeDurability(this.tool, 2);
                                stack.shrink(2); // Consume the upgrade material

                            }
                            default -> {
                                itemToUpgrade.upgradeDurability(this.tool, 3); // Max level 3
                                stack.shrink(3); // Consume the upgrade material
                            }
                        }
                    }
                }

                if (stack.is(Items.EMERALD_BLOCK)) {
                } else if (shouldConsume) {
                    player.getInventory().removeItem(stack); // Consume the upgrade material
                }
                return InteractionResult.SUCCESS;
            }
        }
        // If the player is holding nothing and there's a tool stored
        if (!level.isClientSide && !this.tool.isEmpty()) {
            ItemEntity dropped = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, this.tool.copy());
            level.addFreshEntity(dropped);
            this.tool = ItemStack.EMPTY;
            return InteractionResult.SUCCESS;
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }


    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        if (!level.isClientSide && !this.tool.isEmpty()) {
            ItemEntity dropped = new ItemEntity(level, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, this.tool.copy());
            level.addFreshEntity(dropped);
            this.tool = ItemStack.EMPTY;
        }
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
    }


}
