package net.nic.npc.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.nic.npc.NpcMain;

import java.util.concurrent.CompletableFuture;

public class MBlockTagProvider extends BlockTagsProvider {

    public MBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider,NpcMain.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        System.out.println("📦 Running ModBlockProvider");
    }
}