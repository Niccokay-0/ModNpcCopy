package net.nic.npc.item.custom.equipment.tools.ender;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.windcharge.WindCharge;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.WindChargeItem;
import net.minecraft.world.level.Level;

public class RingEnderCharge extends WindChargeItem {


    public RingEnderCharge(ResourceLocation name, Item.Properties properties) {
        super(properties.setId(ResourceKey.create(Registries.ITEM, name)));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (level instanceof ServerLevel serverlevel) {
            Projectile.spawnProjectileFromRotation(
                    (serverLevel, entity, stack) -> new WindCharge(
                            player, level, player.position().x(), player.getEyePosition().y(), player.position().z()
                    ),
                    serverlevel,
                    itemstack,
                    player,
                    0.0F,
                    PROJECTILE_SHOOT_POWER,
                    1.0F
            );
        }

        level.playSound(
                null,
                player.getX(),
                player.getY(),
                player.getZ(),
                SoundEvents.ENDER_PEARL_THROW,
                SoundSource.NEUTRAL,
                0.5F,
                0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        player.awardStat(Stats.ITEM_USED.get(this));
        itemstack.consume(1, player);
        return InteractionResult.SUCCESS;
    }

}
