package net.Lngltnat.OilSalt.datagen;

import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.block.ModBlocks;
import net.Lngltnat.OilSalt.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OilSalt.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {


        basicItem(ModItems.OS_INGOT.get());
        basicItem(ModItems.BAR_HOP_MUSIC_DISC.get());
        basicItem(ModItems.SHIT.get());
        basicItem(ModItems.SHRIMP.get());
        basicItem(ModItems.RAW_OS.get());
        basicItem(ModItems.WANGRANSPEAKER.get());
        basicItem(ModItems.BOOM_FOOD.get());
        basicItem(ModItems.OS_UPGRADE_SMITHING_TEMPLATE.get());

        basicItem(ModBlocks.OS_DOOR.asItem());

        phandheldItem(ModItems.OS_AXE);
        phandheldItem(ModItems.OS_HOE);
        phandheldItem(ModItems.OS_SWORD);
        phandheldItem(ModItems.OS_PICKAXE);
        phandheldItem(ModItems.OS_SHOVEL);

        basicItem(ModItems.OS_HELMET.get());
        basicItem(ModItems.OS_CHESTPLATE.get());
        basicItem(ModItems.OS_LEGGINGS.get());
        basicItem(ModItems.OS_BOOTS.get());
        basicItem(ModItems.OS_CHESTPLATE_ELYTRA.get());

    }



    private ItemModelBuilder phandheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(OilSalt.MODID,"item/" + item.getId().getPath()));
    }
}
