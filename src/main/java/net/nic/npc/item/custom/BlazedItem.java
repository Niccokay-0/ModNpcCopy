package net.nic.npc.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class BlazedItem extends MItem {


    public BlazedItem(ResourceLocation name, Properties properties) {
        super(name, properties);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.fireImmune()) {
            target.igniteForTicks(60);
        }
        else{
            stack.hurtAndBreak(-1,attacker,stack.getEquipmentSlot());
        }
        super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miningEntity) {
        if (state.is(BlockTags.NETHER_CARVER_REPLACEABLES)) {
            stack.hurtAndBreak(-1,miningEntity,stack.getEquipmentSlot());
        }
        return super.mineBlock(stack, level, state, pos, miningEntity);
    }
}
