package net.Lngltnat.OilSalt.item;

import net.Lngltnat.OilSalt.OilSalt;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class ModArmorMaterials {

    public static final Holder<ArmorMaterial> OS_ARMOR_MATERIAL = register("os",
            Util.make(new EnumMap<>(ArmorItem.Type.class), atttibute -> {
                atttibute.put(ArmorItem.Type.BOOTS,4);
                atttibute.put(ArmorItem.Type.LEGGINGS,7);
                atttibute.put(ArmorItem.Type.CHESTPLATE,9);
                atttibute.put(ArmorItem.Type.HELMET,4);
                atttibute.put(ArmorItem.Type.BODY,11);
            }),16, SoundEvents.ARMOR_EQUIP_NETHERITE,4.0f,0.2f,() -> ModItems.OS_INGOT.get());





    private static Holder<ArmorMaterial> register(
            String name,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantmentValue,
            Holder<SoundEvent> equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Item> repairIngridientItem
    ) {
        ResourceLocation location = ResourceLocation.fromNamespaceAndPath(OilSalt.MODID,name);
        Supplier<Ingredient> repairIngridient = () -> Ingredient.of(repairIngridientItem.get());
        List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(location));


        EnumMap<ArmorItem.Type, Integer> enummap = new EnumMap<>(ArmorItem.Type.class);

        for (ArmorItem.Type armoritem$type : ArmorItem.Type.values()) {
            enummap.put(armoritem$type, defense.get(armoritem$type));
        }

        return Registry.registerForHolder(
                BuiltInRegistries.ARMOR_MATERIAL,
                ResourceLocation.withDefaultNamespace(name),
                new ArmorMaterial(enummap, enchantmentValue, equipSound, repairIngridient, layers, toughness, knockbackResistance)
        );
    }

}


