package net.Lngltnat.OilSalt.event;

import com.mojang.blaze3d.platform.InputConstants;
import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.layer.ModCapeLayer;
import net.Lngltnat.OilSalt.layer.ModElytraLayer;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.client.settings.KeyModifier;
import net.neoforged.neoforge.common.util.Lazy;
import org.checkerframework.checker.signature.qual.Identifier;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = OilSalt.MODID, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent
    public static void onAddLayers(EntityRenderersEvent.AddLayers event) {

        event.getSkins().forEach(skin -> {
            PlayerRenderer renderer = event.getSkin(skin);
            if (renderer != null) {

                renderer.addLayer(new ModElytraLayer<>(renderer, event.getEntityModels()));
                //renderer.addLayer(new ModCapeLayer(renderer));
            }
        });
    }

    // In some physical client only class

    public static final KeyMapping INVENTORYSWAP = new KeyMapping("key.categories.oilsaltmod.examplecategory",
            KeyConflictContext.IN_GAME, //不在菜单里用
            KeyModifier.CONTROL,  //按ctrl + p
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_P,
            "key.categories.misc"
    );


    // Key mapping is lazily initialized so it doesn't exist until it is registered
    public static final Lazy<KeyMapping> OILSALT_MAPPING = Lazy.of(() -> INVENTORYSWAP
    );

    @SubscribeEvent // on the mod event bus only on the physical client
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(OILSALT_MAPPING.get());
    }

    private static int currentRow = 0;

    @SubscribeEvent // on the game event bus only on the physical client
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        MultiPlayerGameMode gameMode = mc.gameMode;
        while (OILSALT_MAPPING.get().consumeClick()) {
            if(player == null) return;
            if(gameMode == null) return;
            swapHotbarWithRow(mc.player, currentRow);
            currentRow = (currentRow + 1) % 3;


            // Execute logic to perform on click here
        }
    }

    private static void swapHotbarWithRow(Player player, int row) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.gameMode == null) return;

        // 主背包起始槽位 ID：9 + row * 9
        int inventorySlotStart = 9 + row * 9;

        for (int hotbarIndex = 0; hotbarIndex < 9; hotbarIndex++) {
            int inventorySlotId = inventorySlotStart + hotbarIndex;

            // 模拟：鼠标悬停在背包槽位 inventorySlotId 上，按下数字键 hotbarIndex
            mc.gameMode.handleInventoryMouseClick(
                    player.inventoryMenu.containerId, // 当前菜单的 containerId
                    inventorySlotId,                  // 被交换的背包槽位 ID
                    hotbarIndex,                      // 目标快捷栏索引 0~8
                    ClickType.SWAP,                   // 交换操作
                    player
            );
        }
    }







  
}