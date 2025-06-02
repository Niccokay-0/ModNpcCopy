package net.nic.npc.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.nic.npc.NpcMain;
import net.nic.npc.block.custom.CustomBlockTags;

import java.util.concurrent.CompletableFuture;

public class MBlockTagProvider extends BlockTagsProvider {

    public MBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider,NpcMain.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        System.out.println("📦 Running ModBlockProvider");
        tag(CustomBlockTags.NETHER_WOODS).add(

                Blocks.CRIMSON_STEM,
                Blocks.STRIPPED_CRIMSON_STEM,
                Blocks.CRIMSON_HYPHAE,
                Blocks.STRIPPED_CRIMSON_HYPHAE,
                Blocks.CRIMSON_PLANKS,
                Blocks.CRIMSON_FENCE,
                Blocks.CRIMSON_FENCE_GATE,
                Blocks.CRIMSON_SLAB,
                Blocks.CRIMSON_STAIRS,
                Blocks.CRIMSON_DOOR,
                Blocks.CRIMSON_TRAPDOOR,
                Blocks.CRIMSON_PRESSURE_PLATE,
                Blocks.CRIMSON_BUTTON,
                Blocks.CRIMSON_SIGN,
                Blocks.CRIMSON_WALL_SIGN,
                Blocks.CRIMSON_HANGING_SIGN,
                Blocks.CRIMSON_WALL_HANGING_SIGN,

                Blocks.WARPED_STEM,
                Blocks.STRIPPED_WARPED_STEM,
                Blocks.WARPED_HYPHAE,
                Blocks.STRIPPED_WARPED_HYPHAE,
                Blocks.WARPED_PLANKS,
                Blocks.WARPED_FENCE,
                Blocks.WARPED_FENCE_GATE,
                Blocks.WARPED_SLAB,
                Blocks.WARPED_STAIRS,
                Blocks.WARPED_DOOR,
                Blocks.WARPED_TRAPDOOR,
                Blocks.WARPED_PRESSURE_PLATE,
                Blocks.WARPED_BUTTON,
                Blocks.WARPED_SIGN,
                Blocks.WARPED_WALL_SIGN,
                Blocks.WARPED_HANGING_SIGN,
                Blocks.WARPED_WALL_HANGING_SIGN
        );

        tag(CustomBlockTags.SOUL_GROUND).add(
                Blocks.SOUL_SAND,
                Blocks.SOUL_SOIL
        );

        tag(CustomBlockTags.NETHER_TREE_FOLIAGE).add(
                Blocks.NETHER_WART_BLOCK,
                Blocks.WARPED_WART_BLOCK,
                Blocks.SHROOMLIGHT
        );

        tag(CustomBlockTags.END_BLOCKS).add(
                Blocks.END_STONE,
                Blocks.END_STONE_BRICKS,
                Blocks.PURPUR_BLOCK,
                Blocks.PURPUR_PILLAR,
                Blocks.PURPUR_SLAB,
                Blocks.PURPUR_STAIRS,
                Blocks.END_ROD,
                Blocks.CHORUS_FLOWER,
                Blocks.CHORUS_PLANT,
                Blocks.OBSIDIAN
        );


    }
}