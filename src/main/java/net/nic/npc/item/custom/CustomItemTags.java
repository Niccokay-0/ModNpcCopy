package net.nic.npc.item.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.nic.npc.NpcMain;

public class CustomItemTags {


    public static final TagKey<Item> UPGRADING_MATERIALS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "upgrading_materials"));


    public static final TagKey<Item> MUSKET_PROJECTILES = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "musket_projectiles"));

    public static final TagKey<Item> ENDSTONE_TOOL_MATERIALS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "endstone_tool_materials"));

    public static final TagKey<Item> LEAD_TOOL_MATERIALS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "lead_tool_materials"));

    public static final TagKey<Item> TUNGSTEN_TOOL_MATERIALS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "tungsten_tool_materials"));


    public static final TagKey<Item> BLAZED_ITEMS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "blazed_items"));

    public static final TagKey<Item> RINGENDER_ITEMS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "ender_items"));

    public static final TagKey<Item> PURPUR_ITEMS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "purpur_items"));

}
