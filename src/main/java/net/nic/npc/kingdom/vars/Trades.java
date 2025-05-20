package net.nic.npc.kingdom.vars;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.nic.npc.item.MItems;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trades {


    private static Random rand = new Random();

    public enum TradeConfig {
        BLACKSMITHl1t1(new ItemStack(Items.EMERALD, 4), null, new ItemStack(Items.IRON_PICKAXE), 0.41f, false, 2, 0, "trade.blacksmith.axe") //todo === BLACKSMITH ===
        ,
        BLACKSMITHl1t2(new ItemStack(Items.EMERALD, 5), null, new ItemStack(Items.IRON_AXE), 0.39f, false, 2, 0, "trade.blacksmith.axe"),

        BLACKSMITHl1t3(new ItemStack(Items.EMERALD, 6), null, new ItemStack(Items.IRON_SWORD), 0.44f, false, 2, 0, "trade.blacksmith.axe"),
        BLACKSMITHl2t1(new ItemStack(Items.EMERALD, 7), null, new ItemStack(Items.IRON_SWORD), 0.26f, true, 3, 0, "trade.blacksmith.sword"),
        BLACKSMITHl2t2(new ItemStack(Items.GRAVEL, 4), null, new ItemStack(Items.FLINT), 0.25f, true, 8, 0, "trade.blacksmith.sword"),

        BLACKSMITHl2t3(new ItemStack(Items.FEATHER, 5), null, new ItemStack(Items.ARROW, 14), 0.28f, true, 6, 0, "trade.blacksmith.sword"),
        BLACKSMITHl3t1(new ItemStack(Items.IRON_INGOT, 1), new ItemStack(Items.OAK_PLANKS), new ItemStack(Items.SHIELD), 1.25f, false, 4, 0, "trade.blacksmith.shield"),
        BLACKSMITHl3t2(new ItemStack(Items.RAW_IRON, 6), new ItemStack(Items.COAL), new ItemStack(Items.IRON_CHESTPLATE), 0.82f, false, 4, 0, "trade.blacksmith.shield"),

        BLACKSMITHl4t1(new ItemStack(Items.EMERALD, 5), new ItemStack(Items.IRON_PICKAXE), new ItemStack(Items.DIAMOND_PICKAXE), 1.26f, false, 5, 0, "trade.blacksmith.ingot"),
        BLACKSMITHl4t2(new ItemStack(Items.EMERALD, 5), new ItemStack(Items.IRON_AXE), new ItemStack(Items.DIAMOND_AXE), 1.11f, false, 5, 0, "trade.blacksmith.ingot"),

        BLACKSMITHl5t1(new ItemStack(Items.EMERALD, 22), null, new ItemStack(Items.DIAMOND_CHESTPLATE), 1.35f, true, 5, 0, "trade.blacksmith.armor"),
        BLACKSMITHl5t2(new ItemStack(Items.EMERALD, 26), null, new ItemStack(Items.DIAMOND_HELMET), 1.05f, true, 6, 0, "trade.blacksmith.armor"),

        BUTCHERl1t1(new ItemStack(Items.BEEF, 14), null, Items.EMERALD.getDefaultInstance(), 1.0f, false, 13, 2, "trade.butcher.beef"),
        //todo === BUTCHER ===
        BUTCHERl1t2(new ItemStack(Items.PORKCHOP, 12), null, Items.EMERALD.getDefaultInstance(), 1.0f, false, 14, 2, "trade.butcher.beef"),
        BUTCHERl1t3(new ItemStack(Items.MUTTON, 9), null, Items.EMERALD.getDefaultInstance(), 1.0f, false, 16, 2, "trade.butcher.beef"),
        BUTCHERl1t4(new ItemStack(Items.CHICKEN, 6), null, Items.EMERALD.getDefaultInstance(), 1.0f,
                false,
                18,
                2,
                "trade.butcher.beef"
        ),
        BUTCHERl2t1(
                Items.EMERALD.getDefaultInstance(),
                null,
                new ItemStack(Items.COOKED_PORKCHOP, 6 + rand.nextInt(5) - 2),
                1.0f,
                false,
                23,
                3,
                "trade.butcher.pork"
        ),
        BUTCHERl2t2(
                Items.EMERALD.getDefaultInstance(),
                null,
                new ItemStack(Items.COOKED_BEEF, 5 + rand.nextInt(5) - 2),
                1.0f,
                false,
                24,
                3,
                "trade.butcher.pork"
        ),
        BUTCHERl2t3(Items.EMERALD.getDefaultInstance(), null, new ItemStack(Items.COOKED_MUTTON, 7 + rand.nextInt(5) - 2), 1.0f, false, 26, 3, "trade.butcher.pork"),
        BUTCHERl2t4(Items.EMERALD.getDefaultInstance(), null, new ItemStack(Items.COOKED_RABBIT, 6 + rand.nextInt(5) - 2), 1.0f, false, 28, 3, "trade.butcher.pork"),

        BUTCHERl3t1(
                new ItemStack(Items.COAL, 12),
                null,
                Items.EMERALD.getDefaultInstance(),
                1.0f,
                false,
                34,
                4,
                "trade.butcher.chicken"
        ),
        BUTCHERl3t2(
                new ItemStack(Items.CHARCOAL, 12 + rand.nextInt(7) - 2),
                null,
                Items.EMERALD.getDefaultInstance(),
                1.0f,
                false,
                320,
                4,
                "trade.butcher.chicken"
        ),
        BUTCHERl3t3(
                new ItemStack(Items.LEATHER, 7 + rand.nextInt(5)),
                null,
                Items.EMERALD.getDefaultInstance(),
                1.0f,
                false,
                34,
                310,
                "trade.butcher.chicken"
        ),

        BUTCHERl3t4(
                new ItemStack(Items.RABBIT_HIDE, 3 + rand.nextInt(5)),
                null,
                Items.EMERALD.getDefaultInstance(),
                1.0f,
                false,
                38,
                335,
                "trade.butcher.chicken"
        ),
        BUTCHERl4t1(
                new ItemStack(Items.RABBIT, 3),
                null,
                Items.EMERALD.getDefaultInstance(),
                1.0f,
                false,
                53,
                5,
                "trade.butcher.rabbit"
        ),

        BUTCHERl4t2(
                new ItemStack(Items.GOLD_INGOT, 6),
                null,
                Items.RABBIT_STEW.getDefaultInstance(),
                1.0f,
                false,
                57,
                5,
                "trade.butcher.rabbit"
        ),
        BUTCHERl4t3(
                new ItemStack(Items.RABBIT_FOOT, 2),
                null,
                Items.EMERALD.getDefaultInstance(),
                1.0f,
                false,
                55,
                5,
                "trade.butcher.rabbit"
        ),

        BUTCHERl5t1(
                Items.EMERALD.getDefaultInstance(),
                null,
                Items.SUSPICIOUS_STEW.getDefaultInstance(),
                1.0f,
                true,
                69,
                6,
                "trade.butcher.steak"
        ),
        FARMERl1t1(new ItemStack(Items.WHEAT, 24), null, new ItemStack(Items.EMERALD, 2), 1.0f, false, 12, 4, "trade.farmer.wheat") //todo === FARMER ===
        ,
        FARMERl1t2(new ItemStack(Items.POTATO, 18), null, Items.EMERALD.getDefaultInstance(), 1.0f, false, 15, 3, "trade.farmer.potato"),

        FARMERl2t1(new ItemStack(Items.CARROT, 12), null, Items.EMERALD.getDefaultInstance(), 1.0f, false, 21, 3, "trade.farmer.carrot"),
        FARMERl2t2(new ItemStack(Items.BREAD, 4), null, Items.HAY_BLOCK.getDefaultInstance(), 1.0f, false, 22, 3, "trade.farmer.carrot"),
        FARMERl2t3(new ItemStack(Items.WHEAT_SEEDS, 5), null, Items.WHEAT.getDefaultInstance(), 1.0f, false, 25, 3, "trade.farmer.carrot"),

        FARMERl3t1(new ItemStack(Items.BEETROOT, 20), null, Items.EMERALD.getDefaultInstance(), 1.0f, false, 40, 6, "trade.farmer.beetroot"),
        FARMERl3t2(new ItemStack(Items.SPIDER_EYE, 1), null, Items.SUGAR.getDefaultInstance(), 1.0f, false, 42, 6, "trade.farmer.beetroot"),
        FARMERl3t3(new ItemStack(Items.SUGAR, 9), null, Items.SUGAR_CANE.getDefaultInstance(), 1.0f, false, 38, 6, "trade.farmer.beetroot"),

        FARMERl4t1(new ItemStack(Items.EMERALD, 2), null, Items.BAKED_POTATO.getDefaultInstance(), 1.0f, false, 45, 9, "trade.farmer.emerald.potato"),
        FARMERl4t2(new ItemStack(Items.EMERALD, 2), null, Items.NETHER_WART.getDefaultInstance(), 1.0f, false, 55, 9, "trade.farmer.emerald.potato"),

        FARMERl5t1(new ItemStack(Items.EMERALD, 9), null, Items.GOLDEN_APPLE.getDefaultInstance(), 1.0f, true, 65, 15, "trade.farmer.golden_apple.emerald"),
        FARMERl5t2(new ItemStack(Items.EMERALD, 3), null, Items.GOLDEN_CARROT.getDefaultInstance(), 1.0f, true, 75, 13, "trade.farmer.emerald.golden_carrot"),

        FISHERl1t1(new ItemStack(Items.BUCKET, 1), null, Items.EMERALD.getDefaultInstance(), 6f, false, 45, 2, "trade.fisher.cod"),
        FISHERl1t2(new ItemStack(Items.BUCKET, 1), new ItemStack(Items.FISHING_ROD), Items.COD_BUCKET.getDefaultInstance(), 1f, false, 55, 2, "trade.fisher.cod"),

        FISHERl1t3(new ItemStack(Items.BUCKET, 1), new ItemStack(Items.FISHING_ROD), Items.SALMON_BUCKET.getDefaultInstance(), 1f, false, 50, 2, "trade.fisher.cod"),
        FISHERl1t4(new ItemStack(Items.BUCKET, 1), new ItemStack(Items.FISHING_ROD), Items.TADPOLE_BUCKET.getDefaultInstance(), 1f, false, 55, 2, "trade.fisher.cod"),
        FISHERl1t5(new ItemStack(Items.BUCKET, 1), new ItemStack(Items.FISHING_ROD), Items.PUFFERFISH_BUCKET.getDefaultInstance(), 1f, false, 45, 2, "trade.fisher.cod"),
        FISHERl1t6(new ItemStack(Items.BUCKET, 1), new ItemStack(Items.FISHING_ROD), Items.TROPICAL_FISH_BUCKET.getDefaultInstance(), 1f, false, 54, 2, "trade.fisher.cod"),

        FISHERl1t7(new ItemStack(Items.BUCKET, 1), new ItemStack(Items.FISHING_ROD), Items.AXOLOTL_BUCKET.getDefaultInstance(), 1f, false, 8, 52, "trade.fisher.cod"),
        FISHERl2t1(new ItemStack(Items.SALMON, 4), null, Items.EMERALD.getDefaultInstance(), 8f, false, 28, 3, "trade.fisher.salmon"),
        FISHERl3t1(new ItemStack(Items.EMERALD, 5), null, Items.COOKED_COD.getDefaultInstance(), 9f, false, 31, 4, "trade.fisher.rod"),
        FISHERl3t2(new ItemStack(Items.EMERALD, 5), null, Items.COOKED_SALMON.getDefaultInstance(), 9f, false, 36, 4, "trade.fisher.rod"),

        FISHERl4t1(new ItemStack(Items.EMERALD, 6), null, Items.COOKED_COD.getDefaultInstance(), 3f, false, 44, 5, "trade.fisher.cookedcod"),
        FISHERl5t1(new ItemStack(Items.EMERALD, 14), null, Items.HEART_OF_THE_SEA.getDefaultInstance(), 1f, true, 56, 6, "trade.fisher.heart"),


        LUMBERJACKl1t1(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.OAK_LOG, 16), 1.0f, false, 12, 20, "trade.lumberjack.oak"),
        LUMBERJACKl1t2(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.STRIPPED_OAK_LOG, 16), 1.0f, false, 12, 20, "trade.lumberjack.stripped_oak"),
        LUMBERJACKl1t3(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.SPRUCE_LOG, 16), 1.0f, false, 12, 20, "trade.lumberjack.spruce"),
        LUMBERJACKl1t4(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.STRIPPED_SPRUCE_LOG, 16), 1.0f, false, 12, 20, "trade.lumberjack.stripped_spruce"),
        LUMBERJACKl1t5(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.BIRCH_LOG, 16), 1.0f, false, 12, 20, "trade.lumberjack.birch"),
        LUMBERJACKl1t6(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.STRIPPED_BIRCH_LOG, 16), 1.0f, false, 12, 20, "trade.lumberjack.stripped_birch"),
        LUMBERJACKl1t7(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.JUNGLE_LOG, 16), 1.0f, false, 12, 20, "trade.lumberjack.jungle"),
        LUMBERJACKl1t8(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.STRIPPED_JUNGLE_LOG, 16), 1.0f, false, 12, 20, "trade.lumberjack.stripped_jungle"),
        LUMBERJACKl1t9(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.ACACIA_LOG, 16), 1.0f, false, 12, 20, "trade.lumberjack.acacia"),
        LUMBERJACKl1t10(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.STRIPPED_ACACIA_LOG, 16), 1.0f, false, 12, 20, "trade.lumberjack.stripped_acacia"),
        LUMBERJACKl1t11(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.DARK_OAK_LOG, 16), 1.0f, false, 12, 20, "trade.lumberjack.dark"),
        LUMBERJACKl1t12(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.STRIPPED_DARK_OAK_LOG, 16), 1.0f, false, 12, 20, "trade.lumberjack.stripped_dark"),
        LUMBERJACKl1t13(new ItemStack(Items.EMERALD, 4), null, new ItemStack(Items.MANGROVE_LOG, 24), 1.0f, false, 12, 20, "trade.lumberjack.mangrove"),
        LUMBERJACKl1t14(new ItemStack(Items.EMERALD, 4), null, new ItemStack(Items.STRIPPED_MANGROVE_LOG, 24), 1.0f, false, 12, 20, "trade.lumberjack.stripped_mangrove"),
        LUMBERJACKl1t15(new ItemStack(Items.EMERALD, 4), null, new ItemStack(Items.CHERRY_LOG, 24), 1.0f, false, 12, 20, "trade.lumberjack.cherry"),
        LUMBERJACKl1t16(new ItemStack(Items.EMERALD, 4), null, new ItemStack(Items.STRIPPED_CHERRY_LOG, 24), 1.0f, false, 12, 20, "trade.lumberjack.stripped_cherry"),
        LUMBERJACKl1t17(new ItemStack(Items.EMERALD, 4), null, new ItemStack(Items.PALE_OAK_LOG, 24), 1.0f, false, 12, 20, "trade.lumberjack.pale"),
        LUMBERJACKl1t18(new ItemStack(Items.EMERALD, 4), null, new ItemStack(Items.STRIPPED_PALE_OAK_LOG, 24), 1.0f, false, 12, 20, "trade.lumberjack.stripped_pale"),
        LUMBERJACKl1t19(new ItemStack(Items.EMERALD, 4), null, new ItemStack(Items.CRIMSON_STEM, 24), 1.0f, false, 12, 20, "trade.lumberjack.crimson"),
        LUMBERJACKl1t20(new ItemStack(Items.EMERALD, 4), null, new ItemStack(Items.STRIPPED_CRIMSON_STEM, 16), 1.0f, false, 12, 20, "trade.lumberjack.stripped_crimson"),
        LUMBERJACKl1t21(new ItemStack(Items.EMERALD, 4), null, new ItemStack(Items.WARPED_STEM, 24), 1.0f, false, 12, 20, "trade.lumberjack.warped"),
        LUMBERJACKl1t22(new ItemStack(Items.EMERALD, 4), null, new ItemStack(Items.STRIPPED_WARPED_STEM, 24), 1.0f, false, 12, 20, "trade.lumberjack.stripped_warped"),

        // Level 2 (with randomness, approximate or define outside if needed)
        LUMBERJACKl2t1(new ItemStack(Items.EMERALD, 3), null, new ItemStack(Items.BONE_BLOCK, 5), 1.0f, false, 24, 3, "trade.lumberjack.birch"),
        LUMBERJACKl2t2(new ItemStack(Items.GOLD_INGOT, 6), null, new ItemStack(Items.CAMPFIRE, 2), 1.0f, false, 21, 3, "trade.lumberjack.birch"),
        LUMBERJACKl2t3(new ItemStack(Items.GOLD_INGOT, 6), null, new ItemStack(Items.SOUL_CAMPFIRE, 2), 1.0f, false, 35, 3, "trade.lumberjack.birch"),

        // Level 3
        LUMBERJACKl3t1(new ItemStack(Items.CHERRY_LEAVES, 32), null, new ItemStack(Items.EMERALD, 34), 1.0f, false, 4, 0, "trade.lumberjack.spruce"),
        LUMBERJACKl3t2(new ItemStack(Items.OAK_LEAVES, 32), null, new ItemStack(Items.EMERALD, 4), 1.0f, false, 36, 0, "trade.lumberjack.spruce"),
        LUMBERJACKl3t3(new ItemStack(Items.BIRCH_LEAVES, 32), null, new ItemStack(Items.EMERALD, 4), 1.0f, false, 47, 0, "trade.lumberjack.spruce"),
        LUMBERJACKl3t4(new ItemStack(Items.MANGROVE_LEAVES, 32), null, new ItemStack(Items.EMERALD, 4), 1.0f, false, 44, 0, "trade.lumberjack.spruce"),

        // Level 4
        LUMBERJACKl4t1(new ItemStack(Items.EMERALD, 1), null, new ItemStack(Items.MANGROVE_PROPAGULE, 4), 1.0f, false, 56, 5, "trade.lumberjack.chest"),
        LUMBERJACKl4t2(new ItemStack(Items.EMERALD, 1), null, new ItemStack(Items.APPLE, 8), 1.0f, false, 65, 58, "trade.lumberjack.chest"),

        // Level 5
        LUMBERJACKl5t1(new ItemStack(Items.EMERALD_BLOCK, 5), null, new ItemStack(Items.NETHERITE_AXE, 1), 1.0f, false, 62, 6, "trade.lumberjack.craftingtable"),


        //todo MERCHANT
        MERCHANTl1t1(new ItemStack(Items.STRING, 22), null, new ItemStack(Items.EMERALD, 3), 1f, false, 12, 0, "trade.merchant.string"),
        MERCHANTl1t2(new ItemStack(Items.REDSTONE, 2), new ItemStack(Items.RAW_IRON), new ItemStack(Items.COMPASS, 3), 1f, false, 15, 0, "trade.merchant.string"),
        MERCHANTl1t3(new ItemStack(Items.SUGAR_CANE, 6), null, new ItemStack(Items.TNT, 3), 1f, false, 12, 0, "trade.merchant.string"),
        MERCHANTl1t4(new ItemStack(Items.DIAMOND, 6), new ItemStack(Items.GOLD_INGOT, 2), new ItemStack(Items.SADDLE, 1), 1f, false, 16, 0, "trade.merchant.string"),
        MERCHANTl2t1(new ItemStack(Items.EMERALD, 1), null, new ItemStack(Items.BUNDLE, 1), 1f, false, 21, 0, "trade.merchant.map"),
        MERCHANTl2t2(new ItemStack(Items.GOLD_NUGGET, 9), new ItemStack(Items.REDSTONE), new ItemStack(Items.CLOCK, 1), 1f, false, 24, 0, "trade.merchant.map"),
        MERCHANTl2t3(new ItemStack(Items.LEATHER, 3), new ItemStack(Items.IRON_INGOT), new ItemStack(Items.SADDLE, 1), 1f, false, 31, 0, "trade.merchant.map"),
        MERCHANTl2t4(new ItemStack(Items.GOLD_NUGGET, 5), new ItemStack(Items.IRON_NUGGET), new ItemStack(Items.GOLDEN_HORSE_ARMOR, 1), 1f, false, 28, 0, "trade.merchant.map"),
        MERCHANTl3t1(new ItemStack(Items.EMERALD, 16), null, new ItemStack(Items.GOLDEN_APPLE, 3), 2f, false, 24, 0, ""), // original: 2 + rand.nextInt(3), approx minimum 2true,31,0,"trade.merchant.book"),
        MERCHANTl3t2(new ItemStack(Items.EMERALD, 8), null, new ItemStack(Items.GOLDEN_APPLE, 2), 2f, false, 24, 0, ""),
        MERCHANTl3t3(new ItemStack(Items.EMERALD, 3), null, new ItemStack(Items.COPPER_INGOT, 12), 2f, false, 24, 0, ""), // 14 + rand.nextInt(5)true,41,0,"trade.merchant.book"),
        MERCHANTl3t4(new ItemStack(Items.EMERALD, 24), null, new ItemStack(Items.ENCHANTED_GOLDEN_APPLE, 1), 2f, false, 24, 0, ""), // 1 + rand.nextInt(3)true,45,0,"trade.merchant.book"),
        MERCHANTl4t1(new ItemStack(Items.GOLD_INGOT, 18), null, new ItemStack(Items.CRYING_OBSIDIAN, 7), 2f, false, 55, 0, "trade.merchant.gold"),
        MERCHANTl4t2(new ItemStack(Items.GOLD_INGOT, 13), null, new ItemStack(Items.ENDER_PEARL, 3), 3f, false, 65, 0, "trade.merchant.gold"),
        MERCHANTl4t3(new ItemStack(Items.GOLD_INGOT, 15), null, new ItemStack(Items.BLAZE_ROD, 4), 3f, false, 61, 0, "trade.merchant.gold"),
        MERCHANTl5t1(new ItemStack(Items.EMERALD, 14), null, new ItemStack(Items.NAUTILUS_SHELL, 3), 2f, true, 75, 67, "trade.merchant.nautilus"),
        MERCHANTl5t2(new ItemStack(Items.EMERALD, 14), null, new ItemStack(Items.ENDER_EYE, 4), 3f, true, 3, 72, "trade.merchant.nautilus"),
        MERCHANTl5t3(new ItemStack(Items.EMERALD, 16), new ItemStack(Items.DIAMOND), new ItemStack(Items.HEART_OF_THE_SEA, 1), 2f, true, 67, 78, "trade.merchant.nautilus"),
        MERCHANTl5t4(new ItemStack(Items.EMERALD, 9), new ItemStack(Items.NETHERITE_SCRAP), new ItemStack(Items.TRIDENT, 1), 1f, true, 78, 6, "trade.merchant.nautilus"), // Fisher trades


        MINERl1t1(new ItemStack(Items.STONE, 32), null, new ItemStack(Items.IRON_INGOT, 4 + rand.nextInt(3)), 1.0f, false, 14, 5, "trade.miner.cobble"),
        MINERl1t2(new ItemStack(Items.COBBLESTONE, 32), null, new ItemStack(Items.IRON_INGOT, 4 + rand.nextInt(3)), 1.0f, false, 15, 5, "trade.miner.cobble"),
        MINERl1t3(new ItemStack(Items.DEEPSLATE, 32), null, new ItemStack(Items.GOLD_INGOT, 4 + rand.nextInt(3)), 1.0f, false, 14, 5, "trade.miner.cobble"),
        MINERl1t4(new ItemStack(Items.COBBLED_DEEPSLATE, 32), null, new ItemStack(Items.GOLD_INGOT, 4 + rand.nextInt(3)), 1.0f, false, 14, 5, "trade.miner.cobble"),
        MINERl1t5(new ItemStack(Items.GRAVEL, 32), null, new ItemStack(Items.GOLD_INGOT, 4 + rand.nextInt(3)), 1.0f, false, 16, 5, "trade.miner.cobble"),
        MINERl1t6(new ItemStack(Items.GRANITE, 32), null, new ItemStack(Items.GOLD_INGOT, 4 + rand.nextInt(3)), 1.0f, false, 18, 5, "trade.miner.cobble"),
        MINERl1t7(new ItemStack(Items.ANDESITE, 32), null, new ItemStack(Items.GOLD_INGOT, 4 + rand.nextInt(3)), 1.0f, false, 21, 5, "trade.miner.cobble"),
        MINERl1t8(new ItemStack(Items.DIORITE, 32), null, new ItemStack(Items.GOLD_INGOT, 4 + rand.nextInt(3)), 1.0f, false, 19, 5, "trade.miner.cobble"),
        MINERl2t1(new ItemStack(Items.COAL, 20), null, new ItemStack(Items.EMERALD, 2 + rand.nextInt(4)), 1.0f, false, 24, 3, "trade.miner.coal"),
        MINERl2t2(new ItemStack(Items.IRON_INGOT, 20), null, new ItemStack(Items.EMERALD, 2 + rand.nextInt(3)), 1.0f, false, 31, 3, "trade.miner.coal"),
        MINERl2t3(new ItemStack(Items.GOLD_INGOT, 20), null, new ItemStack(Items.EMERALD, 2 + rand.nextInt(5)), 1.0f, false, 28, 3, "trade.miner.coal"),
        MINERl3t1(new ItemStack(Items.DIAMOND, 1), null, new ItemStack(Items.EMERALD, 6 + rand.nextInt(5)), 1.0f, false, 42, 4, "trade.miner.iron"),
        MINERl3t2(new ItemStack(Items.QUARTZ, 32), null, new ItemStack(Items.EMERALD, 6 + rand.nextInt(5)), 1.0f, false, 47, 4, "trade.miner.iron"),
        MINERl4t1(new ItemStack(Items.EMERALD, 8), null, new ItemStack(Items.DIAMOND, 2), 1.0f, true, 55, 5, "trade.miner.diamond"),
        MINERl4t2(new ItemStack(Items.ANCIENT_DEBRIS, 2), null, new ItemStack(Items.DIAMOND, 16), 1.0f, true, 76, 5, "trade.miner.diamond"),
        MINERl5t1(new ItemStack(Items.EMERALD, 36), null, new ItemStack(Items.ANCIENT_DEBRIS, 1), 1.0f, true, 80, 29, "trade.miner.debris"),
        MINERl5t2(new ItemStack(Items.EMERALD, 30), new ItemStack(Items.COAL, 1), new ItemStack(Items.NETHERITE_SCRAP, 1), 1.0f, true, 75, 29, "trade.miner.debris"),
        MINERl5t3(new ItemStack(Items.EMERALD_BLOCK, 10), new ItemStack(Items.GOLD_BLOCK, 1), new ItemStack(Items.NETHERITE_INGOT, 1), 1.0f, true, 65, 29, "trade.miner.debris"),

        //todo === FLETCHER ===

        FLETCHERl1t1(new ItemStack(Items.FEATHER, 8 + rand.nextInt(5)), null, new ItemStack(Items.EMERALD, 1), 1.0f, false, 15, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl1t2(new ItemStack(Items.STICK, 16), null, new ItemStack(Items.EMERALD, 3), 1.0f, false, 15, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl1t3(new ItemStack(Items.EMERALD, 1 + rand.nextInt(2)), new ItemStack(Items.FEATHER, 3 + rand.nextInt(2)), new ItemStack(Items.ARROW, 16), 1.0f, false, 16, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl1t4(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.BOW, 1), 1.0f, false, 54, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl1t5(new ItemStack(Items.FLINT, 17 + rand.nextInt(5)), null, new ItemStack(Items.EMERALD, 3), 1.0f, false, 14, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl1t6(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.CROSSBOW, 1), 1.0f, false, 62, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl1t7(new ItemStack(Items.EMERALD, 8), null, new ItemStack(MItems.STONE_ARROW.get(), 12), 1.0f, false, 15, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl1t8(new ItemStack(Items.EMERALD, 8), null, new ItemStack(MItems.GOLDEN_ARROW.get(), 12), 1.0f, false, 24, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl2t1(new ItemStack(Items.STRING, 5), new ItemStack(Items.OAK_PLANKS, 4), new ItemStack(MItems.WOODEN_ARROW.get(), 1), 1.0f, false, 24, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl2t2(new ItemStack(Items.EMERALD, 5), null, createTippedArrow(), 1.0f, false, 21, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl2t3(new ItemStack(Items.FEATHER, 21), null, new ItemStack(Items.EMERALD_BLOCK, 2), 1.0f, false, 25, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl2t4(createTippedArrow(), null, new ItemStack(Items.EMERALD, 4), 1.0f, false, 26, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl3t1(new ItemStack(Items.EMERALD, 2), null, new ItemStack(Items.QUARTZ, 1), 1.0f, false, 24, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl3t2(new ItemStack(Items.GLOW_BERRIES, 5), null, new ItemStack(Items.COOKIE, 1), 1.0f, false, 24, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl3t3(new ItemStack(Items.EMERALD, 6), null, new ItemStack(Items.BOW, 1), 1.0f, false, 24, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl4t1(new ItemStack(Items.EMERALD, 5), null, new ItemStack(Items.RAIL, 16), 1.0f, false, 24, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl4t2(new ItemStack(Items.GOLD_INGOT, 5), null, new ItemStack(Items.FLINT, 1), 1.0f, false, 24, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl4t3(new ItemStack(Items.COAL_ORE, 2), null, new ItemStack(Items.FLINT_AND_STEEL, 1), 1.0f, false, 24, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl4t4(new ItemStack(Items.EMERALD_BLOCK, 1), null, new ItemStack(Items.NAME_TAG, 1), 1.0f, false, 24, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl5t1(new ItemStack(Items.EMERALD, 13), null, new ItemStack(Items.ENCHANTED_BOOK, 3), 1.0f, false, 62, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl5t2(new ItemStack(Items.STICK, 6), null, new ItemStack(Items.CROSSBOW, 1), 1.0f, false, 62, 6, "trade.lumberjack.craftingtable"),
        FLETCHERl5t3(new ItemStack(Items.LEATHER, 1), null, new ItemStack(Items.SHEARS, 6), 1.0f, false, 62, 6, "trade.lumberjack.craftingtable");


        public final ItemStack input;
        public final @Nullable ItemStack input2;
        public final ItemStack output;
        public final float chance;
        public final boolean rare;
        public final int xp;
        public final int playerXP;
        public final String translationKey;

        TradeConfig(ItemStack input, @Nullable ItemStack input2, ItemStack output, float chance, boolean rare, int xp, int playerXP, String translationKey) {
            this.input = input;
            this.input2 = input2;
            this.output = output;
            this.chance = chance;
            this.rare = rare;
            this.xp = xp;
            this.playerXP = playerXP;
            this.translationKey = translationKey;
        }

        public ItemStack getOutputStack() {
            return output.copy(); // Always return a new copy to avoid side effects
        }

        public Component getDisplayName() {
            return Component.translatable(translationKey);
        }

        public boolean hasSecondInput() {
            return input2 != null;
        }

        public boolean isCustomTrade() {
            return playerXP != 0;
        }


        public TradeEntry createTrade(int lvl) {
            return new TradeEntry(lvl, input, input2, output, chance, rare, xp, playerXP, translationKey);
        }


        private static ItemStack createTippedArrow() {
            Random random = new Random();
            ItemStack tippedArrow = new ItemStack(Items.TIPPED_ARROW, 6 + random.nextInt(6));
            List<PotionContents> potionContentsList = new ArrayList<>();

            // Add a wide range of potion effects (add more if needed)
            potionContentsList.add(new PotionContents(Potions.STRENGTH));
            potionContentsList.add(new PotionContents(Potions.SWIFTNESS));
            potionContentsList.add(new PotionContents(Potions.HEALING));
            potionContentsList.add(new PotionContents(Potions.HARMING));
            potionContentsList.add(new PotionContents(Potions.REGENERATION));
            potionContentsList.add(new PotionContents(Potions.FIRE_RESISTANCE));
            potionContentsList.add(new PotionContents(Potions.INVISIBILITY));
            potionContentsList.add(new PotionContents(Potions.LEAPING));
            potionContentsList.add(new PotionContents(Potions.LUCK));
            potionContentsList.add(new PotionContents(Potions.NIGHT_VISION));
            potionContentsList.add(new PotionContents(Potions.POISON));
            potionContentsList.add(new PotionContents(Potions.SLOWNESS));
            potionContentsList.add(new PotionContents(Potions.WATER_BREATHING));
            potionContentsList.add(new PotionContents(Potions.WEAKNESS));

            // Choose a random PotionContents
            Random randomfromList = new Random();
            PotionContents randomPotion = potionContentsList.get(randomfromList.nextInt(potionContentsList.size()));

            // Set the arrow with the randomly selected potion
            tippedArrow.set(DataComponents.POTION_CONTENTS, randomPotion);

            return tippedArrow;
        }
    }
}