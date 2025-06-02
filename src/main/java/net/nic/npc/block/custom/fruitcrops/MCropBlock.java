package net.nic.npc.block.custom.fruitcrops;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MCropBlock extends CropBlock {

    public MCropBlock(ResourceLocation name, BlockBehaviour.Properties properties) {
        super(properties.setId(ResourceKey.create(Registries.BLOCK, name)));
    }

}
