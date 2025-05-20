package net.nic.npc.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.nic.npc.NpcMain;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;


@EventBusSubscriber(modid = NpcMain.MODID, bus = EventBusSubscriber.Bus.MOD)
public class MDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        System.out.println("📦 MDataGenerator triggered");
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        MEquipAssetProv equipmentAssetProvider = new MEquipAssetProv(output, NpcMain.MODID);

        var blockTags = new MBlockTagProvider(output, lookupProvider);
        generator.addProvider(true, blockTags);
        generator.addProvider(true, new MItemTagProvider(output, lookupProvider, blockTags));
        generator.addProvider(true, new MModelGen(output));
        generator.addProvider(true, equipmentAssetProvider);
        generator.addProvider(true, new LootTableProvider(output, Set.of(), List.of(new LootTableProvider.SubProviderEntry(MBlockLootSubProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

    }
}
