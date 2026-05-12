package com.zpe.truemetals.Item;

import com.zpe.truemetals.TrueMetals;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;

import java.util.function.Function;

import static com.zpe.truemetals.Item.SteelItemMaterial.STEEL_TOOL_MATERIAL;

public class ModItems {

    public static final Item ROSEGOLD = registerItem("rosegold", Item::new, new Item.Properties());
    public static final Item STEEL = registerItem("steel", Item::new, new Item.Properties());
    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe", Item::new, new Item.Properties().pickaxe(STEEL_TOOL_MATERIAL, 1f, -2.8f));

    private static Item registerItem(String name, Function<Item.Properties, Item> function, Item.Properties settings) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, name),
                function.apply(settings.setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, name)))));
    }

    public static void registerModItem() {
        TrueMetals.LOGGER.info("Registering Mod Items for " + TrueMetals.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> output.accept(ROSEGOLD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> output.accept(STEEL));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> output.accept(STEEL_PICKAXE));

    }
}
