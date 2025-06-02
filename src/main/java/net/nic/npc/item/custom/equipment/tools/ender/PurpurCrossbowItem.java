package net.nic.npc.item.custom.equipment.tools.ender;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.nic.npc.item.MDataComponents;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PurpurCrossbowItem extends CrossbowItem {

    private boolean midLoadSoundPlayed = false;
    private boolean startSoundPlayed = false;

    private static final ChargingSounds DEFAULT_SOUNDS = new ChargingSounds(
            Optional.of(SoundEvents.CROSSBOW_LOADING_START),
            Optional.of(SoundEvents.CROSSBOW_LOADING_MIDDLE),
            Optional.of(SoundEvents.CROSSBOW_LOADING_END)
    );

    public PurpurCrossbowItem(ResourceLocation name, Properties properties) {
        super(properties.setId(ResourceKey.create(Registries.ITEM, name)));
    }

    @Override
    public void performShooting(Level level, LivingEntity shooter, InteractionHand hand, ItemStack weapon, float velocity, float inaccuracy, @org.jetbrains.annotations.Nullable LivingEntity target) {
        if (level instanceof ServerLevel serverLevel) {
            if (shooter instanceof Player player && net.neoforged.neoforge.event.EventHooks.onArrowLoose(weapon, shooter.level(), player, 1, true) < 0) return;

            int shots = weapon.getOrDefault(MDataComponents.SHOTS, 0);
            if (shots > 0) {
                ChargedProjectiles chargedProjectiles = weapon.get(DataComponents.CHARGED_PROJECTILES);
                if (chargedProjectiles != null && !chargedProjectiles.isEmpty()) {
                    this.shoot(serverLevel, shooter, hand, weapon, chargedProjectiles.getItems(), velocity, inaccuracy, shooter instanceof Player, target);

                    if (shooter instanceof ServerPlayer serverPlayer) {
                        CriteriaTriggers.SHOT_CROSSBOW.trigger(serverPlayer, weapon);
                        serverPlayer.awardStat(Stats.ITEM_USED.get(weapon.getItem()));
                    }

                    // Add cooldown
                    if (shooter instanceof Player player) {
                        player.getCooldowns().addCooldown(weapon, 20); // 20 ticks = 1 second
                    }

                    // Decrease shots
                    weapon.set(MDataComponents.SHOTS, shots - 1);
                }
            } else {
                super.performShooting(level, shooter, hand, weapon, velocity, inaccuracy, target);
            }
        }
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        return super.releaseUsing(stack, level, entity, timeLeft);
    }

    private CrossbowItem.ChargingSounds getChargingSounds(ItemStack stack) {
        return EnchantmentHelper.pickHighestLevel(stack, EnchantmentEffectComponents.CROSSBOW_CHARGING_SOUNDS)
                .orElse(DEFAULT_SOUNDS);
    }


    @Override
    public int getUseDuration(ItemStack p_40938_, LivingEntity p_344898_) {
        return super.getUseDuration(p_40938_, p_344898_);
    }

    public static int getChargeDuration(ItemStack stack, LivingEntity shooter) {
        float f = EnchantmentHelper.modifyCrossbowChargingTime(stack, shooter, 1.25F);
        return Mth.floor(f * 20.0F);
    }

    @Override
    public void onUseTick(Level level, LivingEntity entity, ItemStack stack, int count) {
        if (!level.isClientSide) {
            ChargingSounds sounds = this.getChargingSounds(stack);
            float progress = (float)(stack.getUseDuration(entity) - count) / this.getChargeDuration(stack, entity);

            if (progress < 0.2F) {
                this.startSoundPlayed = false;
                this.midLoadSoundPlayed = false;
            }

            if (progress >= 0.2F && !this.startSoundPlayed) {
                this.startSoundPlayed = true;
                sounds.start().ifPresent(
                        s -> level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), s.value(), SoundSource.PLAYERS, 0.5F, 1.0F)
                );
            }

            if (progress >= 0.5F && !this.midLoadSoundPlayed) {
                this.midLoadSoundPlayed = true;
                sounds.mid().ifPresent(
                        s -> level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), s.value(), SoundSource.PLAYERS, 0.5F, 1.0F)
                );
            }

            if (progress >= 1.0F && !isCharged(stack) && tryLoadProjectiles(entity, stack)) {
                sounds.end().ifPresent(
                        s -> level.playSound(
                                null, entity.getX(), entity.getY(), entity.getZ(), s.value(), entity.getSoundSource(),
                                1.0F, 1.0F / (level.getRandom().nextFloat() * 0.5F + 1.0F) + 0.2F
                        )
                );
            }
        }
    }

    public boolean tryLoadProjectiles(LivingEntity shooter, ItemStack crossbowStack) {
        ItemStack ammo = shooter.getProjectile(crossbowStack);
        if (ammo.isEmpty()) return false;

        List<ItemStack> projectiles = drawProjectiles(shooter, crossbowStack, ammo);
        if (projectiles.isEmpty()) return false;

        crossbowStack.set(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.of(projectiles));
        crossbowStack.set(MDataComponents.SHOTS, 2);
        return true;
    }

    private List<ItemStack> drawProjectiles(LivingEntity shooter, ItemStack crossbowStack, ItemStack ammo) {
        List<ItemStack> projectiles = new ArrayList<>();
        boolean multishot = isCharged(crossbowStack);
        int count = multishot ? 3 : 1;

        for (int i = 0; i < count; i++) {
            ItemStack singleAmmo = ammo.copy();
            singleAmmo.setCount(1);
            projectiles.add(singleAmmo);
        }

        return projectiles;
    }

}
