package net.nic.npc.block.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.nic.npc.item.MItems;

public class MCropBlock extends CropBlock {

    public MCropBlock(ResourceLocation name, BlockBehaviour.Properties properties) {
        super(properties.setId(ResourceKey.create(Registries.BLOCK, name)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.AGE_3);
    }

    @Override
    protected IntegerProperty getAgeProperty() {
        return BlockStateProperties.AGE_3;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return MItems.STRAWBERRY.get();
    }

    @Override
    public BlockState getStateForAge(int age) {
        return super.getStateForAge(age);
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return 1;
    }

}
