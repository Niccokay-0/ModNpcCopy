package net.nic.npc.item.custom.equipment.armor;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
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

import java.util.stream.Stream;

public class EnderArmor extends MItem {

    public static final Component NOMIXEDARMOR = Component.translatable("npc.error.armor.mixed");

    public EnderArmor(ResourceLocation name, Properties properties) {
        super(name, properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerLevel level, Entity entity, @Nullable EquipmentSlot slot) {
        super.inventoryTick(stack, level, entity, slot);

        if (entity instanceof Player player) {
            ArmorSet armorSet = getArmorSet(player);
            switch (armorSet) {
                case RINGENDER -> {
                    player.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 500, 1, false, false));
                    player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 500, 1, false, false));

                }
                case PURPUR -> {
                    player.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 500, 1, false, false));
                }
                case MIXED -> {
                    player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 500, 1, false, false));
                    player.displayClientMessage(NOMIXEDARMOR, true);
                }
            }
        }
    }

    private enum ArmorSet {
        RINGENDER,
        PURPUR,
        MIXED,
        NONE
    }

    private ArmorSet getArmorSet(Player player) {
        Item ringenderHelmet = MItems.RINGENDER_HOOD.get();
        Item ringenderChest = MItems.RINGENDER_COAT.get();
        Item ringenderBoots = MItems.RINGENDER_CLOAK.get();

        Item purpurHelmet = MItems.PURPUR_HELMET.get();
        Item purpurChest = MItems.PURPUR_CHESTPLATE.get();
        Item purpurLegs = MItems.PURPUR_LEGGINGS.get();
        Item purpurBoots = MItems.PURPUR_BOOTS.get();

        ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

        boolean isRingender = head.is(ringenderHelmet) && chest.is(ringenderChest)
                && legs.isEmpty() && feet.is(ringenderBoots);

        boolean isPurpur = head.is(purpurHelmet) && chest.is(purpurChest)
                && legs.is(purpurLegs) && feet.is(purpurBoots);

        if (isRingender) return ArmorSet.RINGENDER;
        if (isPurpur) return ArmorSet.PURPUR;

        boolean isAnyArmor = Stream.of(head, chest, legs, feet).allMatch(itemStack -> itemStack.is(ItemTags.ARMOR_ENCHANTABLE));

        if (isAnyArmor) return ArmorSet.MIXED;

        return ArmorSet.NONE;
    }


}