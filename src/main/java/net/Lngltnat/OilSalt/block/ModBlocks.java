package net.Lngltnat.OilSalt.block;

import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(OilSalt.MODID);

    public static final DeferredBlock<Block> OS_BLOCK = registerBlock("os_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 6.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_GREEN)
            ));

    public static final DeferredBlock<Block> OS_ORE = registerBlock("os_ore",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(3.0F, 3.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)
                    .mapColor(MapColor.STONE)
            ));

    public static final DeferredBlock<Block> DEEPSLATE_OS_ORE = registerBlock("deepslate_os_ore",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 6.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)
                    .mapColor(MapColor.DEEPSLATE)
            ));

    public static final DeferredBlock<Block> RAW_OS_BLOCK = registerBlock("raw_os_block",
            ()-> new Block(BlockBehaviour.Properties.of()
                    .strength(5.0F, 6.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.METAL)
                    .mapColor(MapColor.COLOR_GREEN)
            ));

    public static final DeferredBlock<StairBlock> OS_STAIRS = registerBlock("os_stairs",
            () -> new StairBlock(ModBlocks.OS_BLOCK.get().defaultBlockState(),
            BlockBehaviour.Properties.of()
                    .strength(5.0f,6.0f)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<SlabBlock> OS_SLAB = registerBlock("os_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                            .strength(5.0f,6.0f)
                            .requiresCorrectToolForDrops()));

    public static final DeferredBlock<DoorBlock> OS_DOOR = registerBlock("os_door",
            () -> new DoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of()
                            .strength(5.0f,6.0f)
                            .requiresCorrectToolForDrops()
                            ));

    public static final DeferredBlock<TrapDoorBlock> OS_TRAPDOOR = registerBlock("os_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.IRON,
                    BlockBehaviour.Properties.of()
                            .strength(5.0f,6.0f)
                            .requiresCorrectToolForDrops()
                            .noOcclusion()
                            ));



    //DIAMOND_ORE = register((String)"diamond_ore", new DropExperienceBlock(UniformInt.of(3, 7), Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
    //        DEEPSLATE_DIAMOND_ORE = register((String)"deepslate_diamond_ore", new DropExperienceBlock(UniformInt.of(3, 7), Properties.ofLegacyCopy(DIAMOND_ORE).mapColor(MapColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
    //        DIAMOND_BLOCK = register("diamond_block", new Block(Properties.of().mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    //new Block(Properties.of().mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name,toReturn);
        return toReturn;
    }


    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name,()-> new BlockItem(block.get(),new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
