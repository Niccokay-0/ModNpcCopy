package net.nic.npc.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nic.npc.NpcMain;
import net.nic.npc.block.custom.fruitcrops.BlueBerryCrop;
import net.nic.npc.block.custom.fruitcrops.KiwiCrop;
import net.nic.npc.block.custom.fruitcrops.StrawBerryCrop;
import net.nic.npc.block.custom.infuser.InfuserBlock;
import net.nic.npc.block.custom.kingdomBlock.KingdomTableBlock;
import net.nic.npc.item.MItems;

import java.util.function.Function;

public class MBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(NpcMain.MODID);


    public static final DeferredBlock<Block> KINGDOM_BLOCK = registerBlockWithItem(
            "kingdom_block",
            kingdomTableBlock -> new KingdomTableBlock(kingdomTableBlock,BlockBehaviour.Properties.of()
                    .destroyTime(2.0f)
            ));

    public static final DeferredBlock<Block> INFUSER = registerBlockWithItem(
            "infuser",
            infuserBlock -> new InfuserBlock(infuserBlock,BlockBehaviour.Properties.of()
                    .destroyTime(2.0f)
            ));

    /**
     * do Ore Blocks, and Material Blockss
     */

    public static final DeferredBlock<Block> STRAWBERRY_CROP = BLOCKS.register(
            "strawberry_crop",
            name -> new StrawBerryCrop(name, BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).instabreak().noOcclusion()));

    public static final DeferredBlock<Block> BLUEBERRY_CROP = BLOCKS.register(
            "blueberry_crop",
            name -> new BlueBerryCrop(name, BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).instabreak().noOcclusion()));

    public static final DeferredBlock<Block> KIWI_PLANT = BLOCKS.register(
            "kiwi_plant",
            name -> new KiwiCrop(name, BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).instabreak().noOcclusion()));


    public static <B extends Block> DeferredBlock<B> registerBlockWithItem(String name, Function<ResourceLocation, ? extends B> func) {
        DeferredBlock<B> blockToReturn = BLOCKS.register(name, func);
        registerBlockItem(blockToReturn);
        return blockToReturn;
    }

    public static <B extends  Block> void registerBlockItem(DeferredBlock<B> block)    {
        MItems.ITEMS.registerSimpleBlockItem(block);
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
