package net.Lngltnat.OilSalt.datagen;

import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.block.ModBlocks;
import net.Lngltnat.OilSalt.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, OilSalt.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.OS_BLOCK.get())
                .add(ModBlocks.RAW_OS_BLOCK.get())
                .add(ModBlocks.DEEPSLATE_OS_ORE.get())
                .add(ModBlocks.OS_ORE.get())
                .add(ModBlocks.OS_DOOR.get())
                .add(ModBlocks.OS_SLAB.get())
                .add(ModBlocks.OS_STAIRS.get())
                .add(ModBlocks.OS_TRAPDOOR.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.OS_BLOCK.get())
                .add(ModBlocks.RAW_OS_BLOCK.get())
                .add(ModBlocks.DEEPSLATE_OS_ORE.get())
                .add(ModBlocks.OS_ORE.get())
                .add(ModBlocks.OS_DOOR.get())
                .add(ModBlocks.OS_SLAB.get())
                .add(ModBlocks.OS_STAIRS.get())
                .add(ModBlocks.OS_TRAPDOOR.get());

        tag(ModTags.Blocks.NEEDS_OS_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_OS_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
                .remove(ModTags.Blocks.NEEDS_OS_TOOL);

    }
}
