package net.Lngltnat.OilSalt.item.custom;

import net.Lngltnat.OilSalt.component.ModDataComponent;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class OsShovelItem extends OsToolItem {
    public OsShovelItem(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_SHOVEL, properties);
    }

    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.oilsaltmod.os_shovel.shift_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.oilsaltmod.shift_up"));
        }
        boolean mode = stack.getOrDefault(ModDataComponent.OS_TOOL_MODE.get(), false);
        if (mode) {
            tooltipComponents.add(Component.translatable("tooltip.oilsaltmod.3x3mode.on"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.oilsaltmod.3x3mode.off"));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }



}
