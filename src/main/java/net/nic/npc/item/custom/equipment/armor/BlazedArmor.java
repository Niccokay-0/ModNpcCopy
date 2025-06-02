package net.nic.npc.item.custom.equipment.armor;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.nic.npc.item.MItems;
import net.nic.npc.item.custom.MItem;
import org.jetbrains.annotations.Nullable;

public class BlazedArmor extends MItem {



    public BlazedArmor(ResourceLocation name, Item.Properties properties) {

        super(name, properties);
    }


    @Override
    public boolean canBeHurtBy(ItemStack stack, DamageSource source) {
        source.getDirectEntity().igniteForSeconds(3);
        return super.canBeHurtBy(stack, source);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        if (!level.isClientSide && entity instanceof Player player) {
            if (isWearingFullSet(player)) {
                if (!player.hasEffect(MobEffects.FIRE_RESISTANCE)) {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1000, 0, false, false));
                }
            }
        }
        super.inventoryTick(stack, level, entity, slot);
    }

    private boolean isWearingFullSet(Player player) {
        return player.getItemBySlot(EquipmentSlot.HEAD).getItem() == MItems.BLAZED_HELMET.get()
                && player.getItemBySlot(EquipmentSlot.CHEST).getItem() == MItems.BLAZED_CHESTPLATE.get()
                && player.getItemBySlot(EquipmentSlot.LEGS).getItem() == MItems.BLAZED_LEGGINGS.get()
                && player.getItemBySlot(EquipmentSlot.FEET).getItem() == MItems.BLAZED_BOOTS.get();
    }
}
