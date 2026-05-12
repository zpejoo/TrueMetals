package com.zpe.truemetals.Blocks.custom.BlockEntities;

import com.zpe.truemetals.Blocks.ModBlockEntity;
import com.zpe.truemetals.Blocks.custom.BlockMenu.KilnBlockMenu;
import com.zpe.truemetals.Blocks.custom.ImplementedContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jspecify.annotations.Nullable;
import org.jspecify.annotations.NonNull;

public class KilnBlockEntity extends BlockEntity implements ImplementedContainer, MenuProvider {

//IMPLEMENTED_CONTAINER

    private final NonNullList<ItemStack> items = NonNullList.withSize(CONTAINER_SIZE, ItemStack.EMPTY);
    public static final int CONTAINER_SIZE = 2 * 2;

    public KilnBlockEntity(BlockPos worldPosition, BlockState blockState) {
        super(ModBlockEntity.KILN_BLOCK_ENTITY, worldPosition, blockState);
    }

    @Override
    public NonNullList<ItemStack> getItems() { return this.items; }
//IMPLEMENTED_CONTAINER

//MENU_PROVIDER
    @Override
    @NonNull
    public Component getDisplayName() {
        return Component.translatable("block.truemetals.kiln_block");
    }

    @Override
    @Nullable
    public AbstractContainerMenu createMenu(int containerId, Inventory inventory, Player player) {
            return new KilnBlockMenu(containerId, inventory, this);
    }
//MENU_PROVIDER

    //O que o block faz


    //Função para salvar MetaData ou NBT (?)

    @Override
    protected void saveAdditional(ValueOutput output) {
        ContainerHelper.saveAllItems(output, this.items);
        super.saveAdditional(output);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        ContainerHelper.loadAllItems(input, this.items);
        super.loadAdditional(input);
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
