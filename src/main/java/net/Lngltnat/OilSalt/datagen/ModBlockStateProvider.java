package net.Lngltnat.OilSalt.datagen;

import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, OilSalt.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.OS_BLOCK);
        blockWithItem(ModBlocks.RAW_OS_BLOCK);
        blockWithItem(ModBlocks.DEEPSLATE_OS_ORE);
        blockWithItem(ModBlocks.OS_ORE);

        stairsBlock(ModBlocks.OS_STAIRS.get(),blockTexture(ModBlocks.OS_BLOCK.get()));

        slabBlock(ModBlocks.OS_SLAB.get(),blockTexture(ModBlocks.OS_BLOCK.get()),blockTexture(ModBlocks.OS_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.OS_DOOR.get(),modLoc("block/os_door_bottom"),modLoc("block/os_door_top"),"cutout");
        trapdoorBlockWithRenderType(ModBlocks.OS_TRAPDOOR.get(),modLoc("block/os_trapdoor"),true,"cutout");

        blockItem(ModBlocks.OS_STAIRS);
        blockItem(ModBlocks.OS_SLAB);
        blockItem(ModBlocks.OS_TRAPDOOR,"_bottom");


    }


    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock){
        simpleBlockItem(deferredBlock.get(),new ModelFile.UncheckedModelFile("oilsaltmod:block/"+deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock,String appendix){
        simpleBlockItem(deferredBlock.get(),new ModelFile.UncheckedModelFile("oilsaltmod:block/"+deferredBlock.getId().getPath() + appendix));
    }


}
