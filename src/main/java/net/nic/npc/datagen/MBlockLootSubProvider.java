package net.nic.npc.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.nic.npc.block.MBlocks;
import net.nic.npc.item.MItems;
import org.jetbrains.annotations.NotNull;

import java.util.Set;


public class MBlockLootSubProvider extends BlockLootSubProvider {


    public MBlockLootSubProvider(HolderLookup.Provider lookupProvider) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, lookupProvider);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return (Iterable<Block>) MBlocks.BLOCKS.getEntries().stream()
                .map(registryObject -> registryObject.get())
                .toList();
    }

    @Override
    protected void generate() {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.dropSelf(MBlocks.KINGDOM_BLOCK.get());

        createCropBlockWithSameSeed(MBlocks.STRAWBERRY_CROP.get(), MItems.STRAWBERRY.get(),3, registrylookup);
    }

    private void createCropBlockWithSameSeed(Block cropBlock, BlockItem drop , int MAXAGE, HolderLookup.RegistryLookup<Enchantment> registrylookup) {


        //condtion; is the crop grown?
        LootItemCondition.Builder lootitemcondition$builder4 = LootItemBlockStatePropertyCondition.hasBlockStateProperties(cropBlock)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(CropBlock.AGE, MAXAGE));

        //loottable
        this.add(cropBlock,this.applyExplosionDecay(drop, this.applyExplosionDecay(drop, LootTable.lootTable()
                .withPool(LootPool.lootPool().add(LootItem.lootTableItem(drop))).withPool(LootPool.lootPool()
                                        .when(lootitemcondition$builder4)
                                        .add(
                                                LootItem.lootTableItem(drop)
                                                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(registrylookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3))
                                        )
                                )))
        );
    }


}
