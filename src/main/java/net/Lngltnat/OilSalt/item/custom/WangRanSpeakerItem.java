package net.Lngltnat.OilSalt.item.custom;

import net.Lngltnat.OilSalt.sound.ModSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class WangRanSpeakerItem extends Item {

    public WangRanSpeakerItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        if (!level.isClientSide) {
            // 播放声音
            level.playSound(
                    null,
                    player.getX(), player.getY(), player.getZ(),
                    ModSounds.WANGRANSPEAKER_USE.get(),
                    SoundSource.PLAYERS,
                    1.0F,
                    1.0F
            );

            // 消耗耐久并正确触发破碎动画
            ItemStack stack = player.getItemInHand(usedHand);
            EquipmentSlot slot = usedHand == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND;
            stack.hurtAndBreak(1, (ServerLevel) level, player, item -> player.onEquippedItemBroken(item, slot));
        }

        return InteractionResultHolder.success(player.getItemInHand(usedHand));
    }
}