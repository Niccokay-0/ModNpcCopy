package net.nic.npc.item.materials;


import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.nic.npc.NpcMain;

import java.util.function.BiConsumer;

public class CustomEquipmentAssets {


    private static final ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(ResourceLocation.withDefaultNamespace("equipment_asset"));



    public static final ResourceKey<EquipmentAsset> BLAZED = id("blazed");


    private static ResourceKey<EquipmentAsset> id(String name) {
        return ResourceKey.create(ROOT_ID, ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, name));
    }

    public static void bootstrap(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> consumer) {
        consumer.accept(CustomEquipmentAssets.BLAZED, onlyHumanoid("blazed"));

        //for more EQUIPMENT ASSETS -> consumer.accept(THE KEY, onlyHumanoid(id)); ONLY FOR HUMANOID ARMORS
    }

    private static EquipmentClientInfo onlyHumanoid(String name)
    {
        return EquipmentClientInfo.builder().addHumanoidLayers(ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, name)).build();
    }
}
