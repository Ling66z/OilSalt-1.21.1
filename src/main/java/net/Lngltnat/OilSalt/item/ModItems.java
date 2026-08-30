package net.Lngltnat.OilSalt.item;

import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.item.custom.BoomFoodItem;
import net.Lngltnat.OilSalt.item.custom.WangRanSpeakerItem;
import net.Lngltnat.OilSalt.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(OilSalt.MODID);

    public static final DeferredItem<Item> SHIT = ITEMS.register("shit",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> OS_INGOT = ITEMS.register("os_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_OS = ITEMS.register("raw_os",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> WANGRANSPEAKER = ITEMS.register("wangran_speaker",
            () -> new WangRanSpeakerItem(new Item.Properties().durability(64)));

    public static final DeferredItem<Item> BAR_HOP_MUSIC_DISC = ITEMS.register("bar_hop_music_disc",
            () -> new Item(new Item.Properties().jukeboxPlayable(ModSounds.BAR_HOP_KEY).stacksTo(1)));

    public static final DeferredItem<Item> SHRIMP = ITEMS.register("shrimp",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SHRIMP)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.oilsaltmod.shrimp.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> BOOM_FOOD = ITEMS.register("boom_food",
            () -> new BoomFoodItem(new Item.Properties().food(ModFoodProperties.BOOM_FOOD)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
