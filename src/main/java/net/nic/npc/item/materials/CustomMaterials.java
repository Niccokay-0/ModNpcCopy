package net.nic.npc.item.materials;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.nic.npc.item.custom.CustomItemTags;

import java.util.EnumMap;

public class CustomMaterials {

    public static final ArmorMaterial BLAZEDARMOR = new ArmorMaterial(40, Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, 4);
                attribute.put(ArmorType.LEGGINGS, 8);
                attribute.put(ArmorType.CHESTPLATE, 9);
                attribute.put(ArmorType.HELMET, 5);
            }),
            10,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            3.5f,
            0.15f,
            CustomItemTags.BLAZED_ITEMS,
            CustomEquipmentAssets.BLAZED
    );

    public static final ArmorMaterial RINGENDERARMOR = new ArmorMaterial(28, Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, 3);
                attribute.put(ArmorType.LEGGINGS, 8);
                attribute.put(ArmorType.CHESTPLATE, 8);
                attribute.put(ArmorType.HELMET, 4);
            }),
            31,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            3.2f,
            0.15f,
            CustomItemTags.RINGENDER_ITEMS,
            CustomEquipmentAssets.RINGENDER
    );

    public static final ArmorMaterial PURPURARMOR = new ArmorMaterial(14, Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, 4);
                attribute.put(ArmorType.LEGGINGS, 9);
                attribute.put(ArmorType.CHESTPLATE, 10);
                attribute.put(ArmorType.HELMET, 2);
            }),
            15,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.5f,
            0.15f,
            CustomItemTags.PURPUR_ITEMS,
            CustomEquipmentAssets.PURPUR
    );


    public static final ToolMaterial BLAZE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1696,
            20.0f,
            3.2f,
            12,
            CustomItemTags.BLAZED_ITEMS
    );


    public static final ToolMaterial RINGENDER = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1024,
            23f,
            3.0f,
            31,
            CustomItemTags.BLAZED_ITEMS
    );

    public static final ToolMaterial PURPUR = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1916,
            19f,
            3.6f,
            9,
            CustomItemTags.PURPUR_ITEMS
    );


    /**
     *     public static final ToolMaterial STONE = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 131, 4.0F, 1.0F, 5, ItemTags.STONE_TOOL_MATERIALS);
     */
    public static final ToolMaterial ENDSTONE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL,
            242,
            6.5f,
            1.2f,
            5,
            CustomItemTags.ENDSTONE_TOOL_MATERIALS
    );
    public static final ToolMaterial LEAD = new ToolMaterial(
            BlockTags.INCORRECT_FOR_IRON_TOOL, 85, 3.0F, 0.5F, 4, CustomItemTags.LEAD_TOOL_MATERIALS
    );

    public static final ToolMaterial TUNGSTEN = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 2035, 7.0F, 4.0F, 8, CustomItemTags.TUNGSTEN_TOOL_MATERIALS
    );

    public static final ToolMaterial PHOSPHORUS = new ToolMaterial(
            BlockTags.INCORRECT_FOR_WOODEN_TOOL, 50, 5.5F, 0.8F, 25, ItemTags.WOODEN_TOOL_MATERIALS
    );




//    deliberated error //todo NORMAL ENDER VARSS

}
