package net.Lngltnat.OilSalt.item;

import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OilSalt.MODID);


    public static final Supplier<CreativeModeTab> OILSALT_TAB = CREATIVE_MODE_TAB.register("oilsalt_tab",
            ()-> CreativeModeTab.builder().icon( ()-> new ItemStack(ModItems.OS_INGOT.get()))
                    .title(Component.translatable("creativetab.oilsalt.tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.OS_INGOT);
                        output.accept(ModItems.SHIT);
                        output.accept(ModItems.RAW_OS);
                        output.accept(ModBlocks.OS_BLOCK);
                        output.accept(ModBlocks.DEEPSLATE_OS_ORE);
                        output.accept(ModBlocks.RAW_OS_BLOCK);
                        output.accept(ModBlocks.OS_ORE);
                        output.accept(ModItems.WANGRANSPEAKER);
                        output.accept(ModItems.BAR_HOP_MUSIC_DISC);
                        output.accept(ModItems.SHRIMP);
                        output.accept(ModItems.BOOM_FOOD);
                        output.accept(ModBlocks.OS_STAIRS);
                        output.accept(ModBlocks.OS_DOOR);
                        output.accept(ModBlocks.OS_SLAB);
                        output.accept(ModBlocks.OS_TRAPDOOR);
                        output.accept(ModItems.OS_HOE);
                        output.accept(ModItems.OS_SWORD);
                        output.accept(ModItems.OS_AXE);
                        output.accept(ModItems.OS_PICKAXE);
                        output.accept(ModItems.OS_SHOVEL);
                        output.accept(ModItems.OS_UPGRADE_SMITHING_TEMPLATE);
                    }).build() );

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }



}
