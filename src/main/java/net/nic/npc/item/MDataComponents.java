package net.nic.npc.item;

import com.mojang.serialization.Codec;
import net.minecraft.core.UUIDUtil;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nic.npc.NpcMain;

import java.util.UUID;

public class MDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, NpcMain.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> SHOTS =
            DATA_COMPONENT_TYPES.register("shots", () ->
                    DataComponentType.<Integer>builder()
                            .persistent(Codec.INT)
                            .build()
            );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Float>> DIG_MINING_UPGRADE =
            DATA_COMPONENT_TYPES.register("dig_mining_upgrade", () ->
                    DataComponentType.<Float>builder()
                            .persistent(Codec.FLOAT)
                            .build()
            );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Boolean>> ISENDURED =
            DATA_COMPONENT_TYPES.register("isendured", () ->
                    DataComponentType.<Boolean>builder()
                            .persistent(Codec.BOOL)
                            .build()
            );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> REMAININGUPGRADES =
            DATA_COMPONENT_TYPES.register("remainingupgrades", () ->
                    DataComponentType.<Integer>builder()
                            .persistent(Codec.INT)
                            .build()
            );

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> DURABILITY_UPGRADE_AMOUNT =
            DATA_COMPONENT_TYPES.register("durability_upgrade_amount", () ->
                    DataComponentType.<Integer>builder()
                            .persistent(Codec.INT)
                            .build()
            );


    public static final DeferredHolder<DataComponentType<?>, DataComponentType<UUID>> KINGDOM_ID =
            DATA_COMPONENT_TYPES.register("kingdomid", () ->
                    DataComponentType.<UUID>builder()
                            .persistent(Codec.STRING.xmap(UUID::fromString, UUID::toString))
                            .networkSynchronized(UUIDUtil.STREAM_CODEC)
                            .build());




    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
