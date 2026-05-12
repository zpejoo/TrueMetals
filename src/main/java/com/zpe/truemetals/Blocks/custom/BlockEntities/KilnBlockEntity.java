package com.zpe.truemetals.Blocks.custom.BlockEntities;

import com.zpe.truemetals.Blocks.ModBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

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

    //Função para salvar MetaData ou NBT (?)

    @Override
    protected void saveAdditional(ValueOutput output) {
        output.putInt("clicks", this.clicks);

        super.saveAdditional(output);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);

        this.clicks = input.getIntOr("clicks", 0);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registryLookup) {
        return saveWithoutMetadata(registryLookup);
    }

    //Funções pra funcionar no multiplayer

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void setChanged() {
        super.setChanged();

        if (level == null) return;

        BlockState state = getBlockState();
        level.sendBlockUpdated(worldPosition, state, state, Block.UPDATE_ALL);
    }

}
