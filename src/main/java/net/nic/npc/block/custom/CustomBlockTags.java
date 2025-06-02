package net.nic.npc.block.custom;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.nic.npc.NpcMain;

public class CustomBlockTags {

    public static final TagKey<Block> NETHER_WOODS = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "nether_woods"));

    public static final TagKey<Block> SOUL_GROUND = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "soul_ground"));

    public static final TagKey<Block> NETHER_TREE_FOLIAGE = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "nether_tree_foliage"));

    public static final TagKey<Block> END_BLOCKS = TagKey.create(
            Registries.BLOCK,
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "end_block"));
}
