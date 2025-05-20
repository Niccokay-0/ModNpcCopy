package net.nic.npc.creativeTabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nic.npc.NpcMain;
import net.nic.npc.block.MBlocks;
import net.nic.npc.item.MItems;

import java.util.function.Supplier;

public class MCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NpcMain.MODID);


    public static final Supplier<CreativeModeTab> NPCCREATIVETAB = TAB.register("npc_creative_tab",
            tab -> CreativeModeTab.builder().icon(() -> new ItemStack(MBlocks.KINGDOM_BLOCK.get())).title(Component.translatable("npc.creative.tab.default"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(MBlocks.KINGDOM_BLOCK.get());
                        output.accept(MItems.WOODEN_ARROW.get());
                        output.accept(MItems.STONE_ARROW.get());
                        output.accept(MItems.IRON_ARROW.get());
                        output.accept(MItems.GOLDEN_ARROW.get());
                        output.accept(MItems.DIAMOND_ARROW.get());
                        output.accept(MItems.NETHERITE_ARROW.get());

                        output.accept(MItems.BLAZED_PICKAXE.get());
                        output.accept(MItems.BLAZED_SWORD.get());
                        output.accept(MItems.BLAZED_AXE.get());
                        output.accept(MItems.BLAZED_HOE.get());
                        output.accept(MItems.BLAZED_SHOVEL.get());

                        output.accept(MItems.BLAZED_HELMET.get());
                        output.accept(MItems.BLAZED_CHESTPLATE.get());
                        output.accept(MItems.BLAZED_LEGGINGS.get());
                        output.accept(MItems.BLAZED_BOOTS.get());

                        output.accept(MItems.LEMON.get());
                        output.accept(MItems.MANGO.get());
                        output.accept(MItems.BANANA.get());
                        output.accept(MItems.PEACH.get());
                        output.accept(MItems.KIWI.get());
                        output.accept(MItems.AVOCADO.get());
                        output.accept(MItems.BLUEBERRY.get());
                        output.accept(MItems.PINEAPPLE.get());
                        output.accept(MItems.STRAWBERRY.get());

                    }).build());




    public static void register(IEventBus eventBus) {
        TAB.register(eventBus);
    }
}
