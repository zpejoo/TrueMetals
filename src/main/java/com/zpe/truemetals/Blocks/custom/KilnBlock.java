package com.zpe.truemetals.Blocks.custom;

import com.mojang.serialization.MapCodec;
import com.zpe.truemetals.Blocks.custom.BlockEntities.KilnBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
        if (!level.isClientSide() && level.getBlockEntity(pos) instanceof KilnBlockEntity kilnBlock) {
            player.openMenu(kilnBlock);
        }
        return InteractionResult.SUCCESS;
    }

//    @Override
//    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
//        if (!(level.getBlockEntity(pos) instanceof KilnBlockEntity kilnBlockEntity)) {
//            return InteractionResult.PASS;
//        }
//
//        if (!player.getItemInHand(hand).isEmpty() && kilnBlockEntity.isEmpty()) {
//            kilnBlockEntity.setItem(0, player.getItemInHand(hand).copy());
//            player.getItemInHand(hand).setCount(0);
//        }
//
//        return InteractionResult.SUCCESS;
//    }
}
