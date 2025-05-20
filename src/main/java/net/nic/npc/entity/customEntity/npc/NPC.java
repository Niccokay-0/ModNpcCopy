package net.nic.npc.entity.customEntity.npc;

import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.phys.Vec3;
import net.nic.npc.entity.MEntities;
import net.nic.npc.kingdom.vars.TradeEntry;
import net.nic.npc.gui.NPCInterface.MenuR;
import net.nic.npc.kingdom.Kingdom;
import net.nic.npc.kingdom.events.KingdomEventManager;
import net.nic.npc.kingdom.users.KingdomNPC;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.nic.npc.kingdom.vars.Trades.TradeConfig.*;

public class NPC extends PathfinderMob {

    private int lvl = 0;
    private int xp = 0;
    private int lXp = 100;

    public List<TradeEntry> allTrades = new ArrayList<>();

    public void trades() {
        System.out.println(this.getLvl());

        switch (this.job) {
            default -> {
            }
            case FARMER -> {
                switch (this.getLvl()) {
                    case 1 -> {
                        List<TradeEntry> trades1 = new ArrayList<>();

                        TradeEntry trade1 = FARMERl1t1.createTrade(lvl);
                        TradeEntry trade2 = FARMERl1t2.createTrade(lvl);

                        trades1.add(trade1);
                        trades1.add(trade2);

                        float totalChance = calculateChances(trades1);

                        selectTrade(trades1, totalChance);
                        trades1.clear();
                    }
                    case 2 -> {
                        List<TradeEntry> trades2 = new ArrayList<>();

                        TradeEntry trade1 = FARMERl2t1.createTrade(lvl);
                        TradeEntry trade2 = FARMERl2t2.createTrade(lvl);
                        TradeEntry trade3 = FARMERl2t3.createTrade(lvl);

                        trades2.add(trade1);
                        trades2.add(trade2);
                        trades2.add(trade3);

                        float totalChance = calculateChances(trades2);
                        selectTrade(trades2, totalChance);
                        trades2.clear();
                    }
                    case 3 -> {
                        List<TradeEntry> trades3 = new ArrayList<>();

                        TradeEntry trade1 = FARMERl3t1.createTrade(lvl);
                        TradeEntry trade2 = FARMERl3t2.createTrade(lvl);
                        TradeEntry trade3 = FARMERl3t3.createTrade(lvl);

                        trades3.add(trade1);
                        trades3.add(trade2);
                        trades3.add(trade3);

                        float totalChance = calculateChances(trades3);
                        selectTrade(trades3, totalChance);
                        trades3.clear();

                    }
                    case 4 -> {
                        List<TradeEntry> trades4 = new ArrayList<>();

                        TradeEntry trade1 = FARMERl4t1.createTrade(lvl);
                        TradeEntry trade2 = FARMERl4t2.createTrade(lvl);

                        trades4.add(trade1);
                        trades4.add(trade2);

                        float totalChance = calculateChances(trades4);
                        selectTrade(trades4, totalChance);
                        trades4.clear();
                    }
                    case 5 -> {
                        List<TradeEntry> trades5 = new ArrayList<>();

                        TradeEntry trade1 = FARMERl5t1.createTrade(lvl);
                        TradeEntry trade2 = FARMERl5t2.createTrade(lvl);

                        trades5.add(trade1);
                        trades5.add(trade2);

                        float totalChance = calculateChances(trades5);
                        selectTrade(trades5, totalChance);
                        trades5.clear();
                    }
                }
            }
            case MINER -> {
                switch (this.getLvl()) {
                    case 1 -> {
                        List<TradeEntry> trades1 = new ArrayList<>();

                        TradeEntry trade1 = MINERl1t1.createTrade(lvl);
                        TradeEntry trade2 = MINERl1t2.createTrade(lvl);
                        TradeEntry trade3 = MINERl1t3.createTrade(lvl);
                        TradeEntry trade4 = MINERl1t4.createTrade(lvl);


                        trades1.add(trade1);
                        trades1.add(trade2);
                        trades1.add(trade3);
                        trades1.add(trade4);

                        float totalChance = calculateChances(trades1);

                        selectTrade(trades1, totalChance);
                        trades1.clear();


                        TradeEntry trade5 = MINERl1t5.createTrade(lvl);
                        TradeEntry trade6 = MINERl1t6.createTrade(lvl);
                        TradeEntry trade7 = MINERl1t7.createTrade(lvl);
                        TradeEntry trade8 = MINERl1t8.createTrade(lvl);


                        trades1.add(trade5);
                        trades1.add(trade6);
                        trades1.add(trade7);
                        trades1.add(trade8);

                        totalChance = calculateChances(trades1);

                        selectTrade(trades1, totalChance);
                        trades1.clear();
                    }
                    case 2 -> {
                        List<TradeEntry> trades2 = new ArrayList<>();

                        TradeEntry trade1 = MINERl2t1.createTrade(lvl);
                        TradeEntry trade2 = MINERl2t2.createTrade(lvl);
                        TradeEntry trade3 = MINERl2t3.createTrade(lvl);

                        trades2.add(trade1);
                        trades2.add(trade2);
                        trades2.add(trade3);

                        float totalChance = calculateChances(trades2);
                        selectTrade(trades2, totalChance);
                        trades2.clear();
                    }
                    case 3 -> {
                        List<TradeEntry> trades3 = new ArrayList<>();

                        TradeEntry trade1 = MINERl3t1.createTrade(lvl);
                        TradeEntry trade2 = MINERl3t2.createTrade(lvl);

                        trades3.add(trade1);
                        trades3.add(trade2);

                        float totalChance = calculateChances(trades3);
                        selectTrade(trades3, totalChance);
                        trades3.clear();

                    }
                    case 4 -> {
                        List<TradeEntry> trades4 = new ArrayList<>();

                        TradeEntry trade1 = MINERl4t1.createTrade(lvl);
                        TradeEntry trade2 = MINERl4t2.createTrade(lvl);

                        trades4.add(trade1);
                        trades4.add(trade2);

                        float totalChance = calculateChances(trades4);
                        selectTrade(trades4, totalChance);
                        trades4.clear();
                    }
                    case 5 -> {
                        List<TradeEntry> trades5 = new ArrayList<>();

                        TradeEntry trade1 = MINERl5t1.createTrade(lvl);
                        TradeEntry trade2 = MINERl5t2.createTrade(lvl);
                        TradeEntry trade3 = MINERl5t3.createTrade(lvl);

                        trades5.add(trade1);
                        trades5.add(trade2);
                        trades5.add(trade3);

                        float totalChance = calculateChances(trades5);
                        selectTrade(trades5, totalChance);
                        trades5.clear();
                    }
                }
            }
            case MERCHANT -> {
                switch (this.getLvl()) {
                    case 1 -> {
                        List<TradeEntry> trades1 = new ArrayList<>();

                        TradeEntry trade1 = MERCHANTl1t1.createTrade(lvl);
                        TradeEntry trade4 = MERCHANTl1t4.createTrade(lvl);

                        trades1.add(trade1);
                        trades1.add(trade4);

                        float totalChance = calculateChances(trades1);

                        selectTrade(trades1, totalChance);
                        trades1.clear();


                        TradeEntry trade2 = MERCHANTl1t2.createTrade(lvl);
                        TradeEntry trade3 = MERCHANTl1t3.createTrade(lvl);

                        trades1.add(trade2);
                        trades1.add(trade3);

                        totalChance = calculateChances(trades1);

                        selectTrade(trades1, totalChance);
                        trades1.clear();
                    }
                    case 2 -> {
                        List<TradeEntry> trades2 = new ArrayList<>();

                        TradeEntry trade1 = MERCHANTl2t1.createTrade(lvl);
                        TradeEntry trade2 = MERCHANTl2t2.createTrade(lvl);
                        TradeEntry trade3 = MERCHANTl2t3.createTrade(lvl);
                        TradeEntry trade4 = MERCHANTl2t4.createTrade(lvl);

                        trades2.add(trade1);
                        trades2.add(trade2);
                        trades2.add(trade3);
                        trades2.add(trade4);

                        float totalChance = calculateChances(trades2);
                        selectTrade(trades2, totalChance);
                        trades2.clear();
                    }
                    case 3 -> {
                        List<TradeEntry> trades3 = new ArrayList<>();

                        TradeEntry trade2 = MERCHANTl3t2.createTrade(lvl);
                        TradeEntry trade3 = MERCHANTl3t3.createTrade(lvl);

                        trades3.add(trade2);
                        trades3.add(trade3);

                        float totalChance = calculateChances(trades3);
                        selectTrade(trades3, totalChance);
                        trades3.clear();

                        TradeEntry trade1 = MERCHANTl3t1.createTrade(lvl);
                        TradeEntry trade4 = MERCHANTl3t4.createTrade(lvl);
                        trades3.add(trade1);
                        trades3.add(trade4);
                        totalChance = calculateChances(trades3);
                        selectTrade(trades3, totalChance);
                        trades3.clear();


                    }
                    case 4 -> {
                        List<TradeEntry> trades4 = new ArrayList<>();

                        TradeEntry trade1 = MERCHANTl4t1.createTrade(lvl);
                        TradeEntry trade2 = MERCHANTl4t2.createTrade(lvl);
                        TradeEntry trade3 = MERCHANTl4t3.createTrade(lvl);

                        trades4.add(trade1);
                        trades4.add(trade2);
                        trades4.add(trade3);

                        float totalChance = calculateChances(trades4);
                        selectTrade(trades4, totalChance);
                        trades4.clear();
                    }
                    case 5 -> {
                        List<TradeEntry> trades5 = new ArrayList<>();

                        TradeEntry trade1 = MERCHANTl5t1.createTrade(lvl);
                        TradeEntry trade2 = MERCHANTl5t2.createTrade(lvl);

                        trades5.add(trade1);
                        trades5.add(trade2);

                        float totalChance = calculateChances(trades5);
                        selectTrade(trades5, totalChance);
                        trades5.clear();

                        TradeEntry trade3 = MERCHANTl5t3.createTrade(lvl);
                        TradeEntry trade4 = MERCHANTl5t4.createTrade(lvl);

                        trades5.add(trade3);
                        trades5.add(trade4);

                        totalChance = calculateChances(trades5);
                        selectTrade(trades5, totalChance);
                        trades5.clear();
                    }
                }

            }
            case BLACKSMITH -> {
                switch (this.getLvl()) {
                    case 1 -> {
                        List<TradeEntry> trades1 = new ArrayList<>();

                        TradeEntry trade1 = BLACKSMITHl1t1.createTrade(lvl);
                        TradeEntry trade2 = BLACKSMITHl1t2.createTrade(lvl);
                        TradeEntry trade3 = BLACKSMITHl1t3.createTrade(lvl);

                        trades1.add(trade1);
                        trades1.add(trade2);
                        trades1.add(trade3);

                        float totalChance = calculateChances(trades1);

                        selectTrade(trades1, totalChance);
                        trades1.clear();
                    }
                    case 2 -> {
                        List<TradeEntry> trades2 = new ArrayList<>();

                        TradeEntry trade1 = BLACKSMITHl2t1.createTrade(lvl);
                        TradeEntry trade2 = BLACKSMITHl2t2.createTrade(lvl);
                        TradeEntry trade3 = BLACKSMITHl2t3.createTrade(lvl);

                        trades2.add(trade1);
                        trades2.add(trade2);
                        trades2.add(trade3);

                        float totalChance = calculateChances(trades2);
                        selectTrade(trades2, totalChance);
                        trades2.clear();
                    }
                    case 3 -> {
                        List<TradeEntry> trades3 = new ArrayList<>();

                        TradeEntry trade1 = BLACKSMITHl3t1.createTrade(lvl);
                        TradeEntry trade2 = BLACKSMITHl3t2.createTrade(lvl);

                        trades3.add(trade1);
                        trades3.add(trade2);

                        float totalChance = calculateChances(trades3);
                        selectTrade(trades3, totalChance);
                        trades3.clear();

                    }
                    case 4 -> {
                        List<TradeEntry> trades4 = new ArrayList<>();

                        TradeEntry trade1 = BLACKSMITHl4t1.createTrade(lvl);
                        TradeEntry trade2 = BLACKSMITHl4t2.createTrade(lvl);

                        trades4.add(trade1);
                        trades4.add(trade2);

                        float totalChance = calculateChances(trades4);
                        selectTrade(trades4, totalChance);
                        trades4.clear();
                    }
                    case 5 -> {
                        List<TradeEntry> trades5 = new ArrayList<>();

                        TradeEntry trade1 = BLACKSMITHl5t1.createTrade(lvl);
                        TradeEntry trade2 = BLACKSMITHl5t2.createTrade(lvl);

                        trades5.add(trade1);
                        trades5.add(trade2);

                        float totalChance = calculateChances(trades5);
                        selectTrade(trades5, totalChance);
                        trades5.clear();
                    }
                }
            }
            case FISHER -> {
                switch (this.getLvl()) {
                    case 1 -> {
                        List<TradeEntry> trades1 = new ArrayList<>();

                        TradeEntry trade1 = FISHERl1t1.createTrade(lvl);
                        TradeEntry trade2 = FISHERl1t2.createTrade(lvl);
                        TradeEntry trade3 = FISHERl1t3.createTrade(lvl);
                        TradeEntry trade4 = FISHERl1t4.createTrade(lvl);
                        TradeEntry trade5 = FISHERl1t5.createTrade(lvl);
                        TradeEntry trade6 = FISHERl1t6.createTrade(lvl);
                        TradeEntry trade7 = FISHERl1t7.createTrade(lvl);


                        trades1.add(trade1);
                        trades1.add(trade2);
                        trades1.add(trade3);
                        trades1.add(trade4);
                        trades1.add(trade5);
                        trades1.add(trade6);
                        trades1.add(trade7);


                        float totalChance = calculateChances(trades1);

                        selectTrade(trades1, totalChance);
                        trades1.clear();
                    }
                    case 2 -> {
                        List<TradeEntry> trades2 = new ArrayList<>();

                        TradeEntry trade1 = FISHERl2t1.createTrade(lvl);

                        trades2.add(trade1);

                        float totalChance = calculateChances(trades2);
                        selectTrade(trades2, totalChance);
                        trades2.clear();
                    }
                    case 3 -> {
                        List<TradeEntry> trades3 = new ArrayList<>();

                        TradeEntry trade1 = FISHERl3t1.createTrade(lvl);
                        TradeEntry trade2 = FISHERl3t2.createTrade(lvl);

                        trades3.add(trade1);
                        trades3.add(trade2);

                        float totalChance = calculateChances(trades3);
                        selectTrade(trades3, totalChance);
                        trades3.clear();

                    }
                    case 4 -> {
                        List<TradeEntry> trades4 = new ArrayList<>();

                        TradeEntry trade1 = FISHERl4t1.createTrade(lvl);

                        trades4.add(trade1);

                        float totalChance = calculateChances(trades4);
                        selectTrade(trades4, totalChance);
                        trades4.clear();
                    }
                    case 5 -> {
                        List<TradeEntry> trades5 = new ArrayList<>();

                        TradeEntry trade1 = FISHERl5t1.createTrade(lvl);

                        trades5.add(trade1);

                        float totalChance = calculateChances(trades5);
                        selectTrade(trades5, totalChance);
                        trades5.clear();
                    }
                }
            }
            case BUTCHER -> {
                switch (this.getLvl()) {
                    case 1 -> {
                        List<TradeEntry> trades1 = new ArrayList<>();

                        TradeEntry trade1 = BUTCHERl1t1.createTrade(lvl);

                        TradeEntry trade4 = BUTCHERl1t4.createTrade(lvl);

                        trades1.add(trade1);
                        trades1.add(trade4);

                        float totalChance = calculateChances(trades1);
                        selectTrade(trades1, totalChance);
                        trades1.clear();

                        TradeEntry trade2 = BUTCHERl1t2.createTrade(lvl);
                        TradeEntry trade3 = BUTCHERl1t3.createTrade(lvl);

                        trades1.add(trade2);
                        trades1.add(trade3);

                        totalChance = calculateChances(trades1);
                        selectTrade(trades1, totalChance);
                        trades1.clear();
                    }
                    case 2 -> {
                        List<TradeEntry> trades2 = new ArrayList<>();

                        TradeEntry trade1 = BUTCHERl2t1.createTrade(lvl);
                        TradeEntry trade2 = BUTCHERl2t2.createTrade(lvl);

                        trades2.add(trade1);
                        trades2.add(trade2);

                        float totalChance = calculateChances(trades2);
                        selectTrade(trades2, totalChance);
                        trades2.clear();

                        TradeEntry trade3 = BUTCHERl2t3.createTrade(lvl);
                        TradeEntry trade4 = BUTCHERl2t4.createTrade(lvl);


                        trades2.add(trade3);
                        trades2.add(trade4);

                        totalChance = calculateChances(trades2);
                        selectTrade(trades2, totalChance);
                        trades2.clear();
                    }
                    case 3 -> {
                        List<TradeEntry> trades3 = new ArrayList<>();

                        TradeEntry trade1 = BUTCHERl3t1.createTrade(lvl);

                        TradeEntry trade4 = BUTCHERl3t4.createTrade(lvl);

                        trades3.add(trade1);
                        trades3.add(trade4);

                        float totalChance = calculateChances(trades3);
                        selectTrade(trades3, totalChance);
                        trades3.clear();

                        TradeEntry trade2 = BUTCHERl3t2.createTrade(lvl);
                        TradeEntry trade3 = BUTCHERl3t3.createTrade(lvl);

                        trades3.add(trade2);
                        trades3.add(trade3);

                        totalChance = calculateChances(trades3);
                        selectTrade(trades3, totalChance);
                        trades3.clear();

                    }
                    case 4 -> {
                        List<TradeEntry> trades4 = new ArrayList<>();

                        TradeEntry trade1 = BUTCHERl4t1.createTrade(lvl);
                        TradeEntry trade2 = BUTCHERl4t2.createTrade(lvl);
                        TradeEntry trade3 = BUTCHERl4t3.createTrade(lvl);

                        trades4.add(trade1);
                        trades4.add(trade2);
                        trades4.add(trade3);

                        float totalChance = calculateChances(trades4);
                        selectTrade(trades4, totalChance);
                        trades4.clear();
                    }
                    case 5 -> {
                        List<TradeEntry> trades5 = new ArrayList<>();

                        TradeEntry trade1 = BUTCHERl5t1.createTrade(lvl);

                        trades5.add(trade1);

                        float totalChance = calculateChances(trades5);
                        selectTrade(trades5, totalChance);
                        trades5.clear();
                    }
                }
            }
            case LUMBERJACK -> {
                switch (this.getLvl()) {
                    case 1 -> {
                        List<TradeEntry> trades1 = new ArrayList<>();

                        TradeEntry trade1 = LUMBERJACKl1t1.createTrade(lvl);
                        TradeEntry trade2 = LUMBERJACKl1t2.createTrade(lvl);
                        TradeEntry trade3 = LUMBERJACKl1t3.createTrade(lvl);
                        TradeEntry trade4 = LUMBERJACKl1t4.createTrade(lvl);
                        TradeEntry trade5 = LUMBERJACKl1t5.createTrade(lvl);
                        TradeEntry trade6 = LUMBERJACKl1t6.createTrade(lvl);
                        TradeEntry trade7 = LUMBERJACKl1t7.createTrade(lvl);
                        TradeEntry trade8 = LUMBERJACKl1t8.createTrade(lvl);
                        TradeEntry trade9 = LUMBERJACKl1t9.createTrade(lvl);
                        TradeEntry trade10 = LUMBERJACKl1t10.createTrade(lvl);


                        trades1.add(trade1);
                        trades1.add(trade2);
                        trades1.add(trade3);
                        trades1.add(trade4);
                        trades1.add(trade5);
                        trades1.add(trade6);
                        trades1.add(trade7);
                        trades1.add(trade8);
                        trades1.add(trade9);
                        trades1.add(trade10);


                        float totalChance = calculateChances(trades1);

                        selectTrade(trades1, totalChance);
                        trades1.clear();

                        TradeEntry trade11 = LUMBERJACKl1t11.createTrade(lvl);
                        TradeEntry trade12 = LUMBERJACKl1t12.createTrade(lvl);
                        TradeEntry trade13 = LUMBERJACKl1t13.createTrade(lvl);
                        TradeEntry trade14 = LUMBERJACKl1t14.createTrade(lvl);
                        TradeEntry trade15 = LUMBERJACKl1t15.createTrade(lvl);
                        TradeEntry trade16 = LUMBERJACKl1t16.createTrade(lvl);
                        TradeEntry trade17 = LUMBERJACKl1t17.createTrade(lvl);
                        TradeEntry trade18 = LUMBERJACKl1t18.createTrade(lvl);
                        TradeEntry trade19 = LUMBERJACKl1t19.createTrade(lvl);
                        TradeEntry trade20 = LUMBERJACKl1t20.createTrade(lvl);
                        TradeEntry trade21 = LUMBERJACKl1t21.createTrade(lvl);
                        TradeEntry trade22 = LUMBERJACKl1t22.createTrade(lvl);

                        trades1.add(trade11);
                        trades1.add(trade12);
                        trades1.add(trade13);
                        trades1.add(trade14);
                        trades1.add(trade15);
                        trades1.add(trade16);
                        trades1.add(trade17);
                        trades1.add(trade18);
                        trades1.add(trade19);
                        trades1.add(trade20);
                        trades1.add(trade21);
                        trades1.add(trade22);


                        totalChance = calculateChances(trades1);

                        selectTrade(trades1, totalChance);
                        trades1.clear();
                    }
                    case 2 -> {
                        List<TradeEntry> trades2 = new ArrayList<>();

                        TradeEntry trade1 = LUMBERJACKl2t1.createTrade(lvl);
                        TradeEntry trade2 = LUMBERJACKl2t2.createTrade(lvl);
                        TradeEntry trade3 = LUMBERJACKl2t3.createTrade(lvl);

                        trades2.add(trade1);
                        trades2.add(trade2);
                        trades2.add(trade3);

                        float totalChance = calculateChances(trades2);
                        selectTrade(trades2, totalChance);
                        trades2.clear();
                    }
                    case 3 -> {
                        List<TradeEntry> trades3 = new ArrayList<>();

                        TradeEntry trade1 = LUMBERJACKl3t1.createTrade(lvl);
                        TradeEntry trade2 = LUMBERJACKl3t2.createTrade(lvl);

                        trades3.add(trade1);
                        trades3.add(trade2);

                        float totalChance = calculateChances(trades3);
                        selectTrade(trades3, totalChance);
                        trades3.clear();

                        TradeEntry trade3 = LUMBERJACKl3t3.createTrade(lvl);
                        TradeEntry trade4 = LUMBERJACKl3t4.createTrade(lvl);


                        trades3.add(trade3);
                        trades3.add(trade4);

                        totalChance = calculateChances(trades3);
                        selectTrade(trades3, totalChance);
                        trades3.clear();

                    }
                    case 4 -> {
                        List<TradeEntry> trades4 = new ArrayList<>();

                        TradeEntry trade1 = LUMBERJACKl4t1.createTrade(lvl);
                        TradeEntry trade2 = LUMBERJACKl4t2.createTrade(lvl);

                        trades4.add(trade1);
                        trades4.add(trade2);

                        float totalChance = calculateChances(trades4);
                        selectTrade(trades4, totalChance);
                        trades4.clear();
                    }
                    case 5 -> {
                        List<TradeEntry> trades5 = new ArrayList<>();

                        TradeEntry trade1 = LUMBERJACKl5t1.createTrade(lvl);

                        trades5.add(trade1);

                        float totalChance = calculateChances(trades5);
                        selectTrade(trades5, totalChance);
                        trades5.clear();
                    }
                }
            }
            case FLETCHER -> {
                switch (this.getLvl()) {
                    case 1 -> {
                        List<TradeEntry> trades1 = new ArrayList<>();

                        TradeEntry trade1 = FLETCHERl1t1.createTrade(lvl);
                        TradeEntry trade2 = FLETCHERl1t2.createTrade(lvl);
                        TradeEntry trade3 = FLETCHERl1t3.createTrade(lvl);
                        TradeEntry trade4 = FLETCHERl1t4.createTrade(lvl);
                        TradeEntry trade5 = FLETCHERl1t5.createTrade(lvl);
                        TradeEntry trade6 = FLETCHERl1t6.createTrade(lvl);
                        TradeEntry trade7 = FLETCHERl1t7.createTrade(lvl);
                        TradeEntry trade8 = FLETCHERl1t8.createTrade(lvl);

                        trades1.add(trade1);
                        trades1.add(trade2);
                        trades1.add(trade3);
                        trades1.add(trade4);
                        trades1.add(trade5);
                        trades1.add(trade6);
                        trades1.add(trade7);
                        trades1.add(trade8);

                        float totalChance = calculateChances(trades1);
                        selectTrade(trades1, totalChance);
                        trades1.clear();

                    }
                    case 2 -> {
                        List<TradeEntry> trades2 = new ArrayList<>();

                        TradeEntry trade1 = FLETCHERl2t1.createTrade(lvl);
                        TradeEntry trade2 = FLETCHERl2t2.createTrade(lvl);
                        TradeEntry trade3 = FLETCHERl2t3.createTrade(lvl);
                        TradeEntry trade4 = FLETCHERl2t4.createTrade(lvl);

                        trades2.add(trade1);
                        trades2.add(trade2);
                        trades2.add(trade3);
                        trades2.add(trade4);

                        float totalChance = calculateChances(trades2);
                        selectTrade(trades2, totalChance);
                        trades2.clear();


                    }
                    case 3 -> {
                        List<TradeEntry> trades3 = new ArrayList<>();

                        TradeEntry trade1 = FLETCHERl3t1.createTrade(lvl);
                        TradeEntry trade2 = FLETCHERl3t2.createTrade(lvl);
                        TradeEntry trade3 = FLETCHERl3t3.createTrade(lvl);

                        trades3.add(trade1);
                        trades3.add(trade2);
                        trades3.add(trade3);

                        float totalChance = calculateChances(trades3);
                        selectTrade(trades3, totalChance);
                        trades3.clear();
                    }
                    case 4 -> {
                        List<TradeEntry> trades4 = new ArrayList<>();

                        TradeEntry trade1 = FLETCHERl4t1.createTrade(lvl);
                        TradeEntry trade2 = FLETCHERl4t2.createTrade(lvl);
                        TradeEntry trade3 = FLETCHERl4t3.createTrade(lvl);
                        TradeEntry trade4 = FLETCHERl4t4.createTrade(lvl);
                        //TradeEntry trade5 = FLETCHERl4t5.createTrade(lvl);
                        //TradeEntry trade6 = FLETCHERl4t6.createTrade(lvl);

                        trades4.add(trade1);
                        trades4.add(trade2);
                        trades4.add(trade3);
                        trades4.add(trade4);
                        //trades4.add(trade5);
                        //trades4.add(trade6);

                        float totalChance = calculateChances(trades4);
                        selectTrade(trades4, totalChance);
                        trades4.clear();

                    }
                    case 5 -> {
                        List<TradeEntry> trades5 = new ArrayList<>();

                        TradeEntry trade1 = FLETCHERl5t1.createTrade(lvl);
                        TradeEntry trade2 = FLETCHERl5t2.createTrade(lvl);
                        TradeEntry trade3 = FLETCHERl5t3.createTrade(lvl);

                        trades5.add(trade1);
                        trades5.add(trade2);
                        trades5.add(trade3);

                        float totalChance = calculateChances(trades5);
                        selectTrade(trades5, totalChance);
                        trades5.clear();
                    }
                }
            }
        }
    }


