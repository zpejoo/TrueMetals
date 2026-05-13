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

public class RosegoldItemMaterial {

    public static final TagKey<Item> REPAIRS_ROSEGOLD_ARMOR = TagKey.create(BuiltInRegistries.ITEM.key(), Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, "repairs_rosegold_armor"));
    public static final ResourceKey<EquipmentAsset> ROSEGOLD_ARMOR_MATERIAL_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(TrueMetals.MOD_ID, "rosegold"));


    public static final ToolMaterial ROSEGOLD_TOOL_MATERIAL = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            190,
            8.0F,
            1F,
            25,
            RosegoldItemMaterial.REPAIRS_ROSEGOLD_ARMOR
    );

    public static final int BASE_DURABILITY = 9;

    public static final ArmorMaterial INSTANCE = new ArmorMaterial(
            BASE_DURABILITY,
            Map.of(
                    ArmorType.HELMET, 2,
                    ArmorType.CHESTPLATE, 5,
                    ArmorType.LEGGINGS, 3,
                    ArmorType.BOOTS, 1),
            25,
            SoundEvents.ARMOR_EQUIP_GOLD,
            0f,
            0.0f,
            RosegoldItemMaterial.REPAIRS_ROSEGOLD_ARMOR,
            RosegoldItemMaterial.ROSEGOLD_ARMOR_MATERIAL_KEY
    );
}
