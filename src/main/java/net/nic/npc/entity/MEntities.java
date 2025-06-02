package net.nic.npc.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nic.npc.NpcMain;
import net.nic.npc.entity.customEntity.npc.NPC;
import net.nic.npc.entity.customEntity.projectile.musket.MusketProjectileEntity;
import net.nic.npc.entity.customEntity.projectile.tieredArrow.TieredArrowEntity;

import java.util.function.Supplier;

public class MEntities {
    public static  final DeferredRegister.Entities ENTITY_TYPES = DeferredRegister.createEntities(NpcMain.MODID);


    public static final Supplier<EntityType<NPC>> NPC = ENTITY_TYPES.register("npc",
            ()-> EntityType.Builder.of(
                    NPC::new,
                    MobCategory.MISC).sized(0.6f,1.8f).build(
                            ResourceKey.create(
                                    Registries.ENTITY_TYPE,
                                    ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "npc"))));

    public static final Supplier<EntityType<TieredArrowEntity>> TIERED_ARROW =
            ENTITY_TYPES.register("tiered_arrow", () ->
                    EntityType.Builder.<TieredArrowEntity>of(TieredArrowEntity::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F)
                            .build(ResourceKey.create(Registries.ENTITY_TYPE,ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "tiered_arrow"))));

    public static final Supplier<EntityType<MusketProjectileEntity>> BULLET =
            ENTITY_TYPES.register("bullet", () ->
                    EntityType.Builder.<MusketProjectileEntity>of(MusketProjectileEntity::new, MobCategory.MISC)
                            .sized(0.5F, 0.5F)
                            .build(ResourceKey.create(Registries.ENTITY_TYPE,ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "bullet"))));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
