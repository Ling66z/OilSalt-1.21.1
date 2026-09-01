package net.Lngltnat.OilSalt.item;

import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.item.custom.*;
import net.Lngltnat.OilSalt.sound.ModSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

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
                public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, @NotNull List<Component> tooltipComponents, @NotNull TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.oilsaltmod.shrimp.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> BOOM_FOOD = ITEMS.register("boom_food",
            () -> new BoomFoodItem(new Item.Properties().food(ModFoodProperties.BOOM_FOOD)));

    public static final DeferredItem<SwordItem> OS_SWORD = ITEMS.register("os_sword",
            () -> new SwordItem(ModToolTiers.OS, new Item.Properties()
                    .fireResistant()
                    .attributes(SwordItem.createAttributes(ModToolTiers.OS, 4, -2.4F))));

    public static final DeferredItem<OsPickaxeItem> OS_PICKAXE = ITEMS.register("os_pickaxe",
            () -> new OsPickaxeItem(ModToolTiers.OS, new Item.Properties()
                    .fireResistant()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.OS, 1.1F, -2.8F))));

    public static final DeferredItem<OsShovelItem> OS_SHOVEL = ITEMS.register("os_shovel",
            () -> new OsShovelItem(ModToolTiers.OS, new Item.Properties()
                    .fireResistant()
                    .attributes(ShovelItem.createAttributes(ModToolTiers.OS, 1.6F, -3.0F))));

    public static final DeferredItem<HoeItem> OS_HOE = ITEMS.register("os_hoe",
            () -> new HoeItem(ModToolTiers.OS, new Item.Properties()
                    .fireResistant()
                    .attributes(HoeItem.createAttributes(ModToolTiers.OS, -3.9F, -0.0F))));

    public static final DeferredItem<OsAxeItem> OS_AXE = ITEMS.register("os_axe",
            () -> new OsAxeItem(ModToolTiers.OS, new Item.Properties()
                    .fireResistant()
                    .attributes(AxeItem.createAttributes(ModToolTiers.OS, 6.0F, -3.0F))));




    private static final Component appliesTo = Component.translatable("item.oilsaltmod.os_upgrade_smithing_template.applies_to");
    private static final Component ingredients = Component.translatable("item.oilsaltmod.os_upgrade_smithing_template.ingredients");
    private static final Component upgradeDescription = Component.translatable("item.oilsaltmod.os_upgrade_smithing_template.new");
    private static final Component baseSlotDescription = Component.translatable("item.oilsaltmod.os_upgrade_smithing_template.base_slot_description");
    private static final Component additionsSlotDescription = Component.translatable("item.oilsaltmod.os_upgrade_smithing_template.additions_slot_description");

    public static final DeferredItem<SmithingTemplateItem> OS_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("os_upgrade_smithing_template",
            () -> new SmithingTemplateItem(appliesTo, ingredients, upgradeDescription, baseSlotDescription, additionsSlotDescription, createOsBaseSlotIcons(), createOsAdditionalSlotIcons()));

    public static final DeferredItem<ArmorItem> OS_HELMET = ITEMS.register("os_helmet",
            () -> new ArmorItem(ModArmorMaterials.OS_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(40))
                            .fireResistant()));

    public static final DeferredItem<ArmorItem> OS_CHESTPLATE = ITEMS.register("os_chestplate",
            () -> new ArmorItem(ModArmorMaterials.OS_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))
                            .fireResistant()));

    public static final DeferredItem<ArmorItem> OS_LEGGINGS = ITEMS.register("os_leggings",
            () -> new ArmorItem(ModArmorMaterials.OS_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(40))
                            .fireResistant()));

    public static final DeferredItem<ArmorItem> OS_BOOTS = ITEMS.register("os_boots",
            () -> new ArmorItem(ModArmorMaterials.OS_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(40))
                            .fireResistant()));

    public static final DeferredItem<ModElytraChestplateItem> OS_CHESTPLATE_ELYTRA = ITEMS.register("os_chestplate_elytra",
            () -> new ModElytraChestplateItem(ModArmorMaterials.OS_ARMOR_MATERIAL,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(40))
                            .fireResistant()));


    //        NETHERITE_SWORD = registerItem((String)"netherite_sword", new SwordItem(Tiers.NETHERITE, (new Item.Properties()).fireResistant().attributes(SwordItem.createAttributes(Tiers.NETHERITE, 3, -2.4F))));
    //        NETHERITE_SHOVEL = registerItem((String)"netherite_shovel", new ShovelItem(Tiers.NETHERITE, (new Item.Properties()).fireResistant().attributes(ShovelItem.createAttributes(Tiers.NETHERITE, 1.5F, -3.0F))));
    //        NETHERITE_PICKAXE = registerItem((String)"netherite_pickaxe", new PickaxeItem(Tiers.NETHERITE, (new Item.Properties()).fireResistant().attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 1.0F, -2.8F))));
    //        NETHERITE_AXE = registerItem((String)"netherite_axe", new AxeItem(Tiers.NETHERITE, (new Item.Properties()).fireResistant().attributes(AxeItem.createAttributes(Tiers.NETHERITE, 5.0F, -3.0F))));
    //        NETHERITE_HOE = registerItem((String)"netherite_hoe", new HoeItem(Tiers.NETHERITE, (new Item.Properties()).fireResistant().attributes(HoeItem.createAttributes(Tiers.NETHERITE, -4.0F, 0.0F))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }


    private static List<ResourceLocation> createOsBaseSlotIcons() {
        return List.of(
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_helmet"),
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_chestplate"),
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_leggings"),
                ResourceLocation.withDefaultNamespace("item/empty_armor_slot_boots"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_hoe"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_axe"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_sword"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_shovel"),
                ResourceLocation.withDefaultNamespace("item/empty_slot_pickaxe")
        );
    }


    private static List<ResourceLocation> createOsAdditionalSlotIcons() {
        return List.of(
                ResourceLocation.withDefaultNamespace("item/empty_slot_ingot")
        );
    }
}
