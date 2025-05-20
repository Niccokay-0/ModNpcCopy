package net.nic.npc.entity;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.nic.npc.entity.customEntity.npc.NPC;

public class MEntityAttributes {


    private static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(MEntities.NPC.get(), NPC.createAttributes().build());
    }

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(MEntityAttributes::registerAttributes);
    }
}