    private static float calculateChances(List<TradeEntry> trades1) {
        float totalChance = 0f;
        for (TradeEntry trade : trades1) {
            totalChance += trade.getChance();
        }
        return totalChance;
    }


    private void selectTrade(List<TradeEntry> tradeEntryList, float totalChance) {
        float randomFloat = (float) Math.random() * totalChance; // Random number between 0 and totalChance

        float cumulativeChance = 0f;
        for (TradeEntry trade : tradeEntryList) {
            cumulativeChance += trade.getChance();
            if (randomFloat <= cumulativeChance) {
                allTrades.add(trade);
                break;
            }
        }
    }

    public void addXp(int xpValue) {

        xp += xpValue;
        if (xp >= lXp) {
            addLvl();
            xp -= lXp;
            lXp = lXp * 2; //todo lvl 1->2 = 100; lvl 2->3 = 200; lvl 3->4 = 400; lvl 4->5 = 800; lvl 5->6 = 1600;
        }

    }

    public int getLvl() {
        return this.lvl;
    }

    public void addLvl() {
        if (lvl < 5) {
            this.lvl++;
        }
        this.trades();
    }

    public boolean isRecruited = false;

    private enum JOBS {
        FARMER, MINER, BLACKSMITH, MERCHANT, FISHER, BUTCHER, LUMBERJACK, FLETCHER
    }

