package com.zpe.truemetals.Item;

import com.zpe.truemetals.TrueMetals;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class SteelItemMaterial {

    public static final TagKey<Item> REPAIRS_STEEL_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, "repairs_steel_armor"));
    public static final ResourceKey<EquipmentAsset> STEEL_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, "steel"));


    public static final ToolMaterial STEEL_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            500,
            7.0F,
            2.5F,
            11,
            SteelItemMaterial.REPAIRS_STEEL_ARMOR
    );

    public static final int BASE_DURABILITY = 20;

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                ArmorType.HELMET, 3,
                ArmorType.CHESTPLATE, 8,
                ArmorType.LEGGINGS, 5,
                ArmorType.BOOTS, 3),
            11,
            SoundEvents.ARMOR_EQUIP_IRON,
            2f,
            0.0f,
            SteelItemMaterial.REPAIRS_STEEL_ARMOR,
            SteelItemMaterial.STEEL_ARMOR_MATERIAL_KEY
    );
}
