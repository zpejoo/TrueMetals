package com.zpe.truemetals.Blocks;

import com.zpe.truemetals.Blocks.custom.MagicKilnBlock;
import com.zpe.truemetals.TrueMetals;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {

    public static final Block ROSEGOLD_BLOCK = registerBlock("rosegold_block",
            new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, "rosegold_block")))
                    .strength(4.0f, 4.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));


    public static final Block STEEL_BLOCK = registerBlock("steel_block",
            new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, "steel_block")))
                    .strength(4.0f, 4.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.METAL)));

    public static final Block KILN_BLOCK = registerBlock("kiln_block",
            new MagicKilnBlock(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, "kiln_block")))
                    .strength(2.0f, 1.0f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.BONE_BLOCK)));


//HELPERS PRA REGISTRAR OS BLOCOS NOVOS v

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, name),
                new BlockItem(block, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, name)))));

    }

    public static void registerModBlocks() {
        TrueMetals.LOGGER.info("Registering Mod Blocks for " + TrueMetals.MOD_ID);


        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output -> output.accept(STEEL_BLOCK));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(output -> output.accept(ROSEGOLD_BLOCK));
    }
}
