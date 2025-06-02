package net.nic.npc.item.custom.equipment.projectiles;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.nic.npc.entity.MEntities;
import net.nic.npc.entity.customEntity.projectile.musket.MusketProjectileEntity;
import net.nic.npc.item.materials.CustomMaterials;
import org.jetbrains.annotations.Nullable;

public class MusketProjectileItem extends ArrowItem {


    public ToolMaterial material;

    public MusketProjectileItem(ResourceLocation name, Item.Properties properties, ToolMaterial material) {
        super(properties.setId(ResourceKey.create(Registries.ITEM, name)));
        this.material = material;
    }




    @Override
    public AbstractArrow createArrow(Level level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon) {
        float speedMultiplier = getSpeedMultiplierFromMaterial();

        MusketProjectileEntity bullet = new MusketProjectileEntity(MEntities.BULLET.get(), level);
        bullet.setOwner(shooter);
        bullet.setPos(shooter.getX(), shooter.getEyeY() - 0.1, shooter.getZ());
        bullet.setSpeedMultiplier(speedMultiplier);
        bullet.setMaterial(this.material);

        // Set velocity directly
        Vec3 lookVec = shooter.getLookAngle();
        Vec3 velocity = lookVec.scale(3.0f * speedMultiplier);
        bullet.setDeltaMovement(velocity);
        bullet.setYRot((float)(Math.toDegrees(Math.atan2(velocity.z, velocity.x)) - 90.0));
        bullet.setXRot((float)(Math.toDegrees(-Math.atan2(velocity.y, velocity.horizontalDistance()))));
        bullet.yRotO = bullet.getYRot();
        bullet.xRotO = bullet.getXRot();

        bullet.setBaseDamage(2 + (this.material.attackDamageBonus() / 2));

        return bullet;
    }

    private float getSpeedMultiplierFromMaterial() {
        if (material == CustomMaterials.ENDSTONE) return 0.8f;
        if (material == ToolMaterial.STONE) return 0.6f;
        if (material == ToolMaterial.IRON) return 1.0f;
        if (material == CustomMaterials.LEAD) return 1.2f;
        if (material == CustomMaterials.PHOSPHORUS) return 1.3f;
        if (material == CustomMaterials.TUNGSTEN) return 1.5f;
        return 1.0f;
    }

    private ToolMaterial getMaterial() {
        return material;
    }

    private boolean shouldFoil(ToolMaterial material) {
        if (material == CustomMaterials.PHOSPHORUS) return true;
        return false;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return shouldFoil(getMaterial());
    }

}
