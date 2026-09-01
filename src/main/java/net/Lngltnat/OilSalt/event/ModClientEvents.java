package net.Lngltnat.OilSalt.event;

import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.layer.ModElytraLayer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = OilSalt.MODID, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onAddLayers(EntityRenderersEvent.AddLayers event) {

        event.getSkins().forEach(skin -> {
            PlayerRenderer renderer = event.getSkin(skin);
            if (renderer != null) {

                renderer.addLayer(new ModElytraLayer<>(renderer, event.getEntityModels()));
            }
        });
    }
}