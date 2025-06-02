package net.nic.npc.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nic.npc.NpcMain;
import net.nic.npc.block.MBlocks;
import net.nic.npc.item.custom.CustomItemTags;
import net.nic.npc.item.custom.InviteItem;
import net.nic.npc.item.custom.MItem;
import net.nic.npc.item.custom.equipment.ModSmithingTemplates;
import net.nic.npc.item.custom.equipment.projectiles.MusketProjectileItem;
import net.nic.npc.item.custom.equipment.projectiles.TieredArrowItem;
import net.nic.npc.item.custom.equipment.armor.BlazedArmor;
import net.nic.npc.item.custom.equipment.armor.EnderArmor;
import net.nic.npc.item.custom.equipment.tools.MBlockItem;
import net.nic.npc.item.custom.equipment.tools.blazed.*;
import net.nic.npc.item.custom.equipment.tools.ender.*;
import net.nic.npc.item.foods.CustomConsumables;
import net.nic.npc.item.foods.CustomFoodProperties;
import net.nic.npc.item.materials.CustomMaterials;
import org.jetbrains.annotations.NotNull;

public class MItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(NpcMain.MODID);


    /**
     * Written Books LORE:
     *
     */

    public static final DeferredItem<Item> TEST_BOOK = registerRegularBook("test_book","test_book");

    /**
     * Era I Books:
     */

    public static String VAELL_NOTES_STRING = "vaell_notes";
    public static final DeferredItem<Item> VAELL_NOTES = registerRegularBook(VAELL_NOTES_STRING,VAELL_NOTES_STRING);
    public static String KALEX_LOG_STRING = "kalex_log";
    public static final DeferredItem<Item> KALEX_LOG = registerRegularBook(KALEX_LOG_STRING,KALEX_LOG_STRING);
    public static String SYLVAE_JOURNAL_STRING = "sylvae_journal";
    public static final DeferredItem<Item> SYLVAE_JOURNAL = registerRegularBook(SYLVAE_JOURNAL_STRING,SYLVAE_JOURNAL_STRING);




    /**
     * ARROWS
     */
    public static final DeferredItem<TieredArrowItem> WOODEN_ARROW = ITEMS.register("wooden_arrow", arrow -> new TieredArrowItem(arrow, new Item.Properties(), ToolMaterial.WOOD));
    public static final DeferredItem<TieredArrowItem> STONE_ARROW = ITEMS.register("stone_arrow", arrow -> new TieredArrowItem(arrow, new Item.Properties(), ToolMaterial.STONE));
    public static final DeferredItem<TieredArrowItem> IRON_ARROW = ITEMS.register("iron_arrow", arrow -> new TieredArrowItem(arrow, new Item.Properties(), ToolMaterial.IRON));
    public static final DeferredItem<TieredArrowItem> GOLDEN_ARROW = ITEMS.register("golden_arrow", arrow -> new TieredArrowItem(arrow, new Item.Properties(), ToolMaterial.GOLD));
    public static final DeferredItem<TieredArrowItem> DIAMOND_ARROW = ITEMS.register("diamond_arrow", arrow -> new TieredArrowItem(arrow, new Item.Properties(), ToolMaterial.DIAMOND));
    public static final DeferredItem<TieredArrowItem> NETHERITE_ARROW = ITEMS.register("netherite_arrow", arrow -> new TieredArrowItem(arrow, new Item.Properties(), ToolMaterial.NETHERITE));

    /**
     * BLAZED ITEMS AND BLAZED ARMOR
     * {@link net.minecraft.world.item.Items}
     *
     * FOR THE BLAZED FACTION IN THE NETHER FROM THE SECOND ERA
     */

    public static final DeferredItem<Item> BLAZED_SWORD = ITEMS.register("blazed_sword", tool -> new BlazedSwordItem(tool, new Item.Properties(), CustomMaterials.BLAZE, 3.0f, -1.8f));
    public static final DeferredItem<Item> BLAZED_PICKAXE = ITEMS.register("blazed_pickaxe", tool -> new BlazedPickaxeItem(tool, new Item.Properties(),CustomMaterials.BLAZE, 1.5f, -2.8f));
    public static final DeferredItem<Item> BLAZED_SHOVEL = ITEMS.register("blazed_shovel", tool -> new BlazedShovelItem(tool, new Item.Properties(), CustomMaterials.BLAZE, 1.5f, -3.0f));
    public static final DeferredItem<Item> BLAZED_AXE = ITEMS.register("blazed_axe", tool -> new BlazedAxeItem(tool, new Item.Properties(), CustomMaterials.BLAZE, 4.8f, -2.7f));
    public static final DeferredItem<Item> BLAZED_HOE = ITEMS.register("blazed_hoe", tool -> new BlazedHoeItem(tool, new Item.Properties(), CustomMaterials.BLAZE, 0.5f, 0.0f));

    public static final DeferredItem<Item> BLAZED_HELMET = ITEMS.register("blazed_helmet", armor -> new BlazedArmor(armor, new Item.Properties().humanoidArmor(CustomMaterials.BLAZEDARMOR, ArmorType.HELMET).fireResistant()));
    public static final DeferredItem<Item> BLAZED_CHESTPLATE = ITEMS.register("blazed_chestplate", armor -> new BlazedArmor(armor, new Item.Properties().humanoidArmor(CustomMaterials.BLAZEDARMOR, ArmorType.CHESTPLATE).fireResistant()));
    public static final DeferredItem<Item> BLAZED_LEGGINGS = ITEMS.register("blazed_leggings", armor -> new BlazedArmor(armor, new Item.Properties().humanoidArmor(CustomMaterials.BLAZEDARMOR, ArmorType.LEGGINGS).fireResistant()));
    public static final DeferredItem<Item> BLAZED_BOOTS = ITEMS.register("blazed_boots", armor -> new BlazedArmor(armor, new Item.Properties().humanoidArmor(CustomMaterials.BLAZEDARMOR, ArmorType.BOOTS).fireResistant()));


    /**
     * ENDER ITEMS AND ENDER ARMOR
     * {@link  net.minecraft.world.item.Items}
     *
     * FOR THE RING ENDER IN THE END FACTION FROM THE SECOND ERA
     */


    public static final DeferredItem<Item> RINGENDER_SWORD = ITEMS.register("ringender_sword", tool -> new EnderSwordItem(tool, new Item.Properties(), CustomMaterials.RINGENDER,3.0f, -1.8f));
    public static final DeferredItem<Item> RINGENDER_PICKAXE = ITEMS.register("ringender_pickaxe", tool-> new EnderPickaxeItem(tool, new Item.Properties(), CustomMaterials.RINGENDER,1.0f,-2.2f));
    public static final DeferredItem<Item> RINGENDER_AXE = ITEMS.register("ringender_axe", tool -> new EnderAxeItem(tool, new Item.Properties(), CustomMaterials.RINGENDER, 4.4f, -2.2f));

    public static final DeferredItem<Item> RINGENDER_HOOD = ITEMS.register("ringender_hood", hood -> new EnderArmor(hood, new Item.Properties().humanoidArmor(CustomMaterials.RINGENDERARMOR, ArmorType.HELMET)));
    public static final DeferredItem<Item> RINGENDER_COAT = ITEMS.register("ringender_coat", coat -> new EnderArmor(coat, new Item.Properties().humanoidArmor(CustomMaterials.RINGENDERARMOR, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> RINGENDER_CLOAK = ITEMS.register("ringender_cloak", cloak -> new EnderArmor(cloak, new Item.Properties().humanoidArmor(CustomMaterials.RINGENDERARMOR, ArmorType.BOOTS)));

    //public static final DeferredItem<Item> RINGENDER_CHARGE = ITEMS.register("ringender_charge", name -> new RingEnderCharge(name, new Item.Properties().useCooldown(0.8f)));


    /**
     *PURPUR ITEMS AND PURPUR ARMOR
     * {@link net.minecraft.world.item.Items}
     *
     * FOR THE PURPUR CITY ENDER FACTION IN THE END FROM THE SECOND ERA
     */

    public static final DeferredItem<Item> PURPUR_SWORD = ITEMS.register("purpur_sword", tool-> new EnderSwordItem(tool, new Item.Properties(), CustomMaterials.PURPUR,3.5f, -1.9f));
    public static final DeferredItem<Item> PURPUR_PICKAXE = ITEMS.register("purpur_pickaxe", tool-> new EnderPickaxeItem(tool, new Item.Properties(), CustomMaterials.PURPUR,1.8f,-3.0f));
    public static final DeferredItem<Item> PURPUR_AXE = ITEMS.register("purpur_axe", tool -> new EnderAxeItem(tool, new Item.Properties(), CustomMaterials.PURPUR, 5.5f, -2.8f));
    public static final DeferredItem<Item> PURPUR_CROSSBOW = ITEMS.register("purpur_crossbow", crossbow -> new PurpurCrossbowItem(crossbow, new Item.Properties().useCooldown(1.5f).repairable(CustomItemTags.PURPUR_ITEMS).stacksTo(1)));
    public static final DeferredItem<Item> PURPUR_MUSKET = ITEMS.register("purpur_musket", musket -> new AdvancedMusketItem(musket, new Item.Properties().useCooldown(0.5f).repairable(CustomItemTags.PURPUR_ITEMS).stacksTo(1)));

    public static final DeferredItem<Item> PURPUR_HELMET = ITEMS.register("purpur_helmet", armor -> new EnderArmor(armor, new Item.Properties().humanoidArmor(CustomMaterials.PURPURARMOR, ArmorType.HELMET)));
    public static final DeferredItem<Item> PURPUR_CHESTPLATE = ITEMS.register("purpur_chestplate", armor -> new EnderArmor(armor, new Item.Properties().humanoidArmor(CustomMaterials.PURPURARMOR, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> PURPUR_LEGGINGS = ITEMS.register("purpur_leggings", armor -> new EnderArmor(armor, new Item.Properties().humanoidArmor(CustomMaterials.PURPURARMOR, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> PURPUR_BOOTS = ITEMS.register("purpur_boots", armor -> new EnderArmor(armor, new Item.Properties().humanoidArmor(CustomMaterials.PURPURARMOR, ArmorType.BOOTS)));


    /**
     *Projectiles
     * {@link CustomItemTags}
     */

    public static final DeferredItem<Item> STONE_PROJECTILE = ITEMS.register("stone_projectile", proj -> new MusketProjectileItem(proj, new Item.Properties().stacksTo(96),ToolMaterial.STONE));
    public static final DeferredItem<Item> ENDSTONE_PROJECTILE = ITEMS.register("end_stone_projectile", proj -> new MusketProjectileItem(proj, new Item.Properties().stacksTo(96), CustomMaterials.ENDSTONE));
    public static final DeferredItem<Item> IRON_PROJECTILE = ITEMS.register("iron_projectile", proj -> new MusketProjectileItem(proj, new Item.Properties().stacksTo(96), ToolMaterial.IRON));
    public static final DeferredItem<Item> LEAD_PROJECTILE = ITEMS.register("lead_projectile", proj -> new MusketProjectileItem(proj, new Item.Properties().stacksTo(96), CustomMaterials.LEAD));
    public static final DeferredItem<Item> PHOSPHORUS_PROJECTILE = ITEMS.register("phosphorus_projectile", proj -> new MusketProjectileItem(proj, new Item.Properties().stacksTo(96), CustomMaterials.PHOSPHORUS));
    public static final DeferredItem<Item> TUNGSTEN_PROJECTILE = ITEMS.register("tungsten_projectile", proj -> new MusketProjectileItem(proj, new Item.Properties().stacksTo(96), CustomMaterials.TUNGSTEN));
    /**
     * FOODS
     */
    public static final DeferredItem<Item> COCONUT = ITEMS.register("coconut", fruit -> new MItem(fruit, new Item.Properties()));

    public static final DeferredItem<Item> COCONUT_SHARDS = ITEMS.register("coconut_shards", shards -> new MItem(shards, new Item.Properties().food(CustomFoodProperties.COCONUT_SHARDS, CustomConsumables.COCONUT_SHARDS)));
    public static final DeferredItem<Item> DRINKABLE_COCONUT = ITEMS.register("coconut_drinkable", drink -> new MItem(drink, new Item.Properties().component(DataComponents.CONSUMABLE, CustomConsumables.MILK_BUCKET).usingConvertsTo(MItems.COCONUT_SHARDS.get()).stacksTo(16)));

    /**
     * FRUIT
     */
    public static final DeferredItem<Item> LEMON = ITEMS.register("lemon", fruit -> new MItem(fruit, new Item.Properties().food(CustomFoodProperties.LEMON, CustomConsumables.LEMON)));
    public static final DeferredItem<Item> BANANA = ITEMS.register("banana", fruit -> new MItem(fruit, new Item.Properties().food(CustomFoodProperties.BANANA)));
    public static final DeferredItem<Item> MANGO = ITEMS.register("mango", fruit -> new MItem(fruit, new Item.Properties().food(CustomFoodProperties.MANGO,CustomConsumables.FASTEDIBLE)));
    public static final DeferredItem<Item> KIWI = ITEMS.register("kiwi", fruit -> new MItem(fruit, new Item.Properties().food(CustomFoodProperties.KIWI,CustomConsumables.FASTEDIBLE)));
    public static final DeferredItem<Item> PEACH = ITEMS.register("peach", fruit -> new MItem(fruit, new Item.Properties().food(CustomFoodProperties.PEACH, CustomConsumables.FASTEDIBLE)));
    public static final DeferredItem<Item> AVOCADO = ITEMS.register("avocado", fruit -> new MItem(fruit, new Item.Properties().food(CustomFoodProperties.AVOCADO,CustomConsumables.FASTEDIBLE)));
    public static final DeferredItem<Item> PINEAPPLE = ITEMS.register("pineapple", fruit -> new MItem(fruit, new Item.Properties().food(CustomFoodProperties.PINEAPPLE, CustomConsumables.PINEAPPLE)));

    public static final DeferredItem<BlockItem> STRAWBERRY = ITEMS.register(
            "strawberry", berry ->
                    new MBlockItem(berry,
                            MBlocks.STRAWBERRY_CROP.get(),
                            new Item.Properties().food(CustomFoodProperties.STRAWBERRY, CustomConsumables.STRAWBERRY)));

    public static final DeferredItem<BlockItem> BLUEBERRY = ITEMS.register(
            "blueberry", berry ->
                    new MBlockItem(berry,
                            MBlocks.BLUEBERRY_CROP.get(),
                            new Item.Properties().food(CustomFoodProperties.BLUEBERRY, CustomConsumables.FASTEDIBLE)));

    public static final DeferredItem<BlockItem> KIWI_SEEDLING = ITEMS.register(
            "kiwi_seedling", seedling ->
                    new MBlockItem(seedling,
                            MBlocks.KIWI_PLANT.get(),
                            new Item.Properties()));


    /**
     * ORES AND MATERIALS
     */
    public static final DeferredItem<Item> PHOSPHORUS_CRYSTALS = ITEMS.register("phosphorus_crystals", crystal -> new MItem(crystal, new Item.Properties()));

    public static final DeferredItem<Item> TUNGSTEN_CHUNK = ITEMS.register("tungsten_chunk", chunk -> new MItem(chunk, new Item.Properties()));
    public static final DeferredItem<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", ingot -> new MItem(ingot, new Item.Properties()));

    public static final DeferredItem<Item> RAW_LEAD = ITEMS.register("raw_lead", lead -> new MItem(lead, new Item.Properties()));
    public static final DeferredItem<Item> LEAD_INGOT = ITEMS.register("lead_ingot", ingot -> new MItem(ingot, new Item.Properties()));

    public static final DeferredItem<SmithingTemplateItem> BLAZING_SMITHING_UPGRADE = ITEMS.register("blaze_smithing_upgrade", ModSmithingTemplates::createBlazedTemplate);
    public static final DeferredItem<Item> BLAZING_NETHERITE_INGOT = ITEMS.register("blazing_netherite_ingot", name -> new MItem(name, new Item.Properties().fireResistant().rarity(Rarity.RARE)));

    public static final DeferredItem<SmithingTemplateItem> RINGENDER_SMITHING_UPGRADE = ITEMS.register("ringender_smithing_upgrade", ModSmithingTemplates::createRingenderTemplate);
    public static final DeferredItem<Item> RINGENDER_NETHERITE_INGOT = ITEMS.register("endered_netherite_ingot", name -> new MItem(name, new Item.Properties().fireResistant().rarity(Rarity.EPIC)));

    public static final DeferredItem<SmithingTemplateItem> PURPUR_SMITHING_UPGRADE = ITEMS.register("purpur_smithing_upgrade", ModSmithingTemplates::createRingenderTemplate);
    public static final DeferredItem<Item> PURPURED_NETHERITE_INGOT = ITEMS.register("purpured_netherite_ingot", ingot -> new MItem(ingot, new Item.Properties().fireResistant().rarity(Rarity.RARE)));


    public static final DeferredItem<Item> KINGDOM_INVITE = ITEMS.register("kingdom_invite", kingdomInvite -> new InviteItem(kingdomInvite, new Item.Properties().stacksTo(16).component(MDataComponents.KINGDOM_ID.get(), null)));

    private static @NotNull DeferredItem<Item> registerRegularBook(String nameId, String path) {
        return ITEMS.register(nameId, book -> new MWrittenBook(book, new Item.Properties(), ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, path)));
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
