package net.nic.npc.item.custom.equipment.tools.ender;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.Holder;
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
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ChargedProjectiles;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.nic.npc.entity.MEntities;
import net.nic.npc.entity.customEntity.projectile.musket.MusketProjectileEntity;
import net.nic.npc.item.MDataComponents;
import net.nic.npc.item.MItems;
import net.nic.npc.item.custom.CustomItemTags;
import net.nic.npc.item.materials.CustomMaterials;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class AdvancedMusketItem extends CrossbowItem {


    private boolean midLoadSoundPlayed = false;
    private boolean startSoundPlayed = false;

    private static final ChargingSounds DEFAULT_SOUNDS = new ChargingSounds(
            Optional.of(Holder.direct(SoundEvents.FLINTANDSTEEL_USE)),
            Optional.of(Holder.direct(SoundEvents.FLINTANDSTEEL_USE)),
            Optional.of(Holder.direct(SoundEvents.ANVIL_PLACE))
    );

    public AdvancedMusketItem(ResourceLocation name, Properties properties) {
        super(properties.setId(ResourceKey.create(Registries.ITEM, name)));
    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles(ItemStack stack) {
        return stack1 -> stack1.is(CustomItemTags.MUSKET_PROJECTILES);
    }


    /**
     * @param level
     * @param shooter    <--> the shooter
     * @param musket     <--> the Musket Itself
     * @param ammo    <--> the ammo in the musket
     * @param isCrit
     * @return
     */
    @Override
    protected Projectile createProjectile(Level level, LivingEntity shooter, ItemStack musket, ItemStack ammo, boolean isCrit) {
        if (ammo.is(CustomItemTags.MUSKET_PROJECTILES)) {
            MusketProjectileEntity bullet = new MusketProjectileEntity(MEntities.BULLET.get(), level);
            bullet.setOwner(shooter);
            bullet.setPos(shooter.getX(), shooter.getEyeY() - 0.1F, shooter.getZ());
            bullet.setMaterial(resolveToolMaterial(ammo));
            bullet.setBaseDamage(5.0); // Adjust based on material if needed
            bullet.setCritArrow(isCrit);
            return bullet;
        }

        // fallback for firework rockets, if allowed
        if (ammo.is(Items.FIREWORK_ROCKET)) {
            return super.createProjectile(level, shooter, musket, ammo, isCrit);
        }

        return null; // or super.createProjectile(...)
    }

    private ToolMaterial resolveToolMaterial(ItemStack ammo) {
        if (ammo.is(MItems.STONE_PROJECTILE.get())) return ToolMaterial.STONE;
        if (ammo.is(MItems.IRON_PROJECTILE.get())) return ToolMaterial.IRON;
        if (ammo.is(MItems.LEAD_PROJECTILE.get())) return CustomMaterials.LEAD;
        if (ammo.is(MItems.TUNGSTEN_PROJECTILE.get())) return CustomMaterials.TUNGSTEN;
        if (ammo.is(MItems.PHOSPHORUS_PROJECTILE.get())) return CustomMaterials.PHOSPHORUS;
        if (ammo.is(MItems.ENDSTONE_PROJECTILE.get())) return CustomMaterials.ENDSTONE;
        return ToolMaterial.STONE; // fallback
    }
    @Override
    protected void shoot(ServerLevel level, LivingEntity shooter, InteractionHand hand, ItemStack weapon, List<ItemStack> projectileItems, float velocity, float inaccuracy, boolean isCrit, @javax.annotation.Nullable LivingEntity target) {
        float f = EnchantmentHelper.processProjectileSpread(level, weapon, shooter, 0.0F);
        float f1 = projectileItems.size() == 1 ? 0.0F : 2.0F * f / (projectileItems.size() - 1);
        float f2 = (projectileItems.size() - 1) % 2 * f1 / 2.0F;
        float f3 = 1.0F;

        for (int i = 0; i < projectileItems.size(); i++) {
            ItemStack itemstack = projectileItems.get(i);
            if (!itemstack.isEmpty()) {
                float f4 = f2 + f3 * ((i + 1) / 2) * f1;
                f3 = -f3;
                int j = i;
                Projectile.spawnProjectile(
                        this.createProjectile(level, shooter, weapon, itemstack, isCrit),
                        level,
                        itemstack,
                        projectile -> this.shootProjectile(shooter, projectile, j, velocity, inaccuracy, f4, target)
                );
                weapon.hurtAndBreak(this.getDurabilityUse(itemstack), shooter, LivingEntity.getSlotForHand(hand));
                if (weapon.isEmpty()) {
                    break;
                }
            }
        }
    }



    @Override
    public void performShooting(Level level, LivingEntity shooter, InteractionHand hand, ItemStack weapon, float velocity, float inaccuracy, @org.jetbrains.annotations.Nullable LivingEntity target) {
        if (level instanceof ServerLevel serverLevel) {
            if (shooter instanceof Player player && net.neoforged.neoforge.event.EventHooks.onArrowLoose(weapon, shooter.level(), player, 1, true) < 0) return;

            int shots = weapon.getOrDefault(MDataComponents.SHOTS, 0);
            if (shots > 0) {
                ChargedProjectiles chargedProjectiles = weapon.get(DataComponents.CHARGED_PROJECTILES);
                if (chargedProjectiles != null && !chargedProjectiles.isEmpty()) {
                    // Shoot only the first projectile in the list
                    List<ItemStack> projectiles = new ArrayList<>();
                    projectiles.add(chargedProjectiles.getItems().get(0));

                    this.shoot(serverLevel, shooter, hand, weapon, projectiles, velocity, inaccuracy, shooter instanceof Player, target);
                    playShootingSound(level, shooter);


                    // Remove the projectile just shot from charged projectiles
                    List<ItemStack> remaining = new ArrayList<>(chargedProjectiles.getItems());
                    remaining.remove(0);
                    weapon.set(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.of(remaining));

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
                // No shots left, clear charged projectiles
                ChargedProjectiles chargedProjectiles = weapon.get(DataComponents.CHARGED_PROJECTILES);
                if (chargedProjectiles != null && !chargedProjectiles.isEmpty()) {
                    // Shoot only the first projectile in the list
                    List<ItemStack> projectiles = new ArrayList<>();
                    projectiles.add(chargedProjectiles.getItems().get(0));

                    this.shoot(serverLevel, shooter, hand, weapon, projectiles, velocity, inaccuracy, shooter instanceof Player, target);
                    playShootingSound(level, shooter);

                    // Remove the projectile just shot from charged projectiles
                    List<ItemStack> remaining = new ArrayList<>(chargedProjectiles.getItems());
                    remaining.remove(0);
                    weapon.set(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.of(remaining));

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
                weapon.set(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.EMPTY);
            }
        }
    }

    private static void playShootingSound(Level level, LivingEntity shooter) {
        level.playSound(
                null,
                shooter.getX(), shooter.getY(), shooter.getZ(),
                SoundEvents.BREEZE_SHOOT,
                SoundSource.PLAYERS,
                1.5f,
                0.8f
        );
        level.playSound(
                null,
                shooter.getX(), shooter.getY(), shooter.getZ(),
                SoundEvents.GENERIC_EXPLODE,
                SoundSource.PLAYERS,
                0.8f,
                0.8f
        );
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        return super.releaseUsing(stack, level, entity, timeLeft);
    }

    private ChargingSounds getChargingSounds(ItemStack stack) {
        return EnchantmentHelper.pickHighestLevel(stack, EnchantmentEffectComponents.CROSSBOW_CHARGING_SOUNDS)
                .orElse(DEFAULT_SOUNDS);
    }


    @Override
    public int getUseDuration(ItemStack p_40938_, LivingEntity p_344898_) {
        return super.getUseDuration(p_40938_, p_344898_);
    }

    public static int getChargeDuration(ItemStack stack, LivingEntity shooter) {
        float f = EnchantmentHelper.modifyCrossbowChargingTime(stack, shooter, 0.5F);
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
        if (!(shooter instanceof Player player)) return false;

        int available = 0;
        int maxShots = 3;
        List<ItemStack> projectiles = new ArrayList<>();
        List<Integer> slotsToConsume = new ArrayList<>();

        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            ItemStack stack = player.getInventory().getItem(i);
            if (stack.is(CustomItemTags.MUSKET_PROJECTILES)) {
                available += stack.getCount();
                slotsToConsume.add(i);
                for (int j = 0; j < stack.getCount() && projectiles.size() < maxShots; j++) {
                    projectiles.add(stack.copyWithCount(1));
                }
                if (available >= maxShots) {
                    available = maxShots;
                    break;
                }
            }
        }

        if (projectiles.isEmpty()) return false;

        int toRemove = projectiles.size();
        for (int slot : slotsToConsume) {
            ItemStack stack = player.getInventory().getItem(slot);
            int remove = Math.min(stack.getCount(), toRemove);
            stack.shrink(remove);
            toRemove -= remove;
            if (toRemove <= 0) break;
        }

        crossbowStack.set(DataComponents.CHARGED_PROJECTILES, ChargedProjectiles.of(projectiles));
        crossbowStack.set(MDataComponents.SHOTS, available-1);
        return true;
    }
}
