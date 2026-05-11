package com.zpe.truemetals.Blocks;

import com.zpe.truemetals.Blocks.custom.BlockEntities.KilnBlockEntity;
import com.zpe.truemetals.TrueMetals;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;



public class ModBlockEntity {

    public static final BlockEntityType<KilnBlockEntity> KILN_BLOCK_ENTITY =
            register("kiln_block", KilnBlockEntity::new, ModBlocks.KILN_BLOCK);

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory, Block... blocks) {
        Identifier id = Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    public static void registerModBlockEntity() {
        TrueMetals.LOGGER.info("Registering Mod Block Entity for " + TrueMetals.MOD_ID);
    }
}
