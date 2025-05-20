package net.nic.npc.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.nic.npc.NpcMain;
import net.nic.npc.block.custom.MCropBlock;
import net.nic.npc.block.custom.MBerryBush;
import net.nic.npc.block.custom.kingdomBlock.KingdomTableBlock;
import net.nic.npc.item.MItems;

import java.util.function.Function;

public class MBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(NpcMain.MODID);


    public static final DeferredBlock<Block> KINGDOM_BLOCK = registerBlockWithItem(
            "kingdom_block",
            name -> new KingdomTableBlock(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, name))
                    .destroyTime(2.0f)
            ));

    public static final DeferredBlock<Block> STRAWBERRY_CROP = registerBlockWithItem(
            "strawberry_crop",
            name -> new MCropBlock(name, BlockBehaviour.Properties.ofFullCopy(Blocks.POTATOES).instabreak().noOcclusion()));

    public static final DeferredBlock<Block> BLUEBERRY_BUSH = registerBlockWithItem(
            "blueberry_bush",
            name -> new MBerryBush(name, BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH).instabreak().noOcclusion()));


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
