package net.Lngltnat.OilSalt.datagen;

import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

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
    }
}
