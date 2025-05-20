package net.nic.npc.item.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BlazedArmor extends MItem {



    public BlazedArmor(ResourceLocation name, Item.Properties properties) {

        super(name, properties);
    }


    @Override
    public boolean canBeHurtBy(ItemStack stack, DamageSource source) {
        source.getDirectEntity().igniteForSeconds(3);
        return super.canBeHurtBy(stack, source);
    }
}
