package com.zpe.truemetals.Item;

import com.zpe.truemetals.Blocks.ModBlocks;
import com.zpe.truemetals.TrueMetals;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {

    public static final CreativeModeTab TRUEMETALS_ITEMS_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, "truemetals_items")
            , CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0).icon(() -> new ItemStack(ModItems.STEEL))
            .title(Component.translatable("crativemodetab.truemetals.truemetals_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.STEEL);
                        output.accept(ModBlocks.STEEL_BLOCK);
                        output.accept(ModItems.ROSEGOLD);
                        output.accept(ModBlocks.ROSEGOLD_BLOCK);

                    }).build());

    public static void registerItemGroup() {
        TrueMetals.LOGGER.info("Registering Item Groups for " + TrueMetals.MOD_ID);
    }
}
