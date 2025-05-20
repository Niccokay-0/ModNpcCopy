package net.nic.npc.entity.customEntity.tieredArrow;

import net.minecraft.client.renderer.entity.state.ArrowRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ToolMaterial;
import net.nic.npc.NpcMain;

public class TieredArrowRenderState extends ArrowRenderState {
    public ToolMaterial material;
    public ResourceLocation texture;

    public void setMaterial(ToolMaterial material) {
        this.material = material;
    }

    public void getTexture(){
        if (material == ToolMaterial.WOOD) {
            texture = ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "textures/entity/projectiles/wooden_arrow.png");
        } else if (material == ToolMaterial.STONE) {
            texture = ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "textures/entity/projectiles/stone_arrow.png");
        } else if (material == ToolMaterial.IRON) {
            texture = ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "textures/entity/projectiles/iron_arrow.png");
        } else if (material == ToolMaterial.GOLD) {
            texture = ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "textures/entity/projectiles/golden_arrow.png");
        } else if (material == ToolMaterial.DIAMOND) {
            texture = ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "textures/entity/projectiles/diamond_arrow.png");
        } else if (material == ToolMaterial.NETHERITE) {
            texture = ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "textures/entity/projectiles/netherite_arrow.png");

        }
    }
}