package net.nic.npc.block.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MBlock extends Block {

    public MBlock(ResourceLocation name, BlockBehaviour.Properties properties) {
        super(properties.setId(ResourceKey.create(Registries.BLOCK, name)));
    }
}
