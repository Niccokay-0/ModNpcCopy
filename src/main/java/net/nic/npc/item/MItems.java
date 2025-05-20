package net.nic.npc.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nic.npc.NpcMain;
import net.nic.npc.block.MBlocks;
import net.nic.npc.item.custom.BlazedArmor;
import net.nic.npc.item.custom.BlazedItem;
import net.nic.npc.item.custom.MItem;
import net.nic.npc.item.custom.TieredArrowItem;
import net.nic.npc.item.foods.CustomConsumables;
import net.nic.npc.item.foods.CustomFoodProperties;
import net.nic.npc.item.materials.CustomMaterials;

public class MItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NpcMain.MODID);


    /**
     * ARROWS
     */
    public static final DeferredItem<TieredArrowItem> WOODEN_ARROW = ITEMS.register("wooden_arrow", name -> new TieredArrowItem(name, new Item.Properties(), ToolMaterial.WOOD));
    public static final DeferredItem<TieredArrowItem> STONE_ARROW = ITEMS.register("stone_arrow", name -> new TieredArrowItem(name, new Item.Properties(), ToolMaterial.STONE));
    public static final DeferredItem<TieredArrowItem> IRON_ARROW = ITEMS.register("iron_arrow", name -> new TieredArrowItem(name, new Item.Properties(), ToolMaterial.IRON));
    public static final DeferredItem<TieredArrowItem> GOLDEN_ARROW = ITEMS.register("golden_arrow", name -> new TieredArrowItem(name, new Item.Properties(), ToolMaterial.GOLD));
    public static final DeferredItem<TieredArrowItem> DIAMOND_ARROW = ITEMS.register("diamond_arrow", name -> new TieredArrowItem(name, new Item.Properties(), ToolMaterial.DIAMOND));
    public static final DeferredItem<TieredArrowItem> NETHERITE_ARROW = ITEMS.register("netherite_arrow", name -> new TieredArrowItem(name, new Item.Properties(), ToolMaterial.NETHERITE));

    /**
     * BLAZED ITEMS AND BLAZED ARMOR
     * {@link net.minecraft.world.item.Items}
     */
    public static final DeferredItem<Item> BLAZED_PICKAXE = ITEMS.register("blazed_pickaxe", name -> new BlazedItem(name, new Item.Properties().pickaxe(CustomMaterials.BLAZE, 1.0f, -2.8f).fireResistant()));
    public static final DeferredItem<Item> BLAZED_SWORD = ITEMS.register("blazed_sword", name -> new BlazedItem(name, new Item.Properties().sword(CustomMaterials.BLAZE, 2.8f, -1.9f).fireResistant()));
    public static final DeferredItem<Item> BLAZED_AXE = ITEMS.register("blazed_axe", name -> new BlazedItem(name, new Item.Properties().axe(CustomMaterials.BLAZE, 3.8f, -3.0f).fireResistant()));
    public static final DeferredItem<Item> BLAZED_HOE = ITEMS.register("blazed_hoe", name -> new MHoeItem(CustomMaterials.BLAZE, 1.0f, -3.0f, new Item.Properties().fireResistant(), name));
    public static final DeferredItem<Item> BLAZED_SHOVEL = ITEMS.register("blazed_shovel", name -> new BlazedItem(name, new Item.Properties().hoe(CustomMaterials.BLAZE,0.9f,-1.9f).fireResistant()));

    public static final DeferredItem<Item> BLAZED_HELMET = ITEMS.register("blazed_helmet", name -> new BlazedArmor(name, new Item.Properties().humanoidArmor(CustomMaterials.BLAZEDARMOR, ArmorType.HELMET).fireResistant()));
    public static final DeferredItem<Item> BLAZED_CHESTPLATE = ITEMS.register("blazed_chestplate", name -> new BlazedArmor(name, new Item.Properties().humanoidArmor(CustomMaterials.BLAZEDARMOR, ArmorType.CHESTPLATE).fireResistant()));
    public static final DeferredItem<Item> BLAZED_LEGGINGS = ITEMS.register("blazed_leggings", name -> new BlazedArmor(name, new Item.Properties().humanoidArmor(CustomMaterials.BLAZEDARMOR, ArmorType.LEGGINGS).fireResistant()));
    public static final DeferredItem<Item> BLAZED_BOOTS = ITEMS.register("blazed_boots", name -> new BlazedArmor(name, new Item.Properties().humanoidArmor(CustomMaterials.BLAZEDARMOR, ArmorType.BOOTS).fireResistant()));


    /**
     * FOODS
     */
    public static final DeferredItem<Item> COCONUT = ITEMS.register("coconut", name -> new MItem(name, new Item.Properties())); //just an item

    public static final DeferredItem<Item> COCONUT_SHARDS = ITEMS.register("coconut_shards", name -> new MItem(name, new Item.Properties().food(CustomFoodProperties.COCONUT_SHARDS, CustomConsumables.COCONUT_SHARDS)));
    public static final DeferredItem<Item> DRINKABLE_COCONUT = ITEMS.register("coconut_drinkable", name -> new MItem(name, new Item.Properties().component(DataComponents.CONSUMABLE, CustomConsumables.MILK_BUCKET).usingConvertsTo(MItems.COCONUT_SHARDS.get()).stacksTo(16)));

    /**
     * FRUIT
     */
    public static final DeferredItem<Item> LEMON = ITEMS.register("lemon", name -> new MItem(name, new Item.Properties().food(CustomFoodProperties.LEMON, CustomConsumables.LEMON)));
    public static final DeferredItem<Item> BANANA = ITEMS.register("banana", name -> new MItem(name, new Item.Properties().food(CustomFoodProperties.BANANA)));
    public static final DeferredItem<Item> MANGO = ITEMS.register("mango", name -> new MItem(name, new Item.Properties().food(CustomFoodProperties.MANGO,CustomConsumables.FASTEDIBLE)));
    public static final DeferredItem<Item> KIWI = ITEMS.register("kiwi", name -> new MItem(name, new Item.Properties().food(CustomFoodProperties.KIWI,CustomConsumables.FASTEDIBLE)));
    public static final DeferredItem<Item> PEACH = ITEMS.register("peach", name -> new MItem(name, new Item.Properties().food(CustomFoodProperties.PEACH, CustomConsumables.FASTEDIBLE)));
    public static final DeferredItem<Item> AVOCADO = ITEMS.register("avocado", name -> new MItem(name, new Item.Properties().food(CustomFoodProperties.AVOCADO,CustomConsumables.FASTEDIBLE)));
    public static final DeferredItem<Item> PINEAPPLE = ITEMS.register("pineapple", name -> new MItem(name, new Item.Properties().food(CustomFoodProperties.PINEAPPLE, CustomConsumables.PINEAPPLE)));


    public static final DeferredItem<BlockItem> STRAWBERRY = ITEMS.register(
            "strawberry",
            name -> new MBlockItem(name,
                    MBlocks.STRAWBERRY_CROP.get(),
                    new Item.Properties().food(CustomFoodProperties.STRAWBERRY, CustomConsumables.STRAWBERRY) // or your custom food properties
            )
    );

    public static final DeferredItem<BlockItem> BLUEBERRY = ITEMS.register(
            "blueberry",
            name -> new MBlockItem(name,
                    MBlocks.BLUEBERRY_BUSH.get(),
                    new Item.Properties().food(CustomFoodProperties.BLUEBERRY, CustomConsumables.FASTEDIBLE) // or your custom food properties
            )
    );




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
