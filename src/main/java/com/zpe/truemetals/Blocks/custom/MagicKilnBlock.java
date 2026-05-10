package com.zpe.truemetals.Blocks.custom;

import com.zpe.truemetals.Item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class MagicKilnBlock extends Block {
    public MagicKilnBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {

        level.playSound(player, pos, SoundEvents.PLAYER_LEVELUP, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState onState, Entity entity) {

        if (entity instanceof ItemEntity itemEntity) {
            if (itemEntity.getItem().getItem() == Items.GOLD_INGOT) {
                itemEntity.setItem(new ItemStack(ModItems.ROSEGOLD, itemEntity.getItem().getCount()));
            }

            if (itemEntity.getItem().getItem() == Items.IRON_INGOT) {
                itemEntity.setItem(new ItemStack(ModItems.STEEL, itemEntity.getItem().getCount()));
            }
        }

        super.stepOn(level, pos, onState, entity);
    }


}