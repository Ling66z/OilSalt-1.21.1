package net.Lngltnat.OilSalt.effect;

import net.Lngltnat.OilSalt.OilSalt;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, OilSalt.MODID);

    public static final Holder<MobEffect> POSTPRANDIAL_SOMNOLENCE_EFFECT = MOB_EFFECTS.register("postprandial_somnolence",
            () -> new PostprandialSomnolenceEffect(MobEffectCategory.NEUTRAL,0x66ccff)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            ResourceLocation.fromNamespaceAndPath(OilSalt.MODID,"postprandial_somnolence"),-0.25f
                            ,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
