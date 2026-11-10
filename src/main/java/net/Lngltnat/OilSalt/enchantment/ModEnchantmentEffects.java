package net.Lngltnat.OilSalt.enchantment;

import com.mojang.serialization.MapCodec;
import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.enchantment.custom.DiscCatcherEnchantmentEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEnchantmentEffects { //现在用不上
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, OilSalt.MODID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> DISC_CATCHER =
            ENTITY_ENCHANTMENT_EFFECTS.register("disc_catcher",() -> DiscCatcherEnchantmentEffect.CODEC);

    public static void register(IEventBus eventBus) {
        ENTITY_ENCHANTMENT_EFFECTS.register(eventBus);
    }
}
