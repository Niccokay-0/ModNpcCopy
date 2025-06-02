package net.nic.npc.item.custom.equipment.projectiles;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.nic.npc.entity.MEntities;
import net.nic.npc.entity.customEntity.projectile.tieredArrow.TieredArrowEntity;
import org.jetbrains.annotations.Nullable;

public class TieredArrowItem extends ArrowItem {
    private ToolMaterial material;

    public TieredArrowItem(ResourceLocation name, Properties properties, ToolMaterial material) {
        super(properties.setId(ResourceKey.create(Registries.ITEM, name)));
        this.material = material;

    }

    @Override
    public Projectile asProjectile(Level level, Position pos, ItemStack stack, Direction direction) {
        return super.asProjectile(level, pos, stack, direction);
    }
    @Override
    public AbstractArrow createArrow(Level level, ItemStack ammo, LivingEntity shooter, @Nullable ItemStack weapon) {
        float speedMultiplier = getSpeedMultiplierFromMaterial();

        TieredArrowEntity arrow = new TieredArrowEntity(MEntities.TIERED_ARROW.get(), level);
        arrow.setOwner(shooter);
        arrow.setPos(shooter.getX(), shooter.getEyeY() - 0.1, shooter.getZ());
        arrow.setSpeedMultiplier(speedMultiplier);
        arrow.setMaterial(this.material);



        // Set velocity directly
        Vec3 lookVec = shooter.getLookAngle();
        Vec3 velocity = lookVec.scale(3.0f * speedMultiplier);
        arrow.setDeltaMovement(velocity);
        arrow.setYRot((float)(Math.toDegrees(Math.atan2(velocity.z, velocity.x)) - 90.0));
        arrow.setXRot((float)(Math.toDegrees(-Math.atan2(velocity.y, velocity.horizontalDistance()))));
        arrow.yRotO = arrow.getYRot();
        arrow.xRotO = arrow.getXRot();

        arrow.setBaseDamage(2 + (this.material.attackDamageBonus() / 2));

        return arrow;
    }




    private float getSpeedMultiplierFromMaterial() {
        if (material == ToolMaterial.WOOD) return 0.8f;
        if (material == ToolMaterial.STONE) return 1.0f;
        if (material == ToolMaterial.IRON) return 1.2f;
        if (material == ToolMaterial.DIAMOND) return 1.4f;
        if (material == ToolMaterial.NETHERITE) return 1.6f;
        return 1.0f;
    }

    private ToolMaterial getMaterial() {
        return material;
    }

    private boolean shouldFoil(ToolMaterial material) {
        if (material == ToolMaterial.GOLD) return true;
        if (material == ToolMaterial.DIAMOND) return true;
        if (material == ToolMaterial.NETHERITE) return true;
        return false;
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return shouldFoil(getMaterial());
    }
}
