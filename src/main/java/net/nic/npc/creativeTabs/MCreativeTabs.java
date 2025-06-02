package net.nic.npc.creativeTabs;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nic.npc.NpcMain;
import net.nic.npc.item.MItems;

import java.util.function.Supplier;

public class MCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NpcMain.MODID);

    public static String EQUIPMENT_TAB_STRING = "npc.creative.tab.equipment";
    public static String BOOKS_TAB_STRING = "npc.creative.tab.books";
    public static String FOOD_TAB_STRING = "npc.creative.tab.food";


    public static final Supplier<CreativeModeTab> EQUIPMENT_TAB = TAB.register("equipment_tab",
            tab -> CreativeModeTab.builder().icon(() -> new ItemStack(MItems.PURPUR_SWORD.get()))
                    .title(Component.translatable(EQUIPMENT_TAB_STRING))
                    .displayItems((params, output) -> {
                        // Weapons & Tools




                        output.accept(MItems.PURPUR_SMITHING_UPGRADE.get());
                        output.accept(MItems.PURPURED_NETHERITE_INGOT.get());

                        output.accept(MItems.PURPUR_HELMET.get());
                        output.accept(MItems.PURPUR_CHESTPLATE.get());
                        output.accept(MItems.PURPUR_LEGGINGS.get());
                        output.accept(MItems.PURPUR_BOOTS.get());

                        output.accept(MItems.PURPUR_SWORD.get());
                        output.accept(MItems.PURPUR_PICKAXE.get());
                        output.accept(MItems.PURPUR_AXE.get());
                        output.accept(MItems.PURPUR_CROSSBOW.get());
                        output.accept(MItems.PURPUR_MUSKET.get());


                        output.accept(MItems.RINGENDER_SMITHING_UPGRADE.get());
                        output.accept(MItems.RINGENDER_NETHERITE_INGOT.get());

                        output.accept(MItems.RINGENDER_HOOD.get());
                        output.accept(MItems.RINGENDER_COAT.get());
                        output.accept(MItems.RINGENDER_CLOAK.get());

                        output.accept(MItems.RINGENDER_SWORD.get());
                        output.accept(MItems.RINGENDER_PICKAXE.get());
                        output.accept(MItems.RINGENDER_AXE.get());


                        output.accept(MItems.BLAZING_SMITHING_UPGRADE.get());
                        output.accept(MItems.BLAZING_NETHERITE_INGOT.get());

                        output.accept(MItems.BLAZED_HELMET.get());
                        output.accept(MItems.BLAZED_CHESTPLATE.get());
                        output.accept(MItems.BLAZED_LEGGINGS.get());
                        output.accept(MItems.BLAZED_BOOTS.get());

                        output.accept(MItems.BLAZED_SWORD.get());
                        output.accept(MItems.BLAZED_PICKAXE.get());
                        output.accept(MItems.BLAZED_AXE.get());
                        output.accept(MItems.BLAZED_HOE.get());
                        output.accept(MItems.BLAZED_SHOVEL.get());
                    }).build());

    public static final Supplier<CreativeModeTab> BOOKS_TAB = TAB.register("books_tab",
            tab -> CreativeModeTab.builder().icon(() -> new ItemStack(MItems.TEST_BOOK.get()))
                    .title(Component.translatable(BOOKS_TAB_STRING))
                    .displayItems((params, output) -> {

                        output.accept(MItems.TEST_BOOK.get());

                        output.accept(MItems.VAELL_NOTES.get());
                        output.accept(MItems.KALEX_LOG.get());
                        output.accept(MItems.SYLVAE_JOURNAL.get());
                    }).build());

    public static final Supplier<CreativeModeTab> FOOD_TAB = TAB.register("food_tab",
            tab -> CreativeModeTab.builder().icon(() -> new ItemStack(MItems.LEMON.get()))
                    .title(Component.translatable(FOOD_TAB_STRING))
                    .displayItems((params, output) -> {

                        output.accept(MItems.LEMON.get());
                        output.accept(MItems.MANGO.get());
                        output.accept(MItems.BANANA.get());
                        output.accept(MItems.PEACH.get());
                        output.accept(MItems.KIWI.get());
                        output.accept(MItems.AVOCADO.get());
                        output.accept(MItems.BLUEBERRY.get());
                        output.accept(MItems.PINEAPPLE.get());
                        output.accept(MItems.STRAWBERRY.get());
                        output.accept(MItems.KIWI_SEEDLING.get());
                        output.accept(MItems.COCONUT_SHARDS.get());
                        output.accept(MItems.COCONUT.get());
                        output.accept(MItems.DRINKABLE_COCONUT.get());
                    }).build());




    public static void register(IEventBus eventBus) {
        TAB.register(eventBus);
    }
}
