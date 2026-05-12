package com.zpe.truemetals.Blocks.custom;

import com.mojang.serialization.MapCodec;
import com.zpe.truemetals.Blocks.custom.BlockEntities.KilnBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;

public class KilnBlock extends BaseEntityBlock {

    public KilnBlock(Properties settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return simpleCodec(KilnBlock::new);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
        return new KilnBlockEntity(worldPosition, blockState);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (!(level.getBlockEntity(pos) instanceof KilnBlockEntity kilnBlockEntity)) {
            return super.useWithoutItem(state, level, pos, player, hit);
        }

        kilnBlockEntity.incrementClicks();

        if (level.isClientSide()) {
            player.sendOverlayMessage(Component.literal("You've clicked the block for the " + kilnBlockEntity.getClicks() + "th time."));
        }

        return InteractionResult.SUCCESS;
    }
}
