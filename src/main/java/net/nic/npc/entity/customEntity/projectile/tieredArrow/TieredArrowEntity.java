package net.nic.npc.entity.customEntity.projectile.tieredArrow;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;

public class TieredArrowEntity extends AbstractArrow {

    private float speedMultiplier = 1.0f;
    private ToolMaterial material;

    public void setMaterial(ToolMaterial material) {
        this.material = material;
    }

    public ToolMaterial getMaterial() {
        return this.material;
    }
    public TieredArrowEntity(EntityType<? extends TieredArrowEntity> type, Level level) {
        super(type, level);
    }

    public TieredArrowEntity(EntityType<? extends TieredArrowEntity> type, Level level, LivingEntity shooter, float speedMultiplier) {
        super(type, level);
        this.speedMultiplier = speedMultiplier;
    }

    @Override
    public void tick() {
        super.tick();
        Vec3 motion = this.getDeltaMovement();
        this.setDeltaMovement(motion.scale(this.speedMultiplier));
    }

    @Override
    protected ItemStack getPickupItem() {
        // Return the arrow item this corresponds to
        return ItemStack.EMPTY; // Placeholder: replace with your custom item if needed
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return null;
    }

    public float getSpeedMultiplier() {
        return speedMultiplier;
    }

    public void setSpeedMultiplier(float multiplier) {
        this.speedMultiplier = multiplier;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);

        if (!(result.getEntity() instanceof LivingEntity target)) return;

        // Apply effects based on material
        if (material == ToolMaterial.WOOD) {
            this.level().explode(null, this.getX(), this.getY(), this.getZ(), 1.5f, Level.ExplosionInteraction.NONE);
        }
        else if (material == ToolMaterial.STONE) {
            target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 60, 1)); // 3 seconds slowness
        }

        else if (material == ToolMaterial.IRON) {
            target.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 120, 1)); // 3 seconds slowness
        }

        else if (material == ToolMaterial.GOLD) {
            target.setRemainingFireTicks(20 * 4); // 4 seconds fire
        }
        else if (material == ToolMaterial.DIAMOND) {
            target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0)); // 5 seconds glowing
        }

    }

}
