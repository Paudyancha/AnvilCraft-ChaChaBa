package dev.anvilcraft.ccb.block;

import dev.anvilcraft.ccb.init.CCBBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class CementWormBlock extends WormBlock {
    public CementWormBlock(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return CCBBlockEntities.CEMENT_WORM_BLOCK_BLOCK_ENTITY.create(pos, state);
    }
}
