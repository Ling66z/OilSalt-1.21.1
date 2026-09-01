package net.Lngltnat.OilSalt.item;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.NotNull;

public class ModElytraChestplateItem extends ArmorItem {
//ai写的
    public ModElytraChestplateItem(Holder<ArmorMaterial> material, Properties properties) {
        super(material, Type.CHESTPLATE, properties);
    }

    @Override
    public boolean canElytraFly(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return true;
    }

    @Override
    public boolean elytraFlightTick(@NotNull ItemStack stack, LivingEntity entity, int flightTicks) {
        if (!entity.level().isClientSide) {
            if (flightTicks % 10 == 0) {
                if (flightTicks % 20 == 0) {
                    stack.hurtAndBreak(1, entity, EquipmentSlot.CHEST);
                }
                entity.gameEvent(GameEvent.ELYTRA_GLIDE);
            }
        }
        // 如果物品已损坏（耐久归零），返回 false 停止滑翔
        return !stack.isEmpty();
    }
}