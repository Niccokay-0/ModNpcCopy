package net.nic.npc.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.nic.npc.NpcMain;
import net.nic.npc.block.MBlocks;
import net.nic.npc.item.MItems;
import net.nic.npc.item.materials.CustomEquipmentAssets;


public class MModelGen extends ModelProvider {

    public MModelGen(PackOutput output) {
        super(output, NpcMain.MODID);
        System.out.println("📦 MODELGENERATOR CREATED");

    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        System.out.println("📦 MODELGENERATOR triggered");

        // Generate the block's item model as a flat item (like a normal item)

        armorModel(itemModels, MItems.BLAZED_HELMET.get(), CustomEquipmentAssets.BLAZED);
        armorModel(itemModels, MItems.BLAZED_CHESTPLATE.get(), CustomEquipmentAssets.BLAZED);
        armorModel(itemModels, MItems.BLAZED_LEGGINGS.get(), CustomEquipmentAssets.BLAZED);
        armorModel(itemModels, MItems.BLAZED_BOOTS.get(), CustomEquipmentAssets.BLAZED);

        itemModels.generateFlatItem(MItems.BLAZED_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(MItems.BLAZED_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(MItems.BLAZED_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(MItems.BLAZED_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(MItems.BLAZED_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        /**
         * FRUITS
         * {@link MItems}
         */
        itemModels.generateFlatItem(MItems.COCONUT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.COCONUT_SHARDS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.DRINKABLE_COCONUT.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(MItems.LEMON.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.BANANA.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.MANGO.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.KIWI.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.PEACH.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.AVOCADO.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.PINEAPPLE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.STRAWBERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.BLUEBERRY.get(), ModelTemplates.FLAT_ITEM);


        /**
         * ARROWS
         */
        itemModels.generateFlatItem(MItems.WOODEN_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.STONE_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.IRON_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.GOLDEN_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.DIAMOND_ARROW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.NETHERITE_ARROW.get(), ModelTemplates.FLAT_ITEM);


        blockModels.createGenericCube(MBlocks.KINGDOM_BLOCK.get());
        blockModels.createCropBlock(MBlocks.STRAWBERRY_CROP.get(), BlockStateProperties.AGE_3, 0, 1, 2, 3);

        createBush(MBlocks.BLUEBERRY_BUSH.get(), BlockStateProperties.AGE_3, blockModels, 0, 1, 2, 3);

    }


    public void armorModel(ItemModelGenerators itemModels, Item item, ResourceKey<EquipmentAsset> equipmentKey) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);
        String armorType = "";
        if (id.getPath().contains("helmet"))
            armorType = "helmet";
        else if (id.getPath().contains("chestplate"))
            armorType = "chestplate";
        else if (id.getPath().contains("leggings"))
            armorType = "leggings";
        else if (id.getPath().contains("boots"))
            armorType = "boots";
        itemModels.generateTrimmableItem(item, equipmentKey, ResourceLocation.withDefaultNamespace("trims/items/" + armorType + "_trim"), false);
    }


    public void createBush(Block block, IntegerProperty ageProperty, BlockModelGenerators blockModels, int... ageToVisualStageMapping) {
        System.out.println("Generating bush model for block: " + block.getDescriptionId());

        blockModels.registerSimpleFlatItemModel(block.asItem());
        System.out.println("BERRY BUSY DOING IT");

        blockModels.blockStateOutput

                .accept(
                        MultiVariantGenerator.dispatch(block)
                                .with(
                                        PropertyDispatch.initial(BlockStateProperties.AGE_3)
                                                .generate(
                                                        age -> BlockModelGenerators.plainVariant(
                                                                blockModels.createSuffixedVariant(block, "_stage" + age, ModelTemplates.CROSS, TextureMapping::cross)
                                                        )
                                                )
                                ));
        System.out.println("DONE!" + block.getName());


    }
}

