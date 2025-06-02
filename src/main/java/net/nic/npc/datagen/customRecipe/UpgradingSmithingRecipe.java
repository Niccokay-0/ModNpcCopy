package net.nic.npc.datagen.customRecipe;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SmithingRecipeInput;
import net.minecraft.world.item.crafting.SmithingTransformRecipe;
import net.minecraft.world.item.crafting.TransmuteResult;
import net.nic.npc.item.MDataComponents;

import java.util.Optional;

public class UpgradingSmithingRecipe extends SmithingTransformRecipe {


    public UpgradingSmithingRecipe(Optional<Ingredient> template, Ingredient base, Optional<Ingredient> addition, TransmuteResult result) {
        super(template, base, addition, result);
    }

    @Override
    public ItemStack assemble(SmithingRecipeInput input, HolderLookup.Provider provider) {
        ItemStack resultStack = super.assemble(input, provider);
        // Add your data component here - example: add a custom NBT tag
        resultStack.set(MDataComponents.DIG_MINING_UPGRADE,1000.0f);
        // You can add more complex logic here for your data component

        return resultStack;
    }

}
