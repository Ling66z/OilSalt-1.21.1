package net.Lngltnat.OilSalt.event;


import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.component.ModDataComponent;
import net.Lngltnat.OilSalt.item.custom.OsPickaxeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = OilSalt.MODID)
public class ModEvents {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    private static long lastToggleTime = 0;

    @SubscribeEvent
    public static void onOsToolUsage(BlockEvent.@NotNull BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();
        boolean mode = mainHandItem.getOrDefault(ModDataComponent.OS_PICKAXE_MODE.get(), false);

        if (mode) {
            if(mainHandItem.getItem() instanceof OsPickaxeItem osPickaxe && player instanceof ServerPlayer serverPlayer) {
                BlockPos initialBlockPos = event.getPos();
                if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                    return;
                }

                for(BlockPos pos : OsPickaxeItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                    if(pos.equals(initialBlockPos) || !osPickaxe.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                        continue;
                    }

                    HARVESTED_BLOCKS.add(pos);
                    serverPlayer.gameMode.destroyBlock(pos);
                    HARVESTED_BLOCKS.remove(pos);
                }
            }
        }
    }


    @SubscribeEvent
    public static void isShiftandRightClicked(PlayerInteractEvent.RightClickItem event){
        Player player = event.getEntity();
        ItemStack mainHandItem = player.getMainHandItem();



        if (event.getSide() != LogicalSide.SERVER) return;
//        long now = System.currentTimeMillis();
//        if (now - lastToggleTime < 200) return;
//        lastToggleTime = now;
        if (!(mainHandItem.getItem() instanceof OsPickaxeItem osPickaxe)) return;
        //if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (!(player.isShiftKeyDown())) return;

        DataComponentType<Boolean> component = ModDataComponent.OS_PICKAXE_MODE.get();
        boolean currentMode = mainHandItem.getOrDefault(component, false); //找问题用的
        OilSalt.LOGGER.info("Before toggle: currentMode = {}", currentMode);

        boolean newMode = !currentMode;
        mainHandItem.set(component,newMode);

        boolean afterSet = mainHandItem.getOrDefault(component, false); //找问题用的
        OilSalt.LOGGER.info("After set: afterSet = {}", afterSet);

        player.displayClientMessage(
                Component.literal((newMode ? "§a开启" : "§c关闭") + " 3×3 挖掘模式"),
                true
        );

        event.setCanceled(true);

    }

}
