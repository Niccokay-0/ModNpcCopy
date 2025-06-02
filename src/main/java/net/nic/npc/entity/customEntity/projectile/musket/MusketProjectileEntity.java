package net.nic.npc.entity.customEntity.projectile.musket;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.nic.npc.item.MItems;
import net.nic.npc.item.materials.CustomMaterials;

public class MusketProjectileEntity extends AbstractArrow {

    private float speedMultiplier = 1.0f;
    private ToolMaterial material;

    public void setMaterial(ToolMaterial material) {
        this.material = material;
    }

    public ToolMaterial getMaterial() {
        return this.material;
    }

    public MusketProjectileEntity(EntityType<? extends MusketProjectileEntity> type, Level level) {
        super(type, level);
    }

    public MusketProjectileEntity(EntityType<? extends MusketProjectileEntity> type, Level level, LivingEntity shooter, float speedMultiplier) {
        super(type, level);
        this.speedMultiplier = speedMultiplier;
    }

    @Override
    protected void onHitBlock(BlockHitResult hit) {
        super.onHitBlock(hit);
        this.discard();

    }

    @Override
    public void tick() {
        super.tick();
        Vec3 motion = this.getDeltaMovement();
        this.setDeltaMovement(motion.scale(this.speedMultiplier));
    }

    @Override
    protected ItemStack getPickupItem() {
        if (material == ToolMaterial.STONE) return new ItemStack(MItems.STONE_PROJECTILE.get());
        if (material == ToolMaterial.IRON) return new ItemStack(MItems.IRON_PROJECTILE.get());
        if (material == CustomMaterials.LEAD) return new ItemStack(MItems.LEAD_PROJECTILE.get());
        if (material == CustomMaterials.TUNGSTEN) return new ItemStack(MItems.TUNGSTEN_PROJECTILE.get());
        if (material == CustomMaterials.PHOSPHORUS) return new ItemStack(MItems.PHOSPHORUS_PROJECTILE.get());
        if (material == CustomMaterials.ENDSTONE) return new ItemStack(MItems.ENDSTONE_PROJECTILE.get());

        return ItemStack.EMPTY; // Fallback if material doesn't match
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
        if (material == CustomMaterials.PHOSPHORUS) {
            target.setRemainingFireTicks(20 * 4); // 4 seconds fire

        }
    }
}
