package net.Lngltnat.OilSalt.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties SHRIMP = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).effect(()-> new MobEffectInstance(MobEffects.LEVITATION,120),0.8f).build();
    public static final FoodProperties BOOM_FOOD = new FoodProperties.Builder().nutrition(3).alwaysEdible().build();
}
