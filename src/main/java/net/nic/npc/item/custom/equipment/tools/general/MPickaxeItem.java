package net.nic.npc.item.custom.equipment.tools.general;

import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
import net.nic.npc.item.MDataComponents;

public class MPickaxeItem extends MTool {

    public ToolMaterial toolMat;

    public MPickaxeItem(ResourceLocation name, Properties properties, ToolMaterial material, float attackDamage, float attackSpeed) {
        super(name, properties.pickaxe(material,attackDamage,attackSpeed));
        toolMat = material;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        Tool tool = stack.get(DataComponents.TOOL);
        if (tool != null) {
            float miningSpeed = tool.getMiningSpeed(state);
            if (stack.has(MDataComponents.DIG_MINING_UPGRADE)) {
                miningSpeed += stack.get(MDataComponents.DIG_MINING_UPGRADE);
            }
            return miningSpeed;
        } else {
            return 1.0f;
        }
    }




    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (canAddMiningSpeed(context.getItemInHand())){
            addMiningSpeed(context.getItemInHand(), new ItemStack(Items.QUARTZ, 64));
        }
        else if (!canAddMiningSpeed(context.getItemInHand())) clearMiningSpeed(context.getItemInHand());
        return super.useOn(context);
    }

    /**
     * Player can't add mining speed to an item with mining speed in it, he will have to clear it first
     */

    /**
     * 🔄 Quick Reference for Data Component Access:
     * .get(DataComponentType<T>): Retrieve the component (or null if not present)
     *
     * .set(DataComponentType<T>, value): Set the component.
     *
     * .has(DataComponentType<T>): Check if the component is present.
     *
     * .remove(DataComponentType<T>): Remove the component.
     *
     */

}
