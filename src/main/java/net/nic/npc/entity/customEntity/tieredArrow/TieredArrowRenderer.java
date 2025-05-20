package net.nic.npc.entity.customEntity.tieredArrow;

import net.minecraft.client.model.ArrowModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ToolMaterial;
import net.nic.npc.NpcMain;

public class TieredArrowRenderer extends ArrowRenderer<TieredArrowEntity, TieredArrowRenderState> {

    private final ArrowModel model;
    ToolMaterial material;
    TieredArrowEntity arrow;
    ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "textures/entity/projectiles/wooden_arrow.png");


    public TieredArrowRenderer(EntityRendererProvider.Context entity) {
        super(entity);
        this.model = new ArrowModel(entity.bakeLayer(ModelLayers.ARROW));

    }

    @Override
    public TieredArrowRenderState createRenderState() {
        return new TieredArrowRenderState();

    }

    @Override
    public void extractRenderState(TieredArrowEntity entity, TieredArrowRenderState entityState, float f) {
        super.extractRenderState(entity, entityState, f);
        this.arrow = entity;
        ToolMaterial material = entity.getMaterial();
        entityState.setMaterial(material);
    }

    @Override
    protected ResourceLocation getTextureLocation(TieredArrowRenderState renderState) {

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
        return texture;

    }


}
