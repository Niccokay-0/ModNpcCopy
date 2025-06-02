package net.nic.npc.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.nic.npc.datagen.customRecipe.UpgradingSmithingRecipeBuilder;
import net.nic.npc.item.MItems;
import net.nic.npc.item.custom.CustomItemTags;

import java.util.concurrent.CompletableFuture;

public class MRecipeProvider extends RecipeProvider {

    // Construct the provider to run
    protected MRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
        super(provider, output);
    }

    @Override
    protected void buildRecipes() {
        createFoodRecipes();
        createBlazedEquipmentRecipes();
        createEnderedEquipmentRecipes();
        createPurpurEquipmentRecipes();
        createAlloysRecipes();

        UpgradingSmithingRecipeBuilder.upgradingSmithing(
                        Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                        Ingredient.of(MItems.PURPUR_PICKAXE
                        ),
                        Ingredient.of(Items.QUARTZ),
                        RecipeCategory.COMBAT,
                        MItems.PURPUR_PICKAXE.get()
                )
                .unlocks("has_diamond_sword", has(MItems.PURPUR_PICKAXE))
                .save(this.output,"netherite_pickaxe_upgrade");
    }

    private void createAlloysRecipes() {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(tag(CustomItemTags.RINGENDER_ITEMS).getValues()),
                        Ingredient.of(Items.NETHERITE_INGOT),
                        this.tag(CustomItemTags.RINGENDER_ITEMS),
                        RecipeCategory.MISC,
                        MItems.RINGENDER_NETHERITE_INGOT.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_ringender_material", this.has(CustomItemTags.RINGENDER_ITEMS))
                .save(this.output, "ringender_netherite_ingot_smithing");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MItems.BLAZING_NETHERITE_INGOT, 1)
                .pattern("XXX")
                .pattern("XZX")
                .pattern("XXX")
                .define('X', CustomItemTags.BLAZED_ITEMS)
                .define('Z', Items.NETHERITE_INGOT)
                .unlockedBy("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .unlockedBy("has_blazing_material", this.has(CustomItemTags.BLAZED_ITEMS))
                .save(this.output, "blazing_netherite_ingot_crafting");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, MItems.PURPURED_NETHERITE_INGOT, 1)
                .pattern("XXX")
                .pattern("XZX")
                .pattern("XXX")
                .define('X', CustomItemTags.PURPUR_ITEMS)
                .define('Z', Items.NETHERITE_INGOT)
                .unlockedBy("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .unlockedBy("has_purpur_material", this.has(CustomItemTags.PURPUR_ITEMS))
                .save(this.output, "purpured_netherite_ingot_crafting");
    }

    private void createFoodRecipes() {
        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.FOOD, MItems.KIWI_SEEDLING.get(), 1).requires(Items.STICK).requires(MItems.KIWI.get()).unlockedBy("has_stick", this.has(Items.STICK)).unlockedBy("has_kiwi", this.has(MItems.KIWI)).unlockedBy("has_kiwi_seedling", this.has(MItems.KIWI_SEEDLING)).save(this.output);
        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.FOOD, MItems.DRINKABLE_COCONUT.get(), 1).requires(Items.GLASS_BOTTLE).requires(MItems.COCONUT.get()).unlockedBy("has_coconut", this.has(MItems.COCONUT)).unlockedBy("has_bottle", this.has(Items.GLASS_BOTTLE)).save(this.output);
        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.FOOD, MItems.COCONUT_SHARDS.get(), 1).requires(Items.IRON_NUGGET).requires(MItems.COCONUT.get()).unlockedBy("has_coconut", this.has(MItems.COCONUT)).unlockedBy("has_nugger", this.has(Items.IRON_NUGGET)).save(this.output);
    }


    private void createPurpurEquipmentRecipes() {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.BLAZING_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_HELMET),
                        Ingredient.of(MItems.PURPURED_NETHERITE_INGOT),
                        RecipeCategory.COMBAT,
                        MItems.PURPUR_HELMET.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_purpur_material", this.has(CustomItemTags.PURPUR_ITEMS))
                .save(this.output, "purpur_helmet_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.PURPUR_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_CHESTPLATE),
                        Ingredient.of(MItems.PURPURED_NETHERITE_INGOT),
                        RecipeCategory.COMBAT,
                        MItems.PURPUR_CHESTPLATE.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_purpur_material", this.has(CustomItemTags.PURPUR_ITEMS))
                .save(this.output, "purpur_chestplate_smithing");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.PURPUR_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_LEGGINGS),
                        Ingredient.of(MItems.PURPURED_NETHERITE_INGOT),
                        RecipeCategory.COMBAT,
                        MItems.PURPUR_LEGGINGS.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_purpur_material", this.has(CustomItemTags.PURPUR_ITEMS))
                .save(this.output, "purpur_leggings_smithing");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.PURPUR_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_BOOTS),
                        Ingredient.of(MItems.PURPURED_NETHERITE_INGOT),
                        RecipeCategory.COMBAT,
                        MItems.PURPUR_BOOTS.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_purpur_material", this.has(CustomItemTags.PURPUR_ITEMS))
                .save(this.output, "purpur_boots_smithing");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.PURPUR_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_SWORD),
                        Ingredient.of(MItems.PURPURED_NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        MItems.PURPUR_SWORD.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_purpur_material", this.has(CustomItemTags.PURPUR_ITEMS))
                .save(this.output, "purpur_sword_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.PURPUR_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_PICKAXE),
                        Ingredient.of(MItems.PURPURED_NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        MItems.PURPUR_PICKAXE.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_purpur_material", this.has(CustomItemTags.PURPUR_ITEMS))
                .save(this.output, "purpur_pickaxe_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.PURPUR_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_AXE),
                        Ingredient.of(MItems.PURPURED_NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        MItems.PURPUR_AXE.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_purpur_material", this.has(CustomItemTags.PURPUR_ITEMS))
                .save(this.output, "purpur_axe_smithing");

    }


    private void createEnderedEquipmentRecipes() {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.RINGENDER_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_HELMET),
                        Ingredient.of(MItems.RINGENDER_NETHERITE_INGOT),
                        RecipeCategory.COMBAT,
                        MItems.RINGENDER_HOOD.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_ringender_material", this.has(CustomItemTags.RINGENDER_ITEMS))
                .save(this.output, "ringender_helmet_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.RINGENDER_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_CHESTPLATE),
                        Ingredient.of(MItems.RINGENDER_NETHERITE_INGOT),
                        RecipeCategory.COMBAT,
                        MItems.RINGENDER_COAT.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_ringender_material", this.has(CustomItemTags.RINGENDER_ITEMS))
                .save(this.output, "ringender_chestplate_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.RINGENDER_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_BOOTS),
                        Ingredient.of(MItems.RINGENDER_NETHERITE_INGOT),
                        RecipeCategory.COMBAT,
                        MItems.RINGENDER_CLOAK.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_ringender_material", this.has(CustomItemTags.RINGENDER_ITEMS))
                .save(this.output, "ringender_boots_smithing");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.RINGENDER_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_SWORD),
                        Ingredient.of(MItems.RINGENDER_NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        MItems.RINGENDER_SWORD.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_ringender_material", this.has(CustomItemTags.RINGENDER_ITEMS))
                .save(this.output, "ringender_sword_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.RINGENDER_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_PICKAXE),
                        Ingredient.of(MItems.RINGENDER_NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        MItems.RINGENDER_PICKAXE.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_ringender_material", this.has(CustomItemTags.RINGENDER_ITEMS))
                .save(this.output, "ringender_pickaxe_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.RINGENDER_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_AXE),
                        Ingredient.of(MItems.RINGENDER_NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        MItems.RINGENDER_AXE.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_ringender_material", this.has(CustomItemTags.RINGENDER_ITEMS))
                .save(this.output, "ringender_axe_smithing");

    }


    private void createBlazedEquipmentRecipes() {
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.BLAZING_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_HELMET),
                        Ingredient.of(MItems.BLAZING_NETHERITE_INGOT),
                        RecipeCategory.COMBAT,
                        MItems.BLAZED_HELMET.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_blazed_material", this.has(CustomItemTags.BLAZED_ITEMS))
                .save(this.output, "blazed_helmet_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.BLAZING_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_CHESTPLATE),
                        Ingredient.of(MItems.BLAZING_NETHERITE_INGOT),
                        RecipeCategory.COMBAT,
                        MItems.BLAZED_CHESTPLATE.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_blazed_material", this.has(CustomItemTags.BLAZED_ITEMS))
                .save(this.output, "blazed_chestplate_smithing");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.BLAZING_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_LEGGINGS),
                        Ingredient.of(MItems.BLAZING_NETHERITE_INGOT),
                        RecipeCategory.COMBAT,
                        MItems.BLAZED_LEGGINGS.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_blazed_material", this.has(CustomItemTags.BLAZED_ITEMS))
                .save(this.output, "blazed_leggings_smithing");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.BLAZING_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_BOOTS),
                        Ingredient.of(MItems.BLAZING_NETHERITE_INGOT),
                        RecipeCategory.COMBAT,
                        MItems.BLAZED_BOOTS.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_blazed_material", this.has(CustomItemTags.BLAZED_ITEMS))
                .save(this.output, "blazed_boots_smithing");


        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.BLAZING_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_SWORD),
                        Ingredient.of(MItems.BLAZING_NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        MItems.BLAZED_SWORD.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_blazed_material", this.has(CustomItemTags.BLAZED_ITEMS))
                .save(this.output, "blazed_sword_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.BLAZING_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_PICKAXE),
                        Ingredient.of(MItems.BLAZING_NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        MItems.BLAZED_PICKAXE.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_blazed_material", this.has(CustomItemTags.BLAZED_ITEMS))
                .save(this.output, "blazed_pickaxe_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.BLAZING_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_AXE),
                        Ingredient.of(MItems.BLAZING_NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        MItems.BLAZED_AXE.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_blazed_material", this.has(CustomItemTags.BLAZED_ITEMS))
                .save(this.output, "blazed_axe_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.BLAZING_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_HOE),
                        Ingredient.of(MItems.BLAZING_NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        MItems.BLAZED_HOE.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_blazed_material", this.has(CustomItemTags.BLAZED_ITEMS))
                .save(this.output, "blazed_hoe_smithing");

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(MItems.BLAZING_SMITHING_UPGRADE),
                        Ingredient.of(Items.NETHERITE_SHOVEL),
                        Ingredient.of(MItems.BLAZING_NETHERITE_INGOT),
                        RecipeCategory.TOOLS,
                        MItems.BLAZED_SHOVEL.get()

                )
                .unlocks("has_netherite_ingot", this.has(ItemTags.NETHERITE_TOOL_MATERIALS))
                .unlocks("has_blazed_material", this.has(CustomItemTags.BLAZED_ITEMS))
                .save(this.output, "blazed_shovel_smithing");
    }



    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }
        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
            return new MRecipeProvider(provider, output);
        }
        @Override
        public String getName() {
            return "";
        }
    }
}