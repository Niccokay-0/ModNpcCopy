package net.nic.npc.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.nic.npc.NpcMain;
import net.nic.npc.item.MItems;
import net.nic.npc.item.custom.CustomItemTags;

import java.util.concurrent.CompletableFuture;

public class MItemTagProvider extends ItemTagsProvider {

    public MItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, BlockTagsProvider blockTagsProvider) {
        super(output, lookupProvider, blockTagsProvider.contentsGetter(), NpcMain.MODID);
    }


    @Override
    protected void addTags(HolderLookup.Provider provider) {
        System.out.println("🏹 Running ModItemTagProvider");


        tag(CustomItemTags.UPGRADING_MATERIALS).add(
                Items.QUARTZ.asItem(),
                Items.EMERALD_BLOCK.asItem()
        );

        tag(CustomItemTags.MUSKET_PROJECTILES).add(
                MItems.ENDSTONE_PROJECTILE.get(),
                MItems.STONE_PROJECTILE.get(),
                MItems.IRON_PROJECTILE.get(),
                MItems.LEAD_PROJECTILE.get(),
                MItems.PHOSPHORUS_PROJECTILE.get(),
                MItems.TUNGSTEN_PROJECTILE.get()
                );

        //noinspection unchecked
        tag(CustomItemTags.ENDSTONE_TOOL_MATERIALS).addTags(CustomItemTags.RINGENDER_ITEMS, CustomItemTags.PURPUR_ITEMS).add(
                Items.END_STONE, Items.END_STONE_BRICKS, Items.PURPUR_BLOCK
        );


        tag(CustomItemTags.LEAD_TOOL_MATERIALS)
                .add(MItems.LEAD_INGOT.get());

        tag(CustomItemTags.TUNGSTEN_TOOL_MATERIALS)
                .add(MItems.TUNGSTEN_INGOT.get());

        tag(ItemTags.ARROWS)
                .add(MItems.IRON_ARROW.get())
                .add(MItems.WOODEN_ARROW.get())
                .add(MItems.STONE_ARROW.get())
                .add(MItems.IRON_ARROW.get())
                .add(MItems.GOLDEN_ARROW.get())
                .add(MItems.DIAMOND_ARROW.get())
                .add(MItems.NETHERITE_ARROW.get());


        tag(ItemTags.SWORDS)
                .add(MItems.BLAZED_SWORD.get())
                .add(MItems.RINGENDER_SWORD.get())
                .add(MItems.PURPUR_SWORD.get());
        tag(ItemTags.SWORD_ENCHANTABLE)
                .add(MItems.BLAZED_SWORD.get())
                .add(MItems.RINGENDER_SWORD.get())
                .add(MItems.PURPUR_SWORD.get());

        tag(ItemTags.PICKAXES).add(
                MItems.BLAZED_PICKAXE.get(),
                MItems.RINGENDER_PICKAXE.get(),
                MItems.PURPUR_PICKAXE.get());

        tag(ItemTags.AXES).add(
                MItems.BLAZED_AXE.get());

        tag(ItemTags.HOES).add(
                MItems.BLAZED_HOE.get());


        tag(ItemTags.SHOVELS).add(
                MItems.BLAZED_SHOVEL.get());

        tag(ItemTags.MINING_ENCHANTABLE).add(
                MItems.BLAZED_PICKAXE.get(),
                MItems.RINGENDER_PICKAXE.get(),
                MItems.PURPUR_PICKAXE.get(),

                MItems.BLAZED_AXE.get(),
                MItems.PURPUR_AXE.get(),
                MItems.RINGENDER_AXE.get(),

                MItems.BLAZED_SHOVEL.get(),

                MItems.BLAZED_HOE.get());

        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(
                MItems.BLAZED_PICKAXE.get(),
                MItems.RINGENDER_PICKAXE.get(),
                MItems.PURPUR_PICKAXE.get(),

                MItems.BLAZED_AXE.get(),
                MItems.RINGENDER_AXE.get(),
                MItems.PURPUR_AXE.get(),

                MItems.BLAZED_SHOVEL.get(),

                MItems.BLAZED_HOE.get());


        tag(ItemTags.HEAD_ARMOR).add(
                MItems.BLAZED_HELMET.get(),
                MItems.RINGENDER_HOOD.get(),
                MItems.PURPUR_HELMET.get());

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(
                MItems.BLAZED_HELMET.get(),
                MItems.RINGENDER_HOOD.get(),
                MItems.PURPUR_HELMET.get());

        tag(ItemTags.CHEST_ARMOR).add(
                MItems.BLAZED_CHESTPLATE.get(),
                MItems.RINGENDER_COAT.get(),
                MItems.PURPUR_CHESTPLATE.get());

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(
                MItems.BLAZED_CHESTPLATE.get(),
                MItems.RINGENDER_COAT.get(),
                MItems.PURPUR_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR).add(
                MItems.BLAZED_LEGGINGS.get(),
                MItems.PURPUR_LEGGINGS.get());

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(
                MItems.BLAZED_LEGGINGS.get(),
                MItems.PURPUR_LEGGINGS.get());

        tag(ItemTags.FOOT_ARMOR).add(
                MItems.BLAZED_BOOTS.get(),
                MItems.RINGENDER_CLOAK.get(),
                MItems.PURPUR_BOOTS.get());

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(
                MItems.BLAZED_BOOTS.get(),
                MItems.RINGENDER_CLOAK.get(),
                MItems.PURPUR_BOOTS.get());

        tag(ItemTags.ARMOR_ENCHANTABLE).add(
                MItems.PURPUR_BOOTS.get(),
                MItems.PURPUR_LEGGINGS.get(),
                MItems.PURPUR_CHESTPLATE.get(),
                MItems.PURPUR_HELMET.get(),
                MItems.RINGENDER_CLOAK.get(),
                MItems.RINGENDER_COAT.get(),
                MItems.RINGENDER_HOOD.get());

        this.tag(CustomItemTags.BLAZED_ITEMS)
                .add(Items.BLAZE_POWDER)
                .add(Items.BLAZE_ROD);

        this.tag(CustomItemTags.RINGENDER_ITEMS)
                .add(Items.END_CRYSTAL);

        this.tag(CustomItemTags.PURPUR_ITEMS)
                .add(Items.CHORUS_FLOWER)
                .add(Items.CHORUS_FRUIT)
                .add(Items.CHORUS_PLANT)
                .add(Items.POPPED_CHORUS_FRUIT);
    }
}
