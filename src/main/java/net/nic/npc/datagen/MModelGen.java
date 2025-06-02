package net.nic.npc.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.numeric.CrossbowPull;
import net.minecraft.client.renderer.item.properties.select.Charge;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
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


    public static ResourceLocation era0BookTexture = ResourceLocation.fromNamespaceAndPath(NpcMain.MODID, "item/era_0_book_lore");

    public MModelGen(PackOutput output) {
        super(output, NpcMain.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        // Generate the block's item model as a flat item (like a normal item)


        itemModels.generateFlatItem(MItems.KINGDOM_INVITE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(MItems.ENDSTONE_PROJECTILE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.STONE_PROJECTILE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.IRON_PROJECTILE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.LEAD_PROJECTILE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.PHOSPHORUS_PROJECTILE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.TUNGSTEN_PROJECTILE.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(MItems.PHOSPHORUS_CRYSTALS.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.TUNGSTEN_CHUNK.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.TUNGSTEN_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.RAW_LEAD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.LEAD_INGOT.get(), ModelTemplates.FLAT_ITEM);


        /**
         * ender
         */
        this.generateItemWithSharedTexture(MItems.TEST_BOOK.get(), era0BookTexture, ModelTemplates.FLAT_ITEM, itemModels);
        this.generateItemWithSharedTexture(MItems.VAELL_NOTES.get(), era0BookTexture, ModelTemplates.FLAT_ITEM, itemModels);
        this.generateItemWithSharedTexture(MItems.SYLVAE_JOURNAL.get(), era0BookTexture, ModelTemplates.FLAT_ITEM, itemModels);
        this.generateItemWithSharedTexture(MItems.KALEX_LOG.get(), era0BookTexture, ModelTemplates.FLAT_ITEM, itemModels);

        itemModels.generateFlatItem(MItems.RINGENDER_SMITHING_UPGRADE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.RINGENDER_NETHERITE_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.armorModel(itemModels, MItems.RINGENDER_HOOD.get(), CustomEquipmentAssets.RINGENDER);
        this.armorModel(itemModels, MItems.RINGENDER_COAT.get(), CustomEquipmentAssets.RINGENDER);
        this.armorModel(itemModels, MItems.RINGENDER_CLOAK.get(), CustomEquipmentAssets.RINGENDER);

        itemModels.generateFlatItem(MItems.RINGENDER_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(MItems.RINGENDER_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(MItems.RINGENDER_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);


        /**
         * purpur
         */
        itemModels.generateFlatItem(MItems.PURPUR_SMITHING_UPGRADE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.PURPURED_NETHERITE_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.armorModel(itemModels, MItems.PURPUR_HELMET.get(), CustomEquipmentAssets.PURPUR);
        this.armorModel(itemModels, MItems.PURPUR_CHESTPLATE.get(), CustomEquipmentAssets.PURPUR);
        this.armorModel(itemModels, MItems.PURPUR_LEGGINGS.get(), CustomEquipmentAssets.PURPUR);
        this.armorModel(itemModels, MItems.PURPUR_BOOTS.get(), CustomEquipmentAssets.PURPUR);

        itemModels.generateFlatItem(MItems.PURPUR_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(MItems.PURPUR_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(MItems.PURPUR_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);


        this.generateCrossbow(MItems.PURPUR_CROSSBOW.get(), itemModels);
        this.generateMusket(MItems.PURPUR_MUSKET.get(), itemModels);

        /**
         * blazed
         */
        itemModels.generateFlatItem(MItems.BLAZING_SMITHING_UPGRADE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(MItems.BLAZING_NETHERITE_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.armorModel(itemModels, MItems.BLAZED_HELMET.get(), CustomEquipmentAssets.BLAZED);
        this.armorModel(itemModels, MItems.BLAZED_CHESTPLATE.get(), CustomEquipmentAssets.BLAZED);
        this.armorModel(itemModels, MItems.BLAZED_LEGGINGS.get(), CustomEquipmentAssets.BLAZED);
        this.armorModel(itemModels, MItems.BLAZED_BOOTS.get(), CustomEquipmentAssets.BLAZED);

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
        blockModels.createGenericCube(MBlocks.INFUSER.get());
        blockModels.createCropBlock(MBlocks.STRAWBERRY_CROP.get(), BlockStateProperties.AGE_3, 0, 1, 2, 3);
        createBush(MBlocks.BLUEBERRY_CROP.get(), BlockStateProperties.AGE_3, blockModels);
        createBush(MBlocks.KIWI_PLANT.get(), BlockStateProperties.AGE_3, blockModels);
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


    public void createBush(Block block, IntegerProperty ageProperty, BlockModelGenerators blockModels) {
        blockModels.registerSimpleFlatItemModel(block.asItem());

        blockModels.blockStateOutput

                .accept(MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(ageProperty).generate(age -> BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(block, "_stage" + age, ModelTemplates.CROSS, TextureMapping::cross)))));

    }

    public void generateItemWithSharedTexture(Item item, ResourceLocation sharedTexture, ModelTemplate modelTemplate, ItemModelGenerators itemModels) {
        ResourceLocation modelLocation = modelTemplate.create(
                ModelLocationUtils.getModelLocation(item),
                TextureMapping.layer0(sharedTexture),
                itemModels.modelOutput
        );
        itemModels.itemModelOutput.accept(item, ItemModelUtils.plainModel(modelLocation));
    }

    public void generateCrossbow(Item crossbowItem, ItemModelGenerators modelGenerators) {
        modelGenerators.createFlatItemModel(crossbowItem, "", ModelTemplates.CROSSBOW);
        ItemModel.Unbaked itemmodel$unbaked = ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(crossbowItem));
        ItemModel.Unbaked itemmodel$unbaked1 = ItemModelUtils.plainModel(modelGenerators.createFlatItemModel(crossbowItem, "_pulling_0", ModelTemplates.CROSSBOW));
        ItemModel.Unbaked itemmodel$unbaked2 = ItemModelUtils.plainModel(modelGenerators.createFlatItemModel(crossbowItem, "_pulling_1", ModelTemplates.CROSSBOW));
        ItemModel.Unbaked itemmodel$unbaked3 = ItemModelUtils.plainModel(modelGenerators.createFlatItemModel(crossbowItem, "_pulling_2", ModelTemplates.CROSSBOW));
        ItemModel.Unbaked itemmodel$unbaked4 = ItemModelUtils.plainModel(modelGenerators.createFlatItemModel(crossbowItem, "_arrow", ModelTemplates.CROSSBOW));
        ItemModel.Unbaked itemmodel$unbaked5 = ItemModelUtils.plainModel(modelGenerators.createFlatItemModel(crossbowItem, "_firework", ModelTemplates.CROSSBOW));
        modelGenerators.itemModelOutput
                .accept(
                        crossbowItem,
                        ItemModelUtils.select(
                                new Charge(),
                                ItemModelUtils.conditional(
                                        ItemModelUtils.isUsingItem(),
                                        ItemModelUtils.rangeSelect(
                                                new CrossbowPull(),
                                                itemmodel$unbaked1,
                                                ItemModelUtils.override(itemmodel$unbaked2, 0.58F),
                                                ItemModelUtils.override(itemmodel$unbaked3, 1.0F)
                                        ),
                                        itemmodel$unbaked
                                ),
                                ItemModelUtils.when(CrossbowItem.ChargeType.ARROW, itemmodel$unbaked4),
                                ItemModelUtils.when(CrossbowItem.ChargeType.ROCKET, itemmodel$unbaked5)
                        )
                );
    }

    public void generateMusket(Item musketItem, ItemModelGenerators modelGenerators) {
        // Base (unloaded) model
        modelGenerators.createFlatItemModel(musketItem, "", ModelTemplates.FLAT_HANDHELD_ITEM);

        // Models
        ItemModel.Unbaked unloadedModel = ItemModelUtils.plainModel(ModelLocationUtils.getModelLocation(musketItem));
        ItemModel.Unbaked loadedModel = ItemModelUtils.plainModel(
                modelGenerators.createFlatItemModel(musketItem, "_loaded", ModelTemplates.CROSSBOW)
        );

        modelGenerators.itemModelOutput.accept(
                musketItem,
                ItemModelUtils.conditional(
                        ItemModelUtils.isUsingItem(),
                        ItemModelUtils.rangeSelect(
                                new CrossbowPull(),
                                unloadedModel,
                                ItemModelUtils.override(unloadedModel, 0.58F),
                                ItemModelUtils.override(loadedModel, 1.0F)
                        ),
                        unloadedModel
                )
        );
    }
}