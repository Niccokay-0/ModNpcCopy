package net.nic.npc.item.custom.equipment.tools.blazed;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.nic.npc.item.custom.equipment.tools.general.MPickaxeItem;

public class BlazedPickaxeItem extends MPickaxeItem {



    public BlazedPickaxeItem(ResourceLocation name, Properties properties, ToolMaterial material, float attackDamage, float attackSpeed) {
        super(name, properties.fireResistant(), material, attackDamage, attackSpeed);
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
