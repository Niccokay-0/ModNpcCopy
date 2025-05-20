package net.nic.npc.item.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.nic.npc.NpcMain;

public class CustomTags {

    public static final TagKey<Item> BLAZED_ITEMS = TagKey.create(
            Registries.ITEM,
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "blazed_items"));

}
