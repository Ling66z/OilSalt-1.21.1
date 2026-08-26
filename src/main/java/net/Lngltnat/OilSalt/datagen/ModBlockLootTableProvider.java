package net.Lngltnat.OilSalt.datagen;

import net.Lngltnat.OilSalt.block.ModBlocks;
import net.Lngltnat.OilSalt.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.OS_BLOCK.get());
        dropSelf(ModBlocks.RAW_OS_BLOCK.get());

        add(ModBlocks.OS_ORE.get(),
                block -> createOreDrop(ModBlocks.OS_ORE.get(), ModItems.RAW_OS.get()));
        add(ModBlocks.DEEPSLATE_OS_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_OS_ORE.get(), ModItems.RAW_OS.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
