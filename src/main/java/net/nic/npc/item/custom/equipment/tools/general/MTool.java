package net.nic.npc.item.custom.equipment.tools.general;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.nic.npc.item.MDataComponents;
import net.nic.npc.item.custom.MItem;
import net.nic.npc.kingdom.ColorStorage;

import java.util.function.Consumer;

public class MTool extends MItem {

    public MTool(ResourceLocation name, Properties properties) {
        super(name, properties);
    }

    public static Component MININGUPGRADETEXT = Component.translatable("npc.tooltip.miningupgrade");
    public static Component DURABILITYUPGRADE = Component.translatable("npc.tooltip.durabilityugprade");
    public static int maxMiningSpeedUpgrade = 10;


    /**
     * 🔄 Quick Reference for Data Component Access:
     * .get(DataComponentType<T>): Retrieve the component (or null if not present)
     *
     * .set(DataComponentType<T>, value): Set the component.
     *
     * .has(DataComponentType<T>): Check if the component is present.
     *
     * .remove(DataComponentType<T>): Remove the component.
     *
     */

    private static void decreaseRemainingUpgrades(ItemStack result) {
        result.set(MDataComponents.REMAININGUPGRADES, result.getOrDefault(MDataComponents.REMAININGUPGRADES,3) - 1);
    }

    /**
     * MININGSPEED
     */
    public void clearMiningSpeed(ItemStack result) {
        if (result.has(getMiningData())) result.remove(getMiningData());
    }

    public boolean canAddMiningSpeed(ItemStack result) {
        if (result.has(getMiningData())) return false;
        else return true;
    }

    /**
     * Player can't add mining speed to an item with mining speed in it, he will have to clear it first
     */
    public void addMiningSpeed(ItemStack stack, ItemStack infusion) {
        if (!stack.has(getMiningData())) {
            float value = infusion.getCount();
            value = (value * maxMiningSpeedUpgrade) / 64;
            stack.set(getMiningData(), value);
            decreaseRemainingUpgrades(stack);
        }
    }

    private static DeferredHolder<DataComponentType<?>, DataComponentType<Float>> getMiningData() {
        DeferredHolder<DataComponentType<?>, DataComponentType<Float>> miningData = MDataComponents.DIG_MINING_UPGRADE;
        return miningData;
    }


    /**
     * Durability
     */
    @SuppressWarnings("DataFlowIssue")
    public void upgradeDurability(ItemStack stack, int lvl) {
        final DataComponentType<Integer> maxDamage = DataComponents.MAX_DAMAGE;
        int added = switch (lvl) {
            case 1 -> 500;
            case 2 -> 1000;
            default -> 1500;
        };
        stack.set(maxDamage, stack.get(maxDamage) + added);
        stack.set(MDataComponents.ISENDURED, true);
        stack.set(MDataComponents.DURABILITY_UPGRADE_AMOUNT, added); // Store the actual upgrade amount
        decreaseRemainingUpgrades(stack);

    }


    /**
     * ToolTips
     */
    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag flag) {
        super.appendHoverText(stack, context, tooltipDisplay, tooltipAdder, flag);

        if (stack.has(MDataComponents.DIG_MINING_UPGRADE)) {
            createToolTip(stack, tooltipAdder, this.MININGUPGRADETEXT, MDataComponents.DIG_MINING_UPGRADE.get(), ColorStorage.aliceBlue);

        }
        if (stack.has(MDataComponents.ISENDURED) && stack.has(MDataComponents.DURABILITY_UPGRADE_AMOUNT)) {
            createToolTip(stack, tooltipAdder, this.DURABILITYUPGRADE, MDataComponents.DURABILITY_UPGRADE_AMOUNT.get(), ColorStorage.mediumSpringGreen);
        }
    }

    private static <T> void createToolTip(ItemStack stack, Consumer<Component> tooltipAdder, Component component, DataComponentType<T> data, int color) {
        T value = stack.get(data);
            tooltipAdder.accept(component.copy().append(Component.literal(String.valueOf(value))).withColor(color));
    }
}