    private final String[] NAMES = {"Alex", "Jamie", "Taylor", "Morgan", "Casey"};
    private final String[] LAST_NAMES = {"Smith", "Johnson", "Brown", "Lee", "Garcia"};
    private final String[] GENDERS = {"Male", "Female"};

    private final String[] JOB = Arrays.stream(JOBS.values()).map(Enum::name).toArray(String[]::new);


    public String firstName;
    public String lastName;
    public String gender;
    public JOBS job;
    public int happiness;
    public int textureVariant;

    public NPC(EntityType<? extends NPC> entityType, Level level) {
        super(MEntities.NPC.get(), level);
        this.firstName = NAMES[random.nextInt(NAMES.length)];
        this.lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        this.gender = GENDERS[random.nextInt(GENDERS.length)];
        this.job = JOBS.values()[random.nextInt(JOBS.values().length)];
        this.happiness = random.nextInt(101);
        this.textureVariant = random.nextInt(21);
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, EntitySpawnReason spawnReason, @Nullable SpawnGroupData spawnGroupData) {
        this.firstName = NAMES[random.nextInt(NAMES.length)];
        this.lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        this.gender = GENDERS[random.nextInt(GENDERS.length)];
        this.job = JOBS.valueOf(JOB[random.nextInt(JOB.length)]);
        this.happiness = random.nextInt(101);
        this.textureVariant = random.nextInt(21);
        return super.finalizeSpawn(level, difficulty, spawnReason, spawnGroupData);
    }

    @Override
    public InteractionResult interactAt(Player player, Vec3 vec, InteractionHand hand) {
        player.setLastHurtMob(this);
        MenuProvider provider = new SimpleMenuProvider((containerId, playerInventory, player1) -> new MenuR(containerId, playerInventory), Component.translatable("npc.gui.menu.menur"));
        player.openMenu(provider);

        return super.interactAt(player, vec, hand);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 2.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.3));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 4.0f));
    }


    public void setRecruited() {
        isRecruited = true;
    }

    public void setUnrecruited() {
        isRecruited = false;
    }

    @Override
    public void onRemovedFromLevel() {
        KingdomNPC kNpc = KingdomEventManager.getInstance().getallNPCS().get(this.getUUID());
        if (kNpc != null && kNpc.isInKingdom()) {
            Kingdom kingdom = KingdomEventManager.getInstance().getKingdom(kNpc.getKingdomID());
            kingdom.removeCitizen(this);
            KingdomEventManager.getInstance().leaveNPC(this);
        }
    }
}