package net.Lngltnat.OilSalt.event;


import net.Lngltnat.OilSalt.OilSalt;

import net.Lngltnat.OilSalt.component.ModDataComponents;
import net.Lngltnat.OilSalt.item.custom.ModElytraChestplateItem;
import net.Lngltnat.OilSalt.item.custom.OsToolItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ServerChatEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.level.BlockEvent;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

@EventBusSubscriber(modid = OilSalt.MODID)
public class ModEvents {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();
    private static long lastToggleTime = 0;
    private static long sleepTime = 0;

    @SubscribeEvent
    public static void onOsToolDestroyed(BlockEvent.@NotNull BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();
        boolean mode = mainHandItem.getOrDefault(ModDataComponents.OS_TOOL_MODE.get(), false);

        if (mode) {
            if (mainHandItem.getItem() instanceof OsToolItem osToolItem && player instanceof ServerPlayer serverPlayer) {
                BlockPos initialBlockPos = event.getPos();
                if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                    return;
                }

                for (BlockPos pos : OsToolItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                    if (pos.equals(initialBlockPos) || !osToolItem.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
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
    public static void isShiftandRightClickedTool(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack mainHandItem = player.getMainHandItem();


        if (event.getSide() != LogicalSide.SERVER) return;
//        long now = System.currentTimeMillis();
//        if (now - lastToggleTime < 200) return;
//        lastToggleTime = now;
        if (!(mainHandItem.getItem() instanceof OsToolItem osToolItem)) return;
        //if (!(player instanceof ServerPlayer serverPlayer)) return;
        if (!(player.isShiftKeyDown())) return;

        DataComponentType<Boolean> component = ModDataComponents.OS_TOOL_MODE.get();
        boolean currentMode = mainHandItem.getOrDefault(component, false);
//        OilSalt.LOGGER.info("Before toggle: currentMode = {}", currentMode); //找问题用的

        boolean newMode = !currentMode;
        mainHandItem.set(component, newMode);

//        boolean afterSet = mainHandItem.getOrDefault(component, false); //找问题用的
//        OilSalt.LOGGER.info("After set: afterSet = {}", afterSet);

        if (newMode) {
            player.displayClientMessage(
                    Component.translatable("message.oilsaltmod.3x3_mode.enabled"),
                    true
            );
        } else {
            player.displayClientMessage(
                    Component.translatable("message.oilsaltmod.3x3_mode.disabled"),
                    true
            );
        }

        event.setCanceled(true);

    }

    @SubscribeEvent
    public static void isShiftandRightClickedArmor(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getEntity();
        ItemStack mainHandItem = player.getMainHandItem();


        if (!(mainHandItem.getItem() instanceof ModElytraChestplateItem modElytraChestplateItem)) return;
        if (!(player.isShiftKeyDown())) return;
        event.setCanceled(true);
        if (event.getSide() != LogicalSide.SERVER) return;
        DataComponentType<Boolean> component = ModDataComponents.OS_ARMOR_MODE.get();
        boolean currentMode = mainHandItem.getOrDefault(component, true);
        boolean newMode = !currentMode;
        mainHandItem.set(component, newMode);

        if (newMode) {
            player.displayClientMessage(
                    Component.translatable("message.oilsaltmod.flymode.enabled"),
                    true
            );
        } else {
            player.displayClientMessage(
                    Component.translatable("message.oilsaltmod.flymode.disabled"),
                    true
            );
        }

//        player.displayClientMessage(
//                Component.literal((newMode ? "message.oilsaltmod.flymode.enabled" : "message.oilsaltmod.flymode.disabled")),
//                true
//        );
    }







    @SubscribeEvent
    public static void isSayRobloxBigCock(ServerChatEvent event){
        Player player = event.getPlayer();
        String rawtext = event.getRawText();
        String RobloxBigCock = ".*罗布乐思大鸡鸡.*";
        Level level = player.level();
        boolean isMatch = Pattern.matches(RobloxBigCock, rawtext);
        if(isMatch){
            player.sendSystemMessage(Component.literal(player.getName().getString() + "不许说这种话，快点道歉！"));
            if (!level.isClientSide()) {
                LightningBolt lightning = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
                lightning.setPos(player.getX(), player.getY(), player.getZ());
                lightning.setDamage(114514f);
                level.addFreshEntity(lightning);
            }
            //player.kill();
        }
    }
//    @SubscribeEvent
//    public static void onCanSleep(CanPlayerSleepEvent event) {
//        Player player = event.getEntity();
//        if (!(player instanceof ServerPlayer)) return;
//
//        // 有饭后嗜睡效果 → 允许睡
//        if (player.hasEffect(ModEffects.POSTPRANDIAL_SOMNOLENCE_EFFECT)) {
//            event.setProblem(null); // 这行就够了！
//        }
//    }
//@SubscribeEvent
//public static void onRightClickBed(PlayerInteractEvent.RightClickBlock event) {
//    // 1. 只在服务端执行
//    if (event.getLevel().isClientSide()) return;
//
//    Player player = event.getEntity();
//    if (!(player instanceof ServerPlayer serverPlayer)) return;
//
//    // 2. 检查是否点击了床
//    BlockState state = event.getLevel().getBlockState(event.getPos());
//    if (!(state.getBlock() instanceof BedBlock)) return;
//
//    // 3. 检查是否有饭后嗜睡效果
//    if (!player.hasEffect(ModEffects.POSTPRANDIAL_SOMNOLENCE_EFFECT)) return;
//
//    // 4. 取消原版交互，防止重复处理
//    event.setCanceled(true);
//
//
//
//    // 5. 强制玩家躺下（官方方法，不会递归）
//    player.startSleepInBed(event.getPos()).ifLeft(p_49477_ -> {
//        if (p_49477_.getMessage() != null) {
//            player.displayClientMessage(p_49477_.getMessage(), true);
//        }
//    });
//
//
//    // 7. 可选提示
//    //serverPlayer.displayClientMessage(Component.literal("你直接睡着了，醒来已是午夜"), true);
//}
//
//public static void SleepFinishedTime (SleepFinishedTimeEvent event){
//
//}





}
