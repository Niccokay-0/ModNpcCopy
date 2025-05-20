package net.nic.npc.item.foods;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import org.jetbrains.annotations.NotNull;

public class CustomFoodProperties {

    public static final FoodProperties BLUEBERRY = setFoodProperties(2,0.3f);
    public static final FoodProperties STRAWBERRY = setFoodProperties(4,0.6f);

    public static final FoodProperties PINEAPPLE = setFoodProperties(9,0.8f); //todo CONSUMABLE

    public static final FoodProperties MANGO = setFoodProperties(6,0.8f);

    public static final FoodProperties KIWI = setFoodProperties(3,0.3f);

    public static final FoodProperties PEACH = setFoodProperties(5,0.6f);
    public static final FoodProperties BANANA = setFoodProperties(4,0.5f);
    public static final FoodProperties LEMON = setFoodProperties(5,0.4f);

    public static final FoodProperties COCONUT_SHARDS = setFoodProperties(8, 0.7f);

    public static final FoodProperties AVOCADO = setFoodProperties(4,0.4f);


    /**
     * {@link Foods}
     */

    private static @NotNull FoodProperties setFoodProperties(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturation).build();
    }
}
