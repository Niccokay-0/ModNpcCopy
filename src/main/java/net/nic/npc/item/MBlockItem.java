package net.nic.npc.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

public class MBlockItem extends BlockItem {


    public MBlockItem(ResourceLocation name, Block block, Properties properties) {
        super(block, properties.setId(ResourceKey.create(Registries.ITEM, name)));
    }
}
