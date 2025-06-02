package net.nic.npc.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.nic.npc.NpcMain;
import net.nic.npc.block.MBlocks;
import net.nic.npc.creativeTabs.MCreativeTabs;
import net.nic.npc.gui.NPCInterface.MenuR;
import net.nic.npc.gui.NPCInterface.ScreenR;
import net.nic.npc.gui.kingdomInterface.ScreenKIC;
import net.nic.npc.item.MItems;
import net.nic.npc.item.custom.equipment.ModSmithingTemplates;
import net.nic.npc.item.custom.equipment.armor.EnderArmor;
import net.nic.npc.item.custom.equipment.tools.general.MTool;

public class MLanguageProvider extends LanguageProvider {

    public MLanguageProvider(PackOutput output) {
        super(output, NpcMain.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {


        add(EnderArmor.NOMIXEDARMOR.getString(), "You can't mix Armors from different old Kingdoms!");

        add(MTool.MININGUPGRADETEXT.getString(), "Upgraded Mining Speed: ");
        add(MTool.DURABILITYUPGRADE.getString(), "Upgraded Durability: +");

        //BLAZED ITEMS
        add(MItems.BLAZING_SMITHING_UPGRADE.get(), "Blazing Smithing Upgrade");
        add(MItems.BLAZING_NETHERITE_INGOT.get(), "Blazing Netherite Ingot");
        add(MItems.BLAZED_HELMET.get(), "Blazing Helmet");
        add(MItems.BLAZED_CHESTPLATE.get(), "Blazing Chestplate");
        add(MItems.BLAZED_BOOTS.get(), "Blazing Boots");
        add(MItems.BLAZED_LEGGINGS.get(), "Blazing Leggings");
        add(MItems.BLAZED_SHOVEL.get(), "Blazing Shovel");
        add(MItems.BLAZED_SWORD.get(), "Blazing Sword");
        add(MItems.BLAZED_PICKAXE.get(), "Blazing Pickaxe");
        add(MItems.BLAZED_AXE.get(), "Blazing Axe");
        add(MItems.BLAZED_HOE.get(), "Blazing Hoe");

        //ENDER
        add(MItems.RINGENDER_SMITHING_UPGRADE.get(),"Endered Smithing Upgrade");
        add(MItems.RINGENDER_NETHERITE_INGOT.get(),"Endered Netherite Ingot");
        add(MItems.RINGENDER_PICKAXE.get(),"Endered Pickaxe");
        add(MItems.RINGENDER_AXE.get(),"Endered axe");
        add(MItems.RINGENDER_SWORD.get(),"Endered Sword");
        add(MItems.RINGENDER_HOOD.get(),"Ender Hood");
        add(MItems.RINGENDER_COAT.get(),"Ender Coat");
        add(MItems.RINGENDER_CLOAK.get(),"Ender Cloak");

        //PURPUR
        add(MItems.PURPUR_SMITHING_UPGRADE.get(),"Purpur Smithing Upgrade");
        add(MItems.PURPURED_NETHERITE_INGOT.get(),"Purpur Netherite Ingot");
        add(MItems.PURPUR_PICKAXE.get(),"Purpur Pickaxe");
        add(MItems.PURPUR_AXE.get(),"Purpur axe");
        add(MItems.PURPUR_SWORD.get(),"Purpur Sword");
        add(MItems.PURPUR_HELMET.get(),"Purpur Helmet");
        add(MItems.PURPUR_CHESTPLATE.get(),"Purpur Chestplate");
        add(MItems.PURPUR_LEGGINGS.get(),"Purpur Leggings");
        add(MItems.PURPUR_BOOTS.get(),"Purpur Boots");

        //FOOD
        add(MItems.AVOCADO.get(), "Avocado");
        add(MItems.BLUEBERRY.get(), "Blueberry");
        add(MItems.MANGO.get(), "Mango");
        add(MItems.STRAWBERRY.get(),"Strawberry");
        add(MItems.COCONUT.get(),"Coconut");
        add(MItems.COCONUT_SHARDS.get(),"Coconut Shards");
        add(MItems.DRINKABLE_COCONUT.get(),"Drinkable Coconut");
        add(MItems.BANANA.get(),"Banana");
        add(MItems.KIWI.get(),"Kiwi");
        add(MItems.KIWI_SEEDLING.get(),"Kiwi Seedling");
        add(MItems.PINEAPPLE.get(),"Pineapple");
        add(MItems.PEACH.get(),"Peach");
        add(MItems.LEMON.get(),"Lemon");

        //ARROWS
        add(MItems.WOODEN_ARROW.get(),"Wooden Arrow");
        add(MItems.STONE_ARROW.get(),"Stone Arrow");
        add(MItems.IRON_ARROW.get(),"Iron Arrow");
        add(MItems.GOLDEN_ARROW.get(),"Golden Arrow");
        add(MItems.DIAMOND_ARROW.get(),"Diamond Arrow");
        add(MItems.NETHERITE_ARROW.get(),"Netherite Arrow");


        //KINGDOM
        add(MBlocks.KINGDOM_BLOCK.get(),"Ruler Block");

        //Menus & Screens
        add(MenuR.failedKingdomCreationString,"Failed to Recruit: you don't have a Kingdom yet!");

        add(ScreenR.recruitBuy,"Buy");
        add(ScreenR.recruitRecruit,"Recruit!");
        add(ScreenR.recruitDismiss,"Dismiss");
        add(ScreenKIC.creationCreate,"Create");
        add(ScreenKIC.creationEditbox,"Enter your Kingdom Name!");
        add(ScreenKIC.governmentMonarchy,"Monarchy");
        add(ScreenKIC.governmentFeudalism,"Feudalism");
        add(ScreenKIC.governmentDemocracy,"Democracy");
        add(ScreenKIC.governmentTheocracy,"Theocracy");
        add(ScreenKIC.governmentOligarchy,"Oligarchy");
        add(ScreenKIC.governmentDictatorship,"Your Dictatorship:");
        add(ScreenKIC.governmentTitleMonarchy,"Your Monarchy:");
        add(ScreenKIC.governmentTitleFeudalism,"Your Feudalism:");
        add(ScreenKIC.governmentTitleDemocracy,"Your Democracy:");
        add(ScreenKIC.governmentTitleTheocracy,"Your Theocracy:");
        add(ScreenKIC.governmentTitleOligarchy,"Your Oligarchy:");
        add(ScreenKIC.governmentTitleDictatorship,"Your Dictatorship:");
        add(ScreenKIC.stringFood,"Food Storage");
        add(ScreenKIC.stringNeededFood,"Needed Food:");


        //SMITHING TEMPLATES TOOLTIPS
        add(ModSmithingTemplates.BLAZED_APPLIES_TO.getString(), "Netherite Equipment");
        add(ModSmithingTemplates.BLAZED_INGREDIENTS.getString(), "Blaze Rod and Powder");
        add(ModSmithingTemplates.BLAZED_BASE_SLOT_DESCRIPTION.getString(), "Add Netherite Equipment");
        add(ModSmithingTemplates.BLAZED_ADDITIONS_SLOT_DESCRIPTION.getString(), "Combine With Blazing Materials");

        add(ModSmithingTemplates.ENDER_APPLIES_TO.getString(), "Netherite Equipment");
        add(ModSmithingTemplates.ENDER_INGREDIENTS.getString(), "Ender Pearls & Ender Eyes");
        add(ModSmithingTemplates.ENDER_BASE_SLOT_DESCRIPTION.getString(),  "Add Netherite Equipment");
        add(ModSmithingTemplates.ENDER_ADDITIONS_SLOT_DESCRIPTION.getString(), "Combine with Vacuous Items");


        //Book Names
        add(MItems.TEST_BOOK.get(),"Lore Book Example");

        add(MItems.KALEX_LOG.get(),"Watcher's Log - Kalex's");
        add(MItems.VAELL_NOTES.get(),"Vaell's Notes");
        add(MItems.SYLVAE_JOURNAL.get(),"Sylvae's Notes");

        //Book Titles
        add("npcmain:test_book", "Test Book Translated En Us");
        addBookTitle(MItems.SYLVAE_JOURNAL_STRING,"Sylvae's Journal, Year -312A\nThe Garden Breathes");
        addBookTitle(MItems.VAELL_NOTES_STRING, "Vaell's Notes, Year -297A\nMoving Fire");
        addBookTitle(MItems.KALEX_LOG_STRING, "Watcher's Log, Year -273A\nThe Vote Of Concord");

        //Sylvae's Journal, Year -312A THE GARDEN BREATHES

        //Creative Tabs Translations
        add(MCreativeTabs.EQUIPMENT_TAB_STRING, "NPC Equipment");
        add(MCreativeTabs.BOOKS_TAB_STRING, "NPC Books");
        add(MCreativeTabs.FOOD_TAB_STRING, "NPC Food");
    }

    private void addBookTitle(String string, String translation) {
        add(NpcMain.MODID + ":" +string, translation);
    }
}
