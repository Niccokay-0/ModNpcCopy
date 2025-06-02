package net.nic.npc.block.custom.infuser;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.nic.npc.block.MEntityBlocks;

public class InfuserBlockBE extends BlockEntity {


    public InfuserBlockBE(BlockPos pos, BlockState blockState) {
        super(MEntityBlocks.INFUSED_BE.get(),pos,blockState);
    }
}
