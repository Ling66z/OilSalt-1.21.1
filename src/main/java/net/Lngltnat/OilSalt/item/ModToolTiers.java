package net.Lngltnat.OilSalt.item;

import net.Lngltnat.OilSalt.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier OS = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_OS_TOOL,
            3072,10.0F,5.0F,22,() -> Ingredient.of(ModItems.OS_INGOT));
}
