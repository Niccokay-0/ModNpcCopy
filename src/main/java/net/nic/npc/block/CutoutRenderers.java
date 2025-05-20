package net.nic.npc.block;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public class CutoutRenderers {


    public static void render(FMLClientSetupEvent event) {
        event.enqueueWork( ()->
                acceptCutout(MBlocks.BLUEBERRY_BUSH.get())
        );
        event.enqueueWork( ()->
                acceptCutout(MBlocks.STRAWBERRY_CROP.get())
        );
    }

    private static void acceptCutout(Block block) {
        ItemBlockRenderTypes.setRenderLayer(block, RenderType.CUTOUT);
    }

}
