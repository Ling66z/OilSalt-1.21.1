package net.Lngltnat.OilSalt.item.custom;

import net.Lngltnat.OilSalt.item.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class CornucopiaItem extends Item {
    public CornucopiaItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull ItemStack finishUsingItem(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity livingEntity) {
        int slotIndex = -1;
        if (livingEntity instanceof Player player) {
            for (int i = 0; i < 9; i++) {
                // 使用物品的副本进行比对（因为stack可能即将被修改）
                if (ItemStack.isSameItemSameComponents(player.getInventory().getItem(i), stack)) {
                    slotIndex = i;
                    break;
                }
            }
        }
        ItemStack result = super.finishUsingItem(stack, level, livingEntity);


        if(livingEntity instanceof Player player && !player.isCreative()){
            player.getInventory().add(slotIndex,ModItems.CORNUCOPIA.toStack());
        }
        return result;
    }
}
