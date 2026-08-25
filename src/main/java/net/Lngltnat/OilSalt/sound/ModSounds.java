package net.Lngltnat.OilSalt.sound;

import net.Lngltnat.OilSalt.OilSalt;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, OilSalt.MODID);

    public static final Supplier<SoundEvent> WANGRANSPEAKER_USE = registerSoundEvent("wangranspeaker_use");

    public static final Supplier<SoundEvent> BAR_HOP = registerSoundEvent("bar_hop");
    public static ResourceKey<JukeboxSong> BAR_HOP_KEY = createSong("bar_hop");


    private static Supplier<SoundEvent> registerSoundEvent(String name){
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(OilSalt.MODID,name);
        return SOUND_EVENTS.register(name,() -> SoundEvent.createVariableRangeEvent(id));
    }

    private static ResourceKey<JukeboxSong> createSong(String name){
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(OilSalt.MODID,name));
    }



    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
