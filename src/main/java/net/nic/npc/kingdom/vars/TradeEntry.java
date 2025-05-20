package net.nic.npc.kingdom.vars;

import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public class TradeEntry {

    /**
     * Maps are <Keys, Values>
     * map.getKey() returns the Key (for example, the float in stackMap)
     * and
     * map.getValue() returns the value (for example, the item in stackMap)
     */


    /**
      public final ItemStack input;
              public final @Nullable ItemStack input2;
              public final ItemStack output;
              public final float chance;
              public final boolean rare;
              public final int xp;
              public final int custom;
              public final String translationKey;

              TradeConfig(ItemStack input, @Nullable ItemStack input2, ItemStack output, float chance, boolean rare, int xp, int custom, String translationKey) {
                  this.input = input;
                  this.input2 = input2;
                  this.output = output;
                  this.chance = chance;
                  this.rare = rare;
                  this.xp = xp;
                  this.custom = custom;
                  this.translationKey = translationKey;
              }
     */
    public final ItemStack input;
    public final @Nullable ItemStack input2;
    public final ItemStack output;
    public final float chance;
    public final boolean rare;
    public final int xp;
    public final int playerXP;
    public final String translationKey;

    public TradeEntry(int lvl,ItemStack input, @Nullable ItemStack input2, ItemStack output, float chance, boolean rare, int xp, int playerXP, String translationKey) {
        this.input = input;
        this.input2 = input2;
        this.output = output;
        this.chance = chance;
        this.rare = rare;
        this.xp = xp;
        this.playerXP = playerXP;
        this.translationKey = translationKey;
    }


    public float getChance() {
        return chance;
    }

    public int getXp() {
        return xp;
    }

    public int getPlayerXP() {
        return playerXP;
    }
}
