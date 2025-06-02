package net.nic.npc.item.custom.equipment.tools.blazed;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.nic.npc.item.custom.equipment.tools.general.MSwordItem;
import net.nic.npc.item.materials.CustomMaterials;

public class BlazedSwordItem extends MSwordItem {


    public BlazedSwordItem(ResourceLocation name, Properties properties, ToolMaterial material, float attackDamage, float attackSpeed) {
        super(name, properties.fireResistant(), material, attackDamage, attackSpeed);
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (toolMat == CustomMaterials.BLAZE && !target.fireImmune()) {
            target.igniteForSeconds(3);
        }
        super.hurtEnemy(stack, target, attacker);
    }

}
