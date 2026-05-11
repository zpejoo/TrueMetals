package com.zpe.truemetals.Blocks.custom.BlockEntities;

import com.zpe.truemetals.Blocks.ModBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class KilnBlockEntity extends BlockEntity {
    public KilnBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(ModBlockEntity.KILN_BLOCK_ENTITY, worldPosition, blockState);
    }


    private int clicks = 0;
    public int getClicks() {
        return clicks;
    }

    public void incrementClicks() {
        clicks++;
        setChanged();
    }


}
