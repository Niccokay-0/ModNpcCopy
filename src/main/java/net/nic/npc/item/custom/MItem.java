package net.nic.npc.item.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class MItem extends Item {



    public MItem(ResourceLocation name, Properties properties) {
        super(properties.setId(ResourceKey.create(Registries.ITEM, name)));
    }


}




