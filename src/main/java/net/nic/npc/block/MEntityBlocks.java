package net.nic.npc.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nic.npc.NpcMain;
import net.nic.npc.block.custom.kingdomBlock.KingdomTableBE;

import java.util.function.Supplier;

public class MEntityBlocks {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, NpcMain.MODID);


    public static final Supplier<BlockEntityType<KingdomTableBE>> KINGDOM_TABLE_BE = BLOCK_ENTITY_TYPES.register(
            "kingdom_table_be",
            name -> new BlockEntityType<>(
                    KingdomTableBE::new,
                    MBlocks.KINGDOM_BLOCK.get()));





    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY_TYPES.register(eventBus);
    }

}
