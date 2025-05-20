package net.nic.npc.entity.customEntity.npc;

import net.minecraft.client.model.HumanoidArmorModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.resources.ResourceLocation;
import net.nic.npc.NpcMain;

public class NPCRenderer extends MobRenderer<NPC, PlayerRenderState, PlayerModel> {

    public NPCRenderer(EntityRendererProvider.Context context) {
        super(context, new PlayerModel(context.bakeLayer(ModelLayers.PLAYER_SLIM), true), 0.5f);
        this.addLayer(new HumanoidArmorLayer<>(
                this,
                new HumanoidArmorModel<>(context.bakeLayer(ModelLayers.PLAYER_SLIM_INNER_ARMOR)),
                new HumanoidArmorModel<>(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)),
                context.getEquipmentRenderer()
        ));
    }

    @Override
    public PlayerRenderState createRenderState() {
        return new PlayerRenderState();
    }


    @Override
    public ResourceLocation getTextureLocation(PlayerRenderState renderState) {
        return ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "textures/entity/npc.png");
    }
}
