package net.Lngltnat.OilSalt.datagen;

import net.Lngltnat.OilSalt.OilSalt;
import net.Lngltnat.OilSalt.block.ModBlocks;
import net.Lngltnat.OilSalt.item.ModItems;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        List<ItemLike> OS_SMELTABLES = List.of(ModItems.RAW_OS,
                ModBlocks.OS_ORE,
                ModBlocks.DEEPSLATE_OS_ORE);

        List<ItemLike> OS_SMELTABLES2 = List.of(ModBlocks.RAW_OS_BLOCK);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OS_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.OS_INGOT.get())
                .unlockedBy("has_os",has(ModItems.OS_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_OS_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.RAW_OS.get())
                .unlockedBy("has_raw_os",has(ModItems.RAW_OS))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.OS_INGOT.get(),9)
                .requires(ModBlocks.OS_BLOCK)
                .unlockedBy("has_os_block",has(ModBlocks.OS_BLOCK))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,ModItems.RAW_OS.get(),9)
                .requires(ModBlocks.RAW_OS_BLOCK)
                .unlockedBy("has_raw_os_block",has(ModBlocks.RAW_OS_BLOCK))
                .save(recipeOutput);

        poreSmelting(recipeOutput,OS_SMELTABLES,RecipeCategory.MISC,ModItems.OS_INGOT,0.25f,200,"os_ingot");
        poreBlasting(recipeOutput,OS_SMELTABLES,RecipeCategory.MISC,ModItems.OS_INGOT,0.25f,100,"os_ingot");
        poreSmelting(recipeOutput,OS_SMELTABLES2,RecipeCategory.MISC,ModBlocks.OS_BLOCK,0.25f,200,"os_block");
        poreBlasting(recipeOutput,OS_SMELTABLES2,RecipeCategory.MISC,ModBlocks.OS_BLOCK,0.25f,100,"os_block");

        stairBuilder(ModBlocks.OS_STAIRS.get(),Ingredient.of(ModItems.OS_INGOT))
                .group("os_ingot")
                .unlockedBy("has_os_ingot",has(ModItems.OS_INGOT)).save(recipeOutput);

        slab(recipeOutput,RecipeCategory.BUILDING_BLOCKS,ModBlocks.OS_SLAB.get(),ModItems.OS_INGOT.get());

        doorBuilder(ModBlocks.OS_DOOR.get(),Ingredient.of(ModItems.OS_INGOT))
                .group("os_ingot")
                .unlockedBy("has_os_ingot",has(ModItems.OS_INGOT)).save(recipeOutput);

        trapdoorBuilder(ModBlocks.OS_TRAPDOOR.get(),Ingredient.of(ModItems.OS_INGOT))
                .group("os_ingot")
                .unlockedBy("has_os_ingot",has(ModItems.OS_INGOT)).save(recipeOutput);

        osSmithing(recipeOutput,Items.NETHERITE_AXE,RecipeCategory.TOOLS,ModItems.OS_AXE.get());
        osSmithing(recipeOutput,Items.NETHERITE_PICKAXE,RecipeCategory.TOOLS,ModItems.OS_PICKAXE.get());
        osSmithing(recipeOutput,Items.NETHERITE_HOE,RecipeCategory.TOOLS,ModItems.OS_HOE.get());
        osSmithing(recipeOutput,Items.NETHERITE_SWORD,RecipeCategory.TOOLS,ModItems.OS_SWORD.get());
        osSmithing(recipeOutput,Items.NETHERITE_SHOVEL,RecipeCategory.TOOLS,ModItems.OS_SHOVEL.get());





    }

    protected static void poreSmelting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
        poreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, ingredients, category, result, experience, cookingTime, group, "_from_smelting");
    }

    protected static void poreBlasting(RecipeOutput recipeOutput, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
        poreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, ingredients, category, result, experience, cookingTime, group, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void poreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> serializer, AbstractCookingRecipe.Factory<T> recipeFactory, List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group, String suffix) {
        Iterator iterator = ingredients.iterator();

        while(iterator.hasNext()) {
            ItemLike itemlike = (ItemLike)iterator.next();
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), category, result, experience, cookingTime, serializer, recipeFactory).group(group).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, OilSalt.MODID + ":" + getItemName(result) + suffix + "_" + getItemName(itemlike));
        }

    }

    protected static void osSmithing(RecipeOutput recipeOutput, Item ingredientItem, RecipeCategory category, Item resultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(new ItemLike[]{ModItems.OS_UPGRADE_SMITHING_TEMPLATE.get()}), Ingredient.of(new ItemLike[]{ingredientItem}), Ingredient.of(new ItemLike[]{ModItems.OS_INGOT.get()}), category, resultItem).unlocks("has_os_ingot", has((ItemLike)ModItems.OS_INGOT.get()))
                .save(recipeOutput, OilSalt.MODID + ":" + getItemName(resultItem) + "_smithing");
    }


}
