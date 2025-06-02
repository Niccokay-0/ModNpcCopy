package net.nic.npc.datagen.customRecipe;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;
import net.minecraft.world.item.crafting.TransmuteResult;
import net.nic.npc.item.MDataComponents;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class UpgradingSmithingRecipeBuilder {

    private final Ingredient template;
    private final Ingredient base;
    private final Ingredient addition;
    private final RecipeCategory category;
    private final Item result;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    public UpgradingSmithingRecipeBuilder(Ingredient template, Ingredient base, Ingredient addition, RecipeCategory category, Item result) {
        this.template = template;
        this.base = base;
        this.addition = addition;
        this.category = category;
        this.result = result;
    }
    public static UpgradingSmithingRecipeBuilder upgradingSmithing(Ingredient template, Ingredient base, Ingredient addition, RecipeCategory category, Item result) {
        result.getDefaultInstance().set(MDataComponents.DIG_MINING_UPGRADE, 1000.0f);
        return new UpgradingSmithingRecipeBuilder(template, base, addition, category, result);
    }

    public UpgradingSmithingRecipeBuilder unlocks(String key, Criterion<?> criterion) {
        this.criteria.put(key, criterion);
        return this;
    }


    public void save(RecipeOutput recipeOutput, String recipeId) {
        this.save(recipeOutput, ResourceKey.create(Registries.RECIPE, ResourceLocation.parse(recipeId)));
    }

    public void save(RecipeOutput output, ResourceKey<Recipe<?>> resourceKey) {
        this.ensureValid(resourceKey);
        Advancement.Builder advancement$builder = output.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey))
                .rewards(AdvancementRewards.Builder.recipe(resourceKey))
                .requirements(AdvancementRequirements.Strategy.OR);
        this.criteria.forEach(advancement$builder::addCriterion);
        SmithingTransformRecipe smithingtransformrecipe = new SmithingTransformRecipe(
                Optional.of(this.template), this.base, Optional.of(this.addition), new TransmuteResult(this.result)
        );
        output.accept(
                resourceKey, smithingtransformrecipe, advancement$builder.build(resourceKey.location().withPrefix("recipes/" + this.category.getFolderName() + "/"))
        );
    }

    private void ensureValid(ResourceKey<Recipe<?>> recipeKey) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeKey.location());
        }
    }
}
