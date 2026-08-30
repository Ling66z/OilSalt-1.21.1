package net.Lngltnat.OilSalt.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import java.util.List;

public class BoomFoodItem extends Item {

    public BoomFoodItem(Properties properties) {
        super(properties);
    }


    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {

        if(!level.isClientSide()){
            level.explode(null,livingEntity.getX(),livingEntity.getY(),livingEntity.getZ(),3.0F,false, Level.ExplosionInteraction.BLOCK.NONE);
        }

        return super.finishUsingItem(stack, level, livingEntity);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.oilsaltmod.boom_food.tooltip"));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
