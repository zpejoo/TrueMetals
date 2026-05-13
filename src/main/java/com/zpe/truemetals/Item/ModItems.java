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
import net.minecraft.world.item.equipment.ArmorType;

import java.util.function.Function;

import static com.zpe.truemetals.Item.RosegoldItemMaterial.ROSEGOLD_TOOL_MATERIAL;
import static com.zpe.truemetals.Item.SteelItemMaterial.STEEL_TOOL_MATERIAL;

public class ModItems {

    public static final Item ROSEGOLD = registerItem("rosegold", Item::new, new Item.Properties());
    public static final Item STEEL = registerItem("steel", Item::new, new Item.Properties());

    public static final Item STEEL_PICKAXE = registerItem("steel_pickaxe", Item::new, new Item.Properties().pickaxe(STEEL_TOOL_MATERIAL, 1f, -2.8f));
    public static final Item ROSEGOLD_PICKAXE = registerItem("rosegold_pickaxe", Item::new, new Item.Properties().pickaxe(ROSEGOLD_TOOL_MATERIAL, 1f, -2.8f));


    public static final Item STEEL_HELMET = registerItem("steel_helmet", Item::new, new Item.Properties().humanoidArmor(SteelItemMaterial.INSTANCE, ArmorType.HELMET).durability(ArmorType.HELMET.getDurability(SteelItemMaterial.BASE_DURABILITY)));
    public static final Item STEEL_CHESTPLATE = registerItem("steel_chestplate", Item::new, new Item.Properties().humanoidArmor(SteelItemMaterial.INSTANCE, ArmorType.CHESTPLATE).durability(ArmorType.CHESTPLATE.getDurability(SteelItemMaterial.BASE_DURABILITY)));
    public static final Item STEEL_LEGGINGS = registerItem("steel_leggings", Item::new, new Item.Properties().humanoidArmor(SteelItemMaterial.INSTANCE, ArmorType.LEGGINGS).durability(ArmorType.LEGGINGS.getDurability(SteelItemMaterial.BASE_DURABILITY)));
    public static final Item STEEL_BOOTS = registerItem("steel_boots", Item::new, new Item.Properties().humanoidArmor(SteelItemMaterial.INSTANCE, ArmorType.BOOTS).durability(ArmorType.BOOTS.getDurability(SteelItemMaterial.BASE_DURABILITY)));

    public static final Item ROSEGOLD_HELMET = registerItem("rosegold_helmet", Item::new, new Item.Properties().humanoidArmor(RosegoldItemMaterial.INSTANCE, ArmorType.HELMET).durability(ArmorType.HELMET.getDurability(RosegoldItemMaterial.BASE_DURABILITY)));
    public static final Item ROSEGOLD_CHESTPLATE = registerItem("rosegold_chestplate", Item::new, new Item.Properties().humanoidArmor(RosegoldItemMaterial.INSTANCE, ArmorType.CHESTPLATE).durability(ArmorType.CHESTPLATE.getDurability(RosegoldItemMaterial.BASE_DURABILITY)));
    public static final Item ROSEGOLD_LEGGINGS = registerItem("rosegold_leggings", Item::new, new Item.Properties().humanoidArmor(RosegoldItemMaterial.INSTANCE, ArmorType.LEGGINGS).durability(ArmorType.LEGGINGS.getDurability(RosegoldItemMaterial.BASE_DURABILITY)));
    public static final Item ROSEGOLD_BOOTS = registerItem("rosegold_boots", Item::new, new Item.Properties().humanoidArmor(RosegoldItemMaterial.INSTANCE, ArmorType.BOOTS).durability(ArmorType.BOOTS.getDurability(RosegoldItemMaterial.BASE_DURABILITY)));


    private static Item registerItem(String name, Function<Item.Properties, Item> function, Item.Properties settings) {
        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, name),
                function.apply(settings.setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, name)))));
    }

    public static void registerModItem() {
        TrueMetals.LOGGER.info("Registering Mod Items for " + TrueMetals.MOD_ID);

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> output.accept(ROSEGOLD));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.INGREDIENTS).register(output -> output.accept(STEEL));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> output.accept(STEEL_PICKAXE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(output -> output.accept(ROSEGOLD_PICKAXE));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> output.accept(STEEL_HELMET));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> output.accept(STEEL_CHESTPLATE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> output.accept(STEEL_LEGGINGS));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> output.accept(STEEL_BOOTS));

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> output.accept(ROSEGOLD_HELMET));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> output.accept(ROSEGOLD_CHESTPLATE));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> output.accept(ROSEGOLD_LEGGINGS));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.COMBAT).register(output -> output.accept(ROSEGOLD_BOOTS));


    }
}
