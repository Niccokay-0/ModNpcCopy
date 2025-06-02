package net.nic.npc.item.custom.equipment.tools.blazed;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.nic.npc.block.custom.CustomBlockTags;
import net.nic.npc.item.custom.equipment.tools.general.MAxeItem;
import net.nic.npc.item.materials.CustomMaterials;

public class BlazedAxeItem extends MAxeItem {


    public BlazedAxeItem(ResourceLocation name, Properties properties, ToolMaterial material, float attackDamage, float attackSpeed) {
        super(name, properties.fireResistant(), material, attackDamage, attackSpeed);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (toolMat == CustomMaterials.BLAZE && !target.fireImmune()) {
            target.igniteForSeconds(3);
        }
        super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miningEntity) {
        if (state.is(CustomBlockTags.NETHER_WOODS)) {
            stack.hurtAndBreak(-1,miningEntity,stack.getEquipmentSlot());
        }
        return super.mineBlock(stack, level, state, pos, miningEntity);
    }

}
