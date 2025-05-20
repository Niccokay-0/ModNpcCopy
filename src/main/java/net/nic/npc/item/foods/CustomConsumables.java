package net.nic.npc.item.foods;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

public class CustomConsumables extends Consumables {

    public static final Consumable PINEAPPLE = defaultFood().consumeSeconds(2.0f).onConsume(
            new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.INSTANT_DAMAGE,1,1),
                            new MobEffectInstance(MobEffects.RESISTANCE,160,3),
                            new MobEffectInstance(MobEffects.HASTE,100,2),
                            new MobEffectInstance(MobEffects.SPEED,100,3)
                    )
            )
    ).build();

    public static final Consumable STRAWBERRY = defaultFood().consumeSeconds(1.4f).onConsume(new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.HEALTH_BOOST,120,2),
                            new MobEffectInstance(MobEffects.INSTANT_HEALTH,1,2)
                    )
            )
    ).build();

    public static final Consumable LEMON = defaultFood().consumeSeconds(1.8f).onConsume(new ApplyStatusEffectsConsumeEffect(
                    List.of(
                            new MobEffectInstance(MobEffects.SPEED,100,1),
                            new MobEffectInstance(MobEffects.HASTE,160,2)
                    )
            )
    ).build();

    public static final Consumable FASTEDIBLE = defaultFood().consumeSeconds(0.6f).build();
    public static final Consumable COCONUT_SHARDS = defaultFood().consumeSeconds(1.8f).build();
}
