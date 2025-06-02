package net.nic.npc.item.custom.equipment;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SmithingTemplateItem;

import java.util.List;
public class ModSmithingTemplates extends SmithingTemplateItem {


    private static final ResourceLocation EMPTY_SLOT_HELMET = ResourceLocation.withDefaultNamespace("container/slot/helmet");
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE = ResourceLocation.withDefaultNamespace("container/slot/chestplate");
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS = ResourceLocation.withDefaultNamespace("container/slot/leggings");
    private static final ResourceLocation EMPTY_SLOT_BOOTS = ResourceLocation.withDefaultNamespace("container/slot/boots");
    private static final ResourceLocation EMPTY_SLOT_HOE = ResourceLocation.withDefaultNamespace("container/slot/hoe");
    private static final ResourceLocation EMPTY_SLOT_AXE = ResourceLocation.withDefaultNamespace("container/slot/axe");
    private static final ResourceLocation EMPTY_SLOT_SWORD = ResourceLocation.withDefaultNamespace("container/slot/sword");
    private static final ResourceLocation EMPTY_SLOT_SHOVEL = ResourceLocation.withDefaultNamespace("container/slot/shovel");
    private static final ResourceLocation EMPTY_SLOT_PICKAXE = ResourceLocation.withDefaultNamespace("container/slot/pickaxe");
    private static final ResourceLocation EMPTY_SLOT_INGOT = ResourceLocation.withDefaultNamespace("container/slot/ingot");
    private static final ResourceLocation EMPTY_SLOT_REDSTONE_DUST = ResourceLocation.withDefaultNamespace("container/slot/redstone_dust");
    private static final ResourceLocation EMPTY_SLOT_QUARTZ = ResourceLocation.withDefaultNamespace("container/slot/quartz");
    private static final ResourceLocation EMPTY_SLOT_EMERALD = ResourceLocation.withDefaultNamespace("container/slot/emerald");
    private static final ResourceLocation EMPTY_SLOT_DIAMOND = ResourceLocation.withDefaultNamespace("container/slot/diamond");
    private static final ResourceLocation EMPTY_SLOT_LAPIS_LAZULI = ResourceLocation.withDefaultNamespace("container/slot/lapis_lazuli");
    private static final ResourceLocation EMPTY_SLOT_AMETHYST_SHARD = ResourceLocation.withDefaultNamespace("container/slot/amethyst_shard");

    public static final Component BLAZED_APPLIES_TO = Component.translatable("item.npc.blazed_smithing_template.applies_to").withStyle(ChatFormatting.BLUE);
    public static final Component BLAZED_INGREDIENTS = Component.translatable("item.npc.blazed_smithing_template.ingredients").withStyle(ChatFormatting.BLUE);
    public static final Component BLAZED_BASE_SLOT_DESCRIPTION = Component.translatable("item.npc.blazed_smithing_template.base_slot_description");
    public static final Component BLAZED_ADDITIONS_SLOT_DESCRIPTION = Component.translatable("item.npc.blazed_smithing_template.additions_slot_description");

    public static final Component ENDER_APPLIES_TO = Component.translatable("item.npc.ender_smithing_template.applies_to").withStyle(ChatFormatting.DARK_PURPLE);
    public static final Component ENDER_INGREDIENTS = Component.translatable("item.npc.ender_smithing_template.ingredients").withStyle(ChatFormatting.DARK_PURPLE);
    public static final Component ENDER_BASE_SLOT_DESCRIPTION = Component.translatable("item.npc.ender_smithing_template.base_slot_description");
    public static final Component ENDER_ADDITIONS_SLOT_DESCRIPTION = Component.translatable("item.npc.ender_smithing_template.additions_slot_description");

    public static final Component PURPUR_APPLIES_TO = Component.translatable("item.npc.purpur_smithing_template.applies_to").withStyle(ChatFormatting.DARK_PURPLE);
    public static final Component PURPUR_INGREDIENTS = Component.translatable("item.npc.purpur_smithing_template.ingredients").withStyle(ChatFormatting.DARK_PURPLE);
    public static final Component PURPUR_BASE_SLOT_DESCRIPTION = Component.translatable("item.npc.purpur_smithing_template.base_slot_description");
    public static final Component PURPUR_ADDITIONS_SLOT_DESCRIPTION = Component.translatable("item.npc.purpur_smithing_template.additions_slot_description");

    public ModSmithingTemplates(Component appliesTo, Component ingredients, Component baseSlotDescription, Component additionsSlotDescription, List<ResourceLocation> baseSlotEmptyIcons, List<ResourceLocation> additionalSlotEmptyIcons, Properties properties) {
        super(appliesTo, ingredients, baseSlotDescription, additionsSlotDescription, baseSlotEmptyIcons, additionalSlotEmptyIcons, properties);
    }

    public static SmithingTemplateItem createBlazedTemplate(ResourceLocation name) {
        return new SmithingTemplateItem(
                BLAZED_APPLIES_TO,
                BLAZED_INGREDIENTS,
                BLAZED_BASE_SLOT_DESCRIPTION,
                BLAZED_ADDITIONS_SLOT_DESCRIPTION,
                createUpgradeIcons(),
                createNetheriteUpgradeMaterialList(),
                new Item.Properties().setId(ResourceKey.create(Registries.ITEM, name)).rarity(Rarity.RARE).stacksTo(16)
        );
    }

    public static SmithingTemplateItem createRingenderTemplate(ResourceLocation name) {
        return new SmithingTemplateItem(
                ENDER_APPLIES_TO,
                ENDER_INGREDIENTS,
                ENDER_BASE_SLOT_DESCRIPTION,
                ENDER_ADDITIONS_SLOT_DESCRIPTION,
                createUpgradeIcons(),
                createNetheriteUpgradeMaterialList(),
                new Item.Properties().setId(ResourceKey.create(Registries.ITEM, name)).rarity(Rarity.UNCOMMON).stacksTo(16)
        );
    }

    public static SmithingTemplateItem createPurpurTemplate(ResourceLocation name) {
        return new SmithingTemplateItem(
                PURPUR_APPLIES_TO,
                PURPUR_INGREDIENTS,
                PURPUR_BASE_SLOT_DESCRIPTION,
                PURPUR_ADDITIONS_SLOT_DESCRIPTION,
                createUpgradeIcons(),
                createNetheriteUpgradeMaterialList(),
                new Item.Properties().setId(ResourceKey.create(Registries.ITEM, name)).rarity(Rarity.EPIC).stacksTo(16)
        );
    }



    private static List<ResourceLocation> createUpgradeIcons() {
        return List.of(
                EMPTY_SLOT_HELMET,
                EMPTY_SLOT_SWORD,
                EMPTY_SLOT_CHESTPLATE,
                EMPTY_SLOT_PICKAXE,
                EMPTY_SLOT_LEGGINGS,
                EMPTY_SLOT_AXE,
                EMPTY_SLOT_BOOTS,
                EMPTY_SLOT_HOE,
                EMPTY_SLOT_SHOVEL
        );
    }

    private static List<ResourceLocation> createNetheriteUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }
}