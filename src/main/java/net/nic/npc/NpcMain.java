package net.nic.npc;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.nic.npc.block.MBlocks;
import net.nic.npc.block.MEntityBlocks;
import net.nic.npc.creativeTabs.MCreativeTabs;
import net.nic.npc.entity.MEntities;
import net.nic.npc.entity.MEntityAttributes;
import net.nic.npc.entity.customEntity.npc.NPCRenderer;
import net.nic.npc.entity.customEntity.projectile.musket.BulletModel;
import net.nic.npc.entity.customEntity.projectile.musket.BulletRenderer;
import net.nic.npc.entity.customEntity.projectile.tieredArrow.TieredArrowRenderer;
import net.nic.npc.gui.MMenus;
import net.nic.npc.gui.NPCInterface.ScreenR;
import net.nic.npc.gui.books.ScreenB;
import net.nic.npc.gui.inviteKingdom.ScreenIK;
import net.nic.npc.gui.kingdomInterface.ScreenKIC;
import net.nic.npc.item.MDataComponents;
import net.nic.npc.item.MItems;
import org.slf4j.Logger;

@Mod(NpcMain.MODID)
public class NpcMain
{
    public static final String MODID = "npcmain";
    public static final Logger LOGGER = LogUtils.getLogger();
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    static final ModConfigSpec SPEC = BUILDER.build();

    public NpcMain(IEventBus modBus, ModContainer modContainer) {

        MBlocks.register(modBus);
        MEntityBlocks.register(modBus);
        MItems.register(modBus);
        MMenus.register(modBus);
        MCreativeTabs.register(modBus);
        MEntities.register(modBus);
        MEntityAttributes.register(modBus);
        MDataComponents.register(modBus);

        modBus.addListener(this::registerEntityRenderers);
        modBus.addListener(this::registerLayerDefinitions);

        NeoForge.EVENT_BUS.register(this);
        modContainer.registerConfig(ModConfig.Type.COMMON, SPEC);
    }




    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(MMenus.MENUKIC.get(), ScreenKIC::new);
            event.register(MMenus.MENUR.get(), ScreenR::new);
            event.register(MMenus.MENUB.get(), ScreenB::new);
            event.register(MMenus.MENUIK.get(), ScreenIK::new);
        }

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            event.enqueueWork( ()->
                    ItemBlockRenderTypes.setRenderLayer(MBlocks.STRAWBERRY_CROP.get(), RenderType.CUTOUT)
            );
            event.enqueueWork( ()->
                    ItemBlockRenderTypes.setRenderLayer(MBlocks.BLUEBERRY_CROP.get(), RenderType.CUTOUT)
            );
            event.enqueueWork( ()->
                    ItemBlockRenderTypes.setRenderLayer(MBlocks.KIWI_PLANT.get(), RenderType.CUTOUT)
            );
        }

    }

    public void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BulletModel.LAYER_LOCATION, BulletModel::createBodyLayer);
    }

    public void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(MEntities.NPC.get(), NPCRenderer::new);
        event.registerEntityRenderer(MEntities.TIERED_ARROW.get(), TieredArrowRenderer::new);
        event.registerEntityRenderer(MEntities.BULLET.get(), BulletRenderer::new);

    }
}
