package net.Lngltnat.OilSalt.item.custom;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

import java.util.Map;
import java.util.WeakHashMap;

public class ShitItem extends Item {
    /** 上一 tick 的竖直速度，只服务端用；弱键，物品实体没了自动回收 */
    private static final Map<ItemEntity, Double> LAST_VY = new WeakHashMap<>();

    private static final double RESTITUTION = 0.8;   // 粘液块对物品就是这个值
    private static final double MIN_SPEED = 0.08;
    private static final double SOUND_SPEED = 0.15; // 低于这个速度不再弹，否则会抖

    public ShitItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        // 客户端不参与物理，只让服务端算
        if (entity.level().isClientSide) {
            return false;
        }

        Vec3 v = entity.getDeltaMovement();
        // 先把这一 tick 的速度存进去，拿回来的是上一 tick 的值
        Double prev = LAST_VY.put(entity, v.y);

        if (entity.onGround() && prev != null && prev < -MIN_SPEED) {
            entity.setDeltaMovement(v.x, -prev * RESTITUTION, v.z);
            entity.hasImpulse = true;   // 让客户端收到运动更新，不然会一顿一顿

            if (-prev > SOUND_SPEED) {
                entity.level().playSound(null, entity.blockPosition(),
                        SoundEvents.SLIME_BLOCK_FALL, SoundSource.BLOCKS,
                        0.6F, 1.4F);
            }
        }

        return false;   // 继续走原版 tick
    }
}