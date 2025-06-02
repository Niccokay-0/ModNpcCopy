package net.nic.npc.entity.customEntity.projectile.musket;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.nic.npc.NpcMain;

public class BulletModel<T extends BulletRenderState> extends EntityModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "bullet"), "main");

    private final ModelPart bullet;

    public BulletModel(ModelPart root) {
        super(root);
        this.bullet = root.getChild("bullet");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition mesh = new MeshDefinition();
        PartDefinition root = mesh.getRoot();

        root.addOrReplaceChild("bullet",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-1F, -1F, -1F, 2, 2, 2),
                PartPose.ZERO
        );

        return LayerDefinition.create(mesh, 16, 16);
    }

}
