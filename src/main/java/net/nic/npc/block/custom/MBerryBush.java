package net.nic.npc.block.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class MBerryBush extends SweetBerryBushBlock {


    public MBerryBush(ResourceLocation name, BlockBehaviour.Properties properties) {
        super(properties.setId(ResourceKey.create(Registries.BLOCK, name)));
    }


    /**
     @Override
     protected ItemStack getCloneItemStack(LevelReader p_304655_, BlockPos p_57257_, BlockState p_57258_, boolean p_388022_) {
          return new ItemStack(MItems.BLUEBERRY.get());
     }




    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }



    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos bPos, Player player, BlockHitResult hitResult) {
        int i = state.getValue(AGE);
        boolean flag = i == 3;
        if (i > 1) {
            int j = 1 + level.random.nextInt(2);
            popResource(level, bPos, new ItemStack(MItems.BLUEBERRY.get(), j + (flag ? 1 : 0)));
            level.playSound(
                    null, bPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F
            );
            BlockState blockstate = state.setValue(AGE, 1);
            level.setBlock(bPos, blockstate, 2);
            level.gameEvent(GameEvent.BLOCK_CHANGE, bPos, GameEvent.Context.of(player, blockstate));
            return InteractionResult.SUCCESS;
        } else {
            return super.useWithoutItem(state, level, bPos, player, hitResult);
        }
    }
     */
}
