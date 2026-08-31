package net.Lngltnat.OilSalt.item.custom;

import net.Lngltnat.OilSalt.component.ModDataComponent;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class OsPickaxeItem extends OsToolItem{


    public OsPickaxeItem(Tier tier, Properties properties) {
        super(tier, BlockTags.MINEABLE_WITH_PICKAXE,properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
        if (Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.oilsaltmod.os_pickaxe.shift_down"));
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



//    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, ServerPlayer player) {
//        List<BlockPos> positions = new ArrayList<>();
//
//        BlockHitResult traceResult = player.level().clip(new ClipContext(player.getEyePosition(1f),
//                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
//                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
//        if (traceResult.getType() == HitResult.Type.MISS) {
//            return positions;
//        }
//
//        if (traceResult.getDirection() == Direction.DOWN || traceResult.getDirection() == Direction.UP) {
//            for (int x = -range; x <= range; x++) {
//                for (int y = -range; y <= range; y++) {
//                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y));
//                }
//            }
//        }
//
//        if (traceResult.getDirection() == Direction.NORTH || traceResult.getDirection() == Direction.SOUTH) {
//            for (int x = -range; x <= range; x++) {
//                for (int y = -range; y <= range; y++) {
//                    positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ()));
//                }
//            }
//        }
//
//        if (traceResult.getDirection() == Direction.EAST || traceResult.getDirection() == Direction.WEST) {
//            for (int x = -range; x <= range; x++) {
//                for (int y = -range; y <= range; y++) {
//                    positions.add(new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
//                }
//            }
//        }
//
//        return positions;
//    }
}
