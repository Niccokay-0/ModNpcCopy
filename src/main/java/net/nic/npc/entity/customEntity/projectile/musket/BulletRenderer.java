package net.nic.npc.entity.customEntity.projectile.musket;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.nic.npc.NpcMain;

public class BulletRenderer extends ArrowRenderer<MusketProjectileEntity, BulletRenderState> {

    private final BulletModel<BulletRenderState> model;
    public BulletRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new BulletModel<>(context.bakeLayer(BulletModel.LAYER_LOCATION));
    }
    @Override
    protected ResourceLocation getTextureLocation(BulletRenderState state) {
        return ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "textures/entity/projectiles/bullet.png");

    }
    @Override
    public void extractRenderState(MusketProjectileEntity entity, BulletRenderState state, float partialTicks) {
        state.material = entity.getMaterial(); // Pass ToolMaterial to state
    }

    @Override
    public void render(BulletRenderState state, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        poseStack.mulPose(Axis.YP.rotationDegrees(state.yRot - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(state.xRot));

        VertexConsumer consumer = buffer.getBuffer(RenderType.entityCutout(getTextureLocation(state)));
        model.setupAnim(state);
        model.renderToBuffer(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY);

        poseStack.popPose();
    }

    @Override
    public BulletRenderState createRenderState() {
        return new BulletRenderState();
    }
}
