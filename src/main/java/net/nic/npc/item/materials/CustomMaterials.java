package net.nic.npc.item.materials;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.nic.npc.item.custom.CustomTags;

import java.util.EnumMap;

public class CustomMaterials {

    public static final ArmorMaterial BLAZEDARMOR = new ArmorMaterial(35, Util.make(new EnumMap<>(ArmorType.class),
            attribute -> {
                attribute.put(ArmorType.BOOTS, 2);
                attribute.put(ArmorType.LEGGINGS, 7);
                attribute.put(ArmorType.CHESTPLATE, 9);
                attribute.put(ArmorType.HELMET, 2);
            }),
            10,
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            3.0f,
            0.05f,
            CustomTags.BLAZED_ITEMS,
            CustomEquipmentAssets.BLAZED
    );


    public static final ToolMaterial BLAZE = new ToolMaterial(
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            1796,
            10.5f,
            3.0f,
            17,
            CustomTags.BLAZED_ITEMS
    );
}
