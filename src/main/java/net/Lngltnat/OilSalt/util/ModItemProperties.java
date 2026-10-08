package net.Lngltnat.OilSalt.util;

import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.component.ModDataComponents;
import net.Lngltnat.OilSalt.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties(){
//        ItemProperties.register(ModItems.OS_CHESTPLATE_ELYTRA.get(), ResourceLocation.fromNamespaceAndPath(OilSalt.MODID,"flymode"),
//                (itemStack, clientLevel, livingEntity, i) -> itemStack.getOrDefault(ModDataComponents.OS_ARMOR_MODE,true) ? 1f : 0f);
    }
}
