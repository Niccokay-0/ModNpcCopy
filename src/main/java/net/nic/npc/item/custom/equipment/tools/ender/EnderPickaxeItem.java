package net.nic.npc.item.custom.equipment.tools.ender;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.nic.npc.block.custom.CustomBlockTags;
import net.nic.npc.item.custom.equipment.tools.general.MPickaxeItem;

public class EnderPickaxeItem extends MPickaxeItem {


    public EnderPickaxeItem(ResourceLocation name, Properties properties, ToolMaterial material, float attackDamage, float attackSpeed) {
        super(name, properties, material, attackDamage, attackSpeed);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity miningEntity) {
        if (state.is(CustomBlockTags.END_BLOCKS)) {
            stack.hurtAndBreak(-1,miningEntity,stack.getEquipmentSlot());
        }
        return super.mineBlock(stack, level, state, pos, miningEntity);


    }


}
