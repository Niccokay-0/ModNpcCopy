package net.nic.npc.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.nic.npc.item.materials.CustomMaterials;

public class MHoeItem extends HoeItem {


    private ToolMaterial toolMat;

    public MHoeItem(ToolMaterial material, float attackDamage, float attackSpeed, Properties properties, ResourceLocation name) {
        super(material, attackDamage, attackSpeed, properties.setId(ResourceKey.create(Registries.ITEM, name)));
        toolMat = material;
    }

    @Override
    public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (toolMat == CustomMaterials.BLAZE && !target.fireImmune()) {
            target.igniteForSeconds(3);
        }
        super.hurtEnemy(stack, target, attacker);
    }

    /**
    public MHoeItem(ResourceLocation name, Properties properties) {
        super(properties.setId(ResourceKey.create(Registries.ITEM, name)));
    }

     */

}
