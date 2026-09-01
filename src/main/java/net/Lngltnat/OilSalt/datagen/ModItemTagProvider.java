package net.Lngltnat.OilSalt.datagen;

import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {


    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags,
                              @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, OilSalt.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(ItemTags.SWORDS)
                .add(ModItems.OS_SWORD.get());

        tag(ItemTags.AXES)
                .add(ModItems.OS_AXE.get());

        tag(ItemTags.SHOVELS)
                .add(ModItems.OS_SHOVEL.get());

        tag(ItemTags.HOES)
                .add(ModItems.OS_HOE.get());

        tag(ItemTags.PICKAXES)
                .add(ModItems.OS_PICKAXE.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.OS_HELMET.get());

        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.OS_CHESTPLATE_ELYTRA.get())
                .add(ModItems.OS_CHESTPLATE.get());

        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.OS_LEGGINGS.get());

        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.OS_BOOTS.get());



    }
}
