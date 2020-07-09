package com.ldshadowlady.things.data;

import com.google.common.collect.ImmutableList;
import com.ldshadowlady.things.blocks.ThingsBlocks;
import com.ldshadowlady.things.items.ThingsBlockItem;
import com.ldshadowlady.things.items.ThingsItems;
import com.mojang.datafixers.util.Pair;
import net.minecraft.advancements.Advancement;
import net.minecraft.block.Block;
import net.minecraft.data.*;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.item.Items;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ThingsData {
    public static void register(IEventBus event) {
        event.<GatherDataEvent>addListener(e -> {
            e.getGenerator().addProvider(new ThingsRecipeProvider(e.getGenerator()));
            e.getGenerator().addProvider(new ThingsLootTableProvider(e.getGenerator()));
            e.getGenerator().addProvider(new ThingsAdvancementProvider(e.getGenerator()));
        });
    }

    static class ThingsRecipeProvider extends RecipeProvider {
        public ThingsRecipeProvider(DataGenerator generator) {
            super(generator);
        }

        @Override
        protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.COWBELL))
                .patternLine("#")
                .patternLine("X")
                .key('#', Items.STICK)
                .key('X', Items.GOLD_INGOT)
                .addCriterion("has_gold_ingot", this.hasItem(Items.GOLD_INGOT))
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.KEYBOARD))
                .patternLine("##")
                .patternLine("$R")
                .key('#', Items.NOTE_BLOCK)
                .key('$', ItemTags.PLANKS)
                .key('R', Items.REDSTONE)
                .addCriterion("has_redstone", this.hasItem(Items.REDSTONE))
                .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.RED_CELEBRATION_VASE_TALL))
                    .patternLine("CGC")
                    .patternLine("CRC")
                    .patternLine("CCC")
                    .key('C', Items.CLAY_BALL)
                    .key('R', Items.RED_DYE)
                    .key('G', Items.GOLD_NUGGET)
                    .addCriterion("has_gold_nugget", this.hasItem(Items.GOLD_NUGGET))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.RED_CELEBRATION_VASE_SHORT))
                    .patternLine(" G ")
                    .patternLine("CRC")
                    .patternLine("CCC")
                    .key('C', Items.CLAY_BALL)
                    .key('R', Items.RED_DYE)
                    .key('G', Items.GOLD_NUGGET)
                    .addCriterion("has_gold_nugget", this.hasItem(Items.GOLD_NUGGET))
                    .build(consumer);
            ShapelessRecipeBuilder.shapelessRecipe(get(ThingsItems.RED_CELEBRATION_VASE_DOUBLE))
                    .addIngredient(get(ThingsItems.RED_CELEBRATION_VASE_SHORT))
                    .addIngredient(get(ThingsItems.RED_CELEBRATION_VASE_TALL))
                    .addCriterion("has_one_vase", this.hasItem((get(ThingsItems.RED_CELEBRATION_VASE_SHORT))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BLUE_CHINA_VASE_TALL))
                    .patternLine("CGC")
                    .patternLine("CRC")
                    .patternLine("CCC")
                    .key('C', Items.CLAY_BALL)
                    .key('R', Items.BLUE_DYE)
                    .key('G', Items.WHITE_DYE)
                    .addCriterion("has_white_dye", this.hasItem(Items.WHITE_DYE))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BLUE_CHINA_VASE_SHORT))
                    .patternLine(" G ")
                    .patternLine("CRC")
                    .patternLine("CCC")
                    .key('C', Items.CLAY_BALL)
                    .key('R', Items.BLUE_DYE)
                    .key('G', Items.WHITE_DYE)
                    .addCriterion("has_white_dye", this.hasItem(Items.WHITE_DYE))
                    .build(consumer);
            ShapelessRecipeBuilder.shapelessRecipe(get(ThingsItems.BLUE_CHINA_VASE_DOUBLE))
                    .addIngredient(get(ThingsItems.BLUE_CHINA_VASE_SHORT))
                    .addIngredient(get(ThingsItems.BLUE_CHINA_VASE_TALL))
                    .addCriterion("has_one_vase", this.hasItem((get(ThingsItems.BLUE_CHINA_VASE_SHORT))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GRAVESTONE_MOON))
                    .patternLine("SSS")
                    .patternLine("SIS")
                    .patternLine("BBB")
                    .key('S', Items.STONE)
                    .key('I', Items.CLOCK)
                    .key('B', Items.BRICK_SLAB)
                    .addCriterion("has_clock", this.hasItem(Items.CLOCK))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GRAVESTONE_SKULL))
                    .patternLine("SSS")
                    .patternLine("SIS")
                    .patternLine("BBB")
                    .key('S', Items.STONE)
                    .key('I', Items.SKELETON_SKULL)
                    .key('B', Items.BRICK_SLAB)
                    .addCriterion("has_skeleton_skull", this.hasItem(Items.SKELETON_SKULL))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GRAVESTONE_HEART))
                    .patternLine("SSS")
                    .patternLine("SIS")
                    .patternLine("BBB")
                    .key('S', Items.STONE)
                    .key('I', Items.OXEYE_DAISY)
                    .key('B', Items.BRICK_SLAB)
                    .addCriterion("has_oxeye_daisy", this.hasItem(Items.OXEYE_DAISY))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.WOODEN_WINDOW_BOX_TULIP))
                    .patternLine("WRP")
                    .patternLine("SDS")
                    .patternLine("SSS")
                    .key('S', Items.OAK_SLAB)
                    .key('D', Items.DIRT)
                    .key('W', Items.WHITE_TULIP)
                    .key('R', Items.RED_TULIP)
                    .key('P', Items.PINK_TULIP)
                    .addCriterion("has_pink_tulip", this.hasItem(Items.PINK_TULIP))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.WHITE_WOODEN_WINDOW_BOX_TULIP))
                    .patternLine("DBD")
                    .patternLine("DDD")
                    .key('B', get(ThingsItems.WOODEN_WINDOW_BOX_TULIP))
                    .key('D', Items.WHITE_DYE)
                    .addCriterion("has_wooden_window_box", this.hasItem((get(ThingsItems.WOODEN_WINDOW_BOX_TULIP))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BLUE_WOODEN_WINDOW_BOX_TULIP))
                    .patternLine("DBD")
                    .patternLine("DDD")
                    .key('B', get(ThingsItems.WOODEN_WINDOW_BOX_TULIP))
                    .key('D', Items.LIGHT_BLUE_DYE)
                    .addCriterion("has_wooden_window_box", this.hasItem((get(ThingsItems.WOODEN_WINDOW_BOX_TULIP))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.PINK_WOODEN_WINDOW_BOX_TULIP))
                    .patternLine("DBD")
                    .patternLine("DDD")
                    .key('B', get(ThingsItems.WOODEN_WINDOW_BOX_TULIP))
                    .key('D', Items.PINK_DYE)
                    .addCriterion("has_wooden_window_box", this.hasItem((get(ThingsItems.WOODEN_WINDOW_BOX_TULIP))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.YELLOW_WOODEN_WINDOW_BOX_TULIP))
                    .patternLine("DBD")
                    .patternLine("DDD")
                    .key('B', get(ThingsItems.WOODEN_WINDOW_BOX_TULIP))
                    .key('D', Items.YELLOW_DYE)
                    .addCriterion("has_wooden_window_box", this.hasItem((get(ThingsItems.WOODEN_WINDOW_BOX_TULIP))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GLOBE_IRON))
                    .patternLine("LBL")
                    .patternLine("BGB")
                    .patternLine("III")
                    .key('L', Items.LIME_DYE)
                    .key('B', Items.LIGHT_BLUE_DYE)
                    .key('G', Items.GLOWSTONE)
                    .key('I', Items.IRON_INGOT)
                    .addCriterion("has_glowstone", this.hasItem(Items.GLOWSTONE))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GLOBE_GOLD))
                    .patternLine("LBL")
                    .patternLine("BGB")
                    .patternLine("III")
                    .key('L', Items.LIME_DYE)
                    .key('B', Items.LIGHT_BLUE_DYE)
                    .key('G', Items.GLOWSTONE)
                    .key('I', Items.GOLD_INGOT)
                    .addCriterion("has_glowstone", this.hasItem(Items.GLOWSTONE))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GLOBE_ALT_IRON))
                    .patternLine("LBL")
                    .patternLine("BGB")
                    .patternLine("III")
                    .key('L', Items.PINK_DYE)
                    .key('B', Items.LIGHT_BLUE_DYE)
                    .key('G', Items.GLOWSTONE)
                    .key('I', Items.IRON_INGOT)
                    .addCriterion("has_glowstone", this.hasItem(Items.GLOWSTONE))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GLOBE_ALT_GOLD))
                    .patternLine("LBL")
                    .patternLine("BGB")
                    .patternLine("III")
                    .key('L', Items.PINK_DYE)
                    .key('B', Items.LIGHT_BLUE_DYE)
                    .key('G', Items.GLOWSTONE)
                    .key('I', Items.GOLD_INGOT)
                    .addCriterion("has_glowstone", this.hasItem(Items.GLOWSTONE))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.CRYSTAL_BALL_PURPLE))
                    .patternLine(" P ")
                    .patternLine("PGP")
                    .patternLine("III")
                    .key('P', Items.PURPLE_STAINED_GLASS_PANE)
                    .key('G', Items.GLOWSTONE_DUST)
                    .key('I', Items.GOLD_INGOT)
                    .addCriterion("has_glowstone", this.hasItem(Items.GLOWSTONE_DUST))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GIFT_TALL_RED))
                    .patternLine("YRY")
                    .patternLine("P P")
                    .patternLine("RPR")
                    .key('R', Items.RED_DYE)
                    .key('P', Items.PAPER)
                    .key('Y', Items.YELLOW_DYE)
                    .addCriterion("has_paper", this.hasItem(Items.PAPER))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GIFT_SQUARE_PURPLE))
                    .patternLine("YRY")
                    .patternLine("P P")
                    .patternLine("RPR")
                    .key('R', Items.PURPLE_DYE)
                    .key('P', Items.PAPER)
                    .key('Y', Items.LIGHT_BLUE_DYE)
                    .addCriterion("has_paper", this.hasItem(Items.PAPER))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GIFT_SQUARE_PINK))
                    .patternLine("YRY")
                    .patternLine("P P")
                    .patternLine("RPR")
                    .key('R', Items.PINK_DYE)
                    .key('P', Items.PAPER)
                    .key('Y', Items.WHITE_DYE)
                    .addCriterion("has_paper", this.hasItem(Items.PAPER))
                    .build(consumer);
            ShapelessRecipeBuilder.shapelessRecipe(get(ThingsItems.GIFT_DOUBLE_ONE))
                    .addIngredient(get(ThingsItems.GIFT_TALL_RED))
                    .addIngredient(get(ThingsItems.GIFT_SQUARE_PURPLE))
                    .addCriterion("has_one_gift", this.hasItem((get(ThingsItems.GIFT_TALL_RED))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.TV))
                    .patternLine("III")
                    .patternLine("IGI")
                    .patternLine("NRN")
                    .key('I', Items.IRON_INGOT)
                    .key('G', Items.GLASS_PANE)
                    .key('N', Items.GOLD_INGOT)
                    .key('R', Items.REDSTONE)
                    .addCriterion("has_redstone", this.hasItem(Items.REDSTONE))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.CYAN_TV))
                    .patternLine("CWC")
                    .patternLine("WTW")
                    .patternLine("CWC")
                    .key('C', Items.CYAN_DYE)
                    .key('W', Items.WHITE_DYE)
                    .key('T', get(ThingsItems.TV))
                    .addCriterion("has_tv", this.hasItem((get(ThingsItems.TV))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.PINK_TV))
                    .patternLine("WDW")
                    .patternLine("PTP")
                    .patternLine("WDW")
                    .key('D', Items.PINK_DYE)
                    .key('W', Items.WHITE_DYE)
                    .key('P', Items.PEONY)
                    .key('T', get(ThingsItems.TV))
                    .addCriterion("has_tv", this.hasItem((get(ThingsItems.TV))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.KEYBOARD_STAND))
                    .patternLine("IBI")
                    .patternLine("BIB")
                    .patternLine("IBI")
                    .key('I', Items.IRON_INGOT)
                    .key('B', Items.BLACK_DYE)
                    .addCriterion("has_keyboard", this.hasItem((get(ThingsItems.KEYBOARD))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.MUSHROOM_LAMP_RED))
                    .patternLine("MMM")
                    .patternLine("MGM")
                    .patternLine(" S ")
                    .key('M', Items.RED_MUSHROOM_BLOCK)
                    .key('G', Items.GLOWSTONE)
                    .key('S', Items.MUSHROOM_STEM)
                    .addCriterion("has_glowstone", this.hasItem(Items.GLOWSTONE))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.MAGENTA_DRUM))
                    .patternLine("LLL")
                    .patternLine("S S")
                    .patternLine("SMS")
                    .key('L', Items.LEATHER)
                    .key('S', Items.OAK_SLAB)
                    .key('M', Items.MAGENTA_DYE)
                    .addCriterion("has_leather", this.hasItem(Items.LEATHER))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.CYMBAL))
                    .patternLine("GGG")
                    .patternLine("BSB")
                    .patternLine(" S ")
                    .key('G', Items.GOLD_INGOT)
                    .key('B', Items.BLACK_DYE)
                    .key('S', Items.STICK)
                    .addCriterion("has_gold_ingot", this.hasItem(Items.GOLD_INGOT))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.CRASH_CYMBAL))
                    .patternLine(" GG")
                    .patternLine("BSG")
                    .patternLine("SB ")
                    .key('G', Items.GOLD_INGOT)
                    .key('B', Items.BLACK_DYE)
                    .key('S', Items.STICK)
                    .addCriterion("has_gold_ingot", this.hasItem(Items.GOLD_INGOT))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BIG_DRUM))
                    .patternLine("LLL")
                    .patternLine("S S")
                    .patternLine("SCS")
                    .key('L', Items.LEATHER)
                    .key('S', Items.OAK_SLAB)
                    .key('C', Items.CYAN_DYE)
                    .addCriterion("has_leather", this.hasItem(Items.LEATHER))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BOOK_MAGIC_UPRIGHT_SINGLE))
                    .patternLine("BD")
                    .key('B', Items.BOOK)
                    .key('D', Items.GREEN_DYE)
                    .addCriterion("has_book", this.hasItem(Items.BOOK))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BOOK_MAGIC_UPRIGHT_TRIO))
                    .patternLine("BBB")
                    .key('B', get(ThingsItems.BOOK_MAGIC_UPRIGHT_SINGLE))
                    .addCriterion("has_book", this.hasItem(get(ThingsItems.BOOK_MAGIC_UPRIGHT_SINGLE)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BOOK_MAGIC_UPRIGHT_FOUR))
                    .patternLine("TS")
                    .key('T', get(ThingsItems.BOOK_MAGIC_UPRIGHT_TRIO))
                    .key('S', get(ThingsItems.BOOK_MAGIC_UPRIGHT_SINGLE))
                    .addCriterion("has_book", this.hasItem(get(ThingsItems.BOOK_MAGIC_UPRIGHT_TRIO)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BOOK_UPRIGHT_SINGLE))
                    .patternLine("BD")
                    .key('B', Items.BOOK)
                    .key('D', Items.RED_DYE)
                    .addCriterion("has_book", this.hasItem(Items.BOOK))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BOOK_UPRIGHT_TRIO))
                    .patternLine("BBB")
                    .key('B', get(ThingsItems.BOOK_UPRIGHT_SINGLE))
                    .addCriterion("has_book", this.hasItem(get(ThingsItems.BOOK_UPRIGHT_SINGLE)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BOOK_UPRIGHT_FOUR))
                    .patternLine("TS")
                    .key('T', get(ThingsItems.BOOK_UPRIGHT_TRIO))
                    .key('S', get(ThingsItems.BOOK_UPRIGHT_SINGLE))
                    .addCriterion("has_book", this.hasItem(get(ThingsItems.BOOK_UPRIGHT_TRIO)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BOOK_LAID_SINGLE))
                    .patternLine("D")
                    .patternLine("B")
                    .key('B', Items.BOOK)
                    .key('D', Items.RED_DYE)
                    .addCriterion("has_book", this.hasItem(Items.BOOK))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BOOK_LAID_DOUBLE))
                    .patternLine("B")
                    .patternLine("B")
                    .key('B', get(ThingsItems.BOOK_LAID_SINGLE))
                    .addCriterion("has_book", this.hasItem(get(ThingsItems.BOOK_LAID_SINGLE)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BOOK_LAID_TRIPLE))
                    .patternLine("B")
                    .patternLine("B")
                    .patternLine("B")
                    .key('B', get(ThingsItems.BOOK_LAID_SINGLE))
                    .addCriterion("has_book", this.hasItem(get(ThingsItems.BOOK_LAID_SINGLE)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.PIRATE_SIGN))
                    .patternLine("SK")
                    .key('S', Items.OAK_SIGN)
                    .key('K', Items.SKELETON_SKULL)
                    .addCriterion("has_skeleton_skull", this.hasItem(Items.SKELETON_SKULL))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.WOODEN_CHAIR))
                    .patternLine("F  ")
                    .patternLine("SS ")
                    .patternLine("FF ")
                    .key('F', Items.OAK_FENCE)
                    .key('S', Items.OAK_SLAB)
                    .addCriterion("has_oak_slab", this.hasItem(Items.OAK_SLAB))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.CYAN_CHAIR))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_CHAIR))
                    .key('D', Items.CYAN_DYE)
                    .addCriterion("has_wooden_chair", this.hasItem((get(ThingsItems.WOODEN_CHAIR))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.PINK_CHAIR))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_CHAIR))
                    .key('D', Items.PINK_DYE)
                    .addCriterion("has_wooden_chair", this.hasItem((get(ThingsItems.WOODEN_CHAIR))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.LIGHT_BLUE_CHAIR))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_CHAIR))
                    .key('D', Items.LIGHT_BLUE_DYE)
                    .addCriterion("has_wooden_chair", this.hasItem((get(ThingsItems.WOODEN_CHAIR))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.PURPLE_CHAIR))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_CHAIR))
                    .key('D', Items.PURPLE_DYE)
                    .addCriterion("has_wooden_chair", this.hasItem((get(ThingsItems.WOODEN_CHAIR))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.WHITE_CHAIR))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_CHAIR))
                    .key('D', Items.WHITE_DYE)
                    .addCriterion("has_wooden_chair", this.hasItem((get(ThingsItems.WOODEN_CHAIR))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.YELLOW_CHAIR))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_CHAIR))
                    .key('D', Items.YELLOW_DYE)
                    .addCriterion("has_wooden_chair", this.hasItem((get(ThingsItems.WOODEN_CHAIR))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.HOT_PINK_CHAIR))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_CHAIR))
                    .key('D', Items.MAGENTA_DYE)
                    .addCriterion("has_wooden_chair", this.hasItem((get(ThingsItems.WOODEN_CHAIR))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GREEN_CHAIR))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_CHAIR))
                    .key('D', Items.GREEN_DYE)
                    .addCriterion("has_wooden_chair", this.hasItem((get(ThingsItems.WOODEN_CHAIR))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FROGGY_CHAIR))
                    .patternLine("DSD")
                    .patternLine("SCS")
                    .patternLine("DSD")
                    .key('C', get(ThingsItems.WOODEN_CHAIR))
                    .key('D', Items.LIME_DYE)
                    .key('S', Items.SLIME_BALL)
                    .addCriterion("has_wooden_chair", this.hasItem((get(ThingsItems.WOODEN_CHAIR))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.WOODEN_TABLE))
                    .patternLine("SPS")
                    .patternLine(" F ")
                    .patternLine(" F ")
                    .key('F', Items.OAK_FENCE)
                    .key('S', Items.OAK_SLAB)
                    .key('P', Items.OAK_PRESSURE_PLATE)
                    .addCriterion("has_oak_slab", this.hasItem(Items.OAK_SLAB))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.CYAN_TABLE))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_TABLE))
                    .key('D', Items.CYAN_DYE)
                    .addCriterion("has_wooden_table", this.hasItem((get(ThingsItems.WOODEN_TABLE))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.PINK_TABLE))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_TABLE))
                    .key('D', Items.PINK_DYE)
                    .addCriterion("has_wooden_table", this.hasItem((get(ThingsItems.WOODEN_TABLE))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.LIGHT_BLUE_TABLE))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_TABLE))
                    .key('D', Items.LIGHT_BLUE_DYE)
                    .addCriterion("has_wooden_table", this.hasItem((get(ThingsItems.WOODEN_TABLE))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.PURPLE_TABLE))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_TABLE))
                    .key('D', Items.PURPLE_DYE)
                    .addCriterion("has_wooden_table", this.hasItem((get(ThingsItems.WOODEN_TABLE))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.WHITE_TABLE))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_TABLE))
                    .key('D', Items.WHITE_DYE)
                    .addCriterion("has_wooden_table", this.hasItem((get(ThingsItems.WOODEN_TABLE))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.YELLOW_TABLE))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_TABLE))
                    .key('D', Items.YELLOW_DYE)
                    .addCriterion("has_wooden_table", this.hasItem((get(ThingsItems.WOODEN_TABLE))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.HOT_PINK_TABLE))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_TABLE))
                    .key('D', Items.MAGENTA_DYE)
                    .addCriterion("has_wooden_table", this.hasItem((get(ThingsItems.WOODEN_TABLE))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GREEN_TABLE))
                    .patternLine("DDD")
                    .patternLine("DCD")
                    .patternLine("DDD")
                    .key('C', get(ThingsItems.WOODEN_TABLE))
                    .key('D', Items.GREEN_DYE)
                    .addCriterion("has_wooden_table", this.hasItem((get(ThingsItems.WOODEN_TABLE))))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW))
                    .patternLine("GSG")
                    .patternLine("SSS")
                    .patternLine("GSG")
                    .key('G', Items.GLASS_PANE)
                    .key('S', Items.STICK)
                    .addCriterion("has_glass_pane", this.hasItem(Items.GLASS_PANE))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FOURBYFOUR_BLACK_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW))
                    .key('D', Items.BLACK_DYE)
                    .addCriterion("has_fourbyfour_wooden_window", this.hasItem(get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FOURBYFOUR_CYAN_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW))
                    .key('D', Items.CYAN_DYE)
                    .addCriterion("has_fourbyfour_wooden_window", this.hasItem(get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FOURBYFOUR_GREEN_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW))
                    .key('D', Items.GREEN_DYE)
                    .addCriterion("has_fourbyfour_wooden_window", this.hasItem(get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FOURBYFOUR_LIGHT_BLUE_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW))
                    .key('D', Items.LIGHT_BLUE_DYE)
                    .addCriterion("has_fourbyfour_wooden_window", this.hasItem(get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FOURBYFOUR_LIME_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW))
                    .key('D', Items.LIME_DYE)
                    .addCriterion("has_fourbyfour_wooden_window", this.hasItem(get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FOURBYFOUR_MAGENTA_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW))
                    .key('D', Items.MAGENTA_DYE)
                    .addCriterion("has_fourbyfour_wooden_window", this.hasItem(get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FOURBYFOUR_ORANGE_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW))
                    .key('D', Items.ORANGE_DYE)
                    .addCriterion("has_fourbyfour_wooden_window", this.hasItem(get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FOURBYFOUR_PINK_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW))
                    .key('D', Items.PINK_DYE)
                    .addCriterion("has_fourbyfour_wooden_window", this.hasItem(get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FOURBYFOUR_PURPLE_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW))
                    .key('D', Items.PURPLE_DYE)
                    .addCriterion("has_fourbyfour_wooden_window", this.hasItem(get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FOURBYFOUR_RED_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW))
                    .key('D', Items.RED_DYE)
                    .addCriterion("has_fourbyfour_wooden_window", this.hasItem(get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FOURBYFOUR_WHITE_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW))
                    .key('D', Items.WHITE_DYE)
                    .addCriterion("has_fourbyfour_wooden_window", this.hasItem(get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FOURBYFOUR_YELLOW_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW))
                    .key('D', Items.YELLOW_DYE)
                    .addCriterion("has_fourbyfour_wooden_window", this.hasItem(get(ThingsItems.FOURBYFOUR_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SMALL_WOODEN_WINDOW))
                    .patternLine("GS")
                    .patternLine("SG")
                    .key('G', Items.GLASS_PANE)
                    .key('S', Items.STICK)
                    .addCriterion("has_glass_pane", this.hasItem(Items.GLASS_PANE))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SMALL_BLACK_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.SMALL_WOODEN_WINDOW))
                    .key('D', Items.BLACK_DYE)
                    .addCriterion("has_small_wooden_window", this.hasItem(get(ThingsItems.SMALL_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SMALL_CYAN_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.SMALL_WOODEN_WINDOW))
                    .key('D', Items.CYAN_DYE)
                    .addCriterion("has_small_wooden_window", this.hasItem(get(ThingsItems.SMALL_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SMALL_GREEN_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.SMALL_WOODEN_WINDOW))
                    .key('D', Items.GREEN_DYE)
                    .addCriterion("has_small_wooden_window", this.hasItem(get(ThingsItems.SMALL_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SMALL_LIGHT_BLUE_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.SMALL_WOODEN_WINDOW))
                    .key('D', Items.LIGHT_BLUE_DYE)
                    .addCriterion("has_small_wooden_window", this.hasItem(get(ThingsItems.SMALL_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SMALL_LIME_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.SMALL_WOODEN_WINDOW))
                    .key('D', Items.LIME_DYE)
                    .addCriterion("has_small_wooden_window", this.hasItem(get(ThingsItems.SMALL_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SMALL_MAGENTA_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.SMALL_WOODEN_WINDOW))
                    .key('D', Items.MAGENTA_DYE)
                    .addCriterion("has_small_wooden_window", this.hasItem(get(ThingsItems.SMALL_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SMALL_ORANGE_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.SMALL_WOODEN_WINDOW))
                    .key('D', Items.ORANGE_DYE)
                    .addCriterion("has_small_wooden_window", this.hasItem(get(ThingsItems.SMALL_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SMALL_PINK_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.SMALL_WOODEN_WINDOW))
                    .key('D', Items.PINK_DYE)
                    .addCriterion("has_small_wooden_window", this.hasItem(get(ThingsItems.SMALL_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SMALL_PURPLE_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.SMALL_WOODEN_WINDOW))
                    .key('D', Items.PURPLE_DYE)
                    .addCriterion("has_small_wooden_window", this.hasItem(get(ThingsItems.SMALL_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SMALL_RED_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.SMALL_WOODEN_WINDOW))
                    .key('D', Items.RED_DYE)
                    .addCriterion("has_small_wooden_window", this.hasItem(get(ThingsItems.SMALL_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SMALL_WHITE_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.SMALL_WOODEN_WINDOW))
                    .key('D', Items.WHITE_DYE)
                    .addCriterion("has_small_wooden_window", this.hasItem(get(ThingsItems.SMALL_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SMALL_YELLOW_WINDOW))
                    .patternLine("WD")
                    .key('W', get(ThingsItems.SMALL_WOODEN_WINDOW))
                    .key('D', Items.YELLOW_DYE)
                    .addCriterion("has_small_wooden_window", this.hasItem(get(ThingsItems.SMALL_WOODEN_WINDOW)))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BLUE_OAK_DECK_CHAIR))
                    .patternLine("WDW")
                    .patternLine("S S")
                    .patternLine("S S")
                    .key('W', Items.WHITE_WOOL)
                    .key('D', Items.BLUE_WOOL)
                    .key('S', Items.STICK)
                    .addCriterion("has_blue_wool", this.hasItem(Items.BLUE_WOOL))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.PINK_OAK_DECK_CHAIR))
                    .patternLine("WDW")
                    .patternLine("S S")
                    .patternLine("S S")
                    .key('W', Items.WHITE_WOOL)
                    .key('D', Items.PINK_WOOL)
                    .key('S', Items.STICK)
                    .addCriterion("has_pink_wool", this.hasItem(Items.PINK_WOOL))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.YELLOW_OAK_DECK_CHAIR))
                    .patternLine("WDW")
                    .patternLine("S S")
                    .patternLine("S S")
                    .key('W', Items.WHITE_WOOL)
                    .key('D', Items.YELLOW_WOOL)
                    .key('S', Items.STICK)
                    .addCriterion("has_yellow_wool", this.hasItem(Items.YELLOW_WOOL))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GREEN_SPRUCE_DECK_CHAIR))
                    .patternLine("WDW")
                    .patternLine("S S")
                    .patternLine("S S")
                    .key('W', Items.WHITE_WOOL)
                    .key('D', Items.GREEN_WOOL)
                    .key('S', Items.STICK)
                    .addCriterion("has_green_wool", this.hasItem(Items.GREEN_WOOL))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.RED_SPRUCE_DECK_CHAIR))
                    .patternLine("WDW")
                    .patternLine("S S")
                    .patternLine("S S")
                    .key('W', Items.WHITE_WOOL)
                    .key('D', Items.RED_WOOL)
                    .key('S', Items.STICK)
                    .addCriterion("has_red_wool", this.hasItem(Items.RED_WOOL))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.STEW_POT))
                    .patternLine("I I")
                    .patternLine("ISI")
                    .patternLine("III")
                    .key('I', Items.IRON_INGOT)
                    .key('S', Items.RABBIT_STEW)
                    .addCriterion("has_rabbit_stew", this.hasItem(Items.RABBIT_STEW))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.PINK_CAT_TREE))
                    .patternLine(" C ")
                    .patternLine(" F ")
                    .patternLine(" S ")
                    .key('C', Items.PINK_CARPET)
                    .key('F', Items.BIRCH_FENCE)
                    .key('S', Items.BIRCH_SLAB)
                    .addCriterion("has_birch_slab", this.hasItem(Items.BIRCH_SLAB))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.CYAN_CAT_TREE))
                    .patternLine(" C ")
                    .patternLine(" F ")
                    .patternLine(" S ")
                    .key('C', Items.CYAN_CARPET)
                    .key('F', Items.BIRCH_FENCE)
                    .key('S', Items.BIRCH_SLAB)
                    .addCriterion("has_birch_slab", this.hasItem(Items.BIRCH_SLAB))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.WHITE_CAT_TREE))
                    .patternLine(" C ")
                    .patternLine(" F ")
                    .patternLine(" S ")
                    .key('C', Items.WHITE_CARPET)
                    .key('F', Items.OAK_FENCE)
                    .key('S', Items.OAK_SLAB)
                    .addCriterion("has_oak_slab", this.hasItem(Items.OAK_SLAB))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.RED_CAT_TREE))
                    .patternLine(" C ")
                    .patternLine(" F ")
                    .patternLine(" S ")
                    .key('C', Items.RED_CARPET)
                    .key('F', Items.SPRUCE_FENCE)
                    .key('S', Items.SPRUCE_SLAB)
                    .addCriterion("has_spruce_slab", this.hasItem(Items.SPRUCE_SLAB))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.SILVER_PLAY_BUTTON))
                    .patternLine(" I ")
                    .patternLine(" CI")
                    .patternLine(" I ")
                    .key('I', Items.IRON_INGOT)
                    .key('C', Items.WHITE_CONCRETE)
                    .addCriterion("has_iron_ingot", this.hasItem(Items.IRON_INGOT))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GOLD_PLAY_BUTTON))
                    .patternLine(" I ")
                    .patternLine(" CI")
                    .patternLine(" I ")
                    .key('I', Items.GOLD_INGOT)
                    .key('C', Items.WHITE_CONCRETE)
                    .addCriterion("has_gold_ingot", this.hasItem(Items.GOLD_INGOT))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.COFFEE_MUG))
                    .patternLine("I")
                    .patternLine("C")
                    .key('I', Items.COCOA_BEANS)
                    .key('C', Items.WHITE_CONCRETE)
                    .addCriterion("has_cocoa_beans", this.hasItem(Items.COCOA_BEANS))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.PINK_PET_BED))
                    .patternLine("SCS")
                    .patternLine("PPP")
                    .key('S', Items.BIRCH_SLAB)
                    .key('C', Items.PINK_CARPET)
                    .key('P', Items.BIRCH_PLANKS)
                    .addCriterion("has_pink_carpet", this.hasItem(Items.PINK_CARPET))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.CYAN_PET_BED))
                    .patternLine("SCS")
                    .patternLine("PPP")
                    .key('S', Items.BIRCH_SLAB)
                    .key('C', Items.CYAN_CARPET)
                    .key('P', Items.BIRCH_PLANKS)
                    .addCriterion("has_cyan_carpet", this.hasItem(Items.CYAN_CARPET))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.WHITE_PET_BED))
                    .patternLine("SCS")
                    .patternLine("PPP")
                    .key('S', Items.BIRCH_SLAB)
                    .key('C', Items.WHITE_CARPET)
                    .key('P', Items.BIRCH_PLANKS)
                    .addCriterion("has_white_carpet", this.hasItem(Items.WHITE_CARPET))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.RED_PET_BED))
                    .patternLine("SCS")
                    .patternLine("PPP")
                    .key('S', Items.SPRUCE_SLAB)
                    .key('C', Items.RED_CARPET)
                    .key('P', Items.SPRUCE_PLANKS)
                    .addCriterion("has_red_carpet", this.hasItem(Items.RED_CARPET))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.DOG_BOWL))
                    .patternLine("RBR")
                    .patternLine("RRR")
                    .key('R', Items.RED_CONCRETE)
                    .key('B', Items.BONE)
                    .addCriterion("has_bone", this.hasItem(Items.BONE))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.BLUE_STRIPE_CANOPY))
                    .patternLine("BRB")
                    .key('R', Items.BLUE_CARPET)
                    .key('B', Items.WHITE_CARPET)
                    .addCriterion("has_white_carpet", this.hasItem(Items.WHITE_CARPET))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GREEN_STRIPE_CANOPY))
                    .patternLine("BRB")
                    .key('R', Items.GREEN_CARPET)
                    .key('B', Items.WHITE_CARPET)
                    .addCriterion("has_white_carpet", this.hasItem(Items.WHITE_CARPET))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.MAGENTA_STRIPE_CANOPY))
                    .patternLine("BRB")
                    .key('R', Items.MAGENTA_CARPET)
                    .key('B', Items.WHITE_CARPET)
                    .addCriterion("has_white_carpet", this.hasItem(Items.WHITE_CARPET))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.PINK_STAR_CANOPY))
                    .patternLine("GRG")
                    .key('R', Items.PINK_CARPET)
                    .key('G', Items.GLOWSTONE_DUST)
                    .addCriterion("has_pink_carpet", this.hasItem(Items.PINK_CARPET))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.PURPLE_STAR_CANOPY))
                    .patternLine("GRG")
                    .key('R', Items.PURPLE_CARPET)
                    .key('G', Items.GLOWSTONE_DUST)
                    .addCriterion("has_purple_carpet", this.hasItem(Items.PURPLE_CARPET))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.GREY_STAR_CANOPY))
                    .patternLine("GRG")
                    .key('R', Items.GRAY_CARPET)
                    .key('G', Items.NETHER_STAR)
                    .addCriterion("has_gray_carpet", this.hasItem(Items.GRAY_CARPET))
                    .build(consumer);
            ShapedRecipeBuilder.shapedRecipe(get(ThingsItems.FURNISHING_STATION))
                    .patternLine("RYB")
                    .patternLine("PIP")
                    .patternLine("PPP")
                    .key('R', Items.RED_DYE)
                    .key('Y', Items.YELLOW_DYE)
                    .key('B', Items.BLUE_DYE)
                    .key('P', Items.OAK_PLANKS)
                    .key('I', Items.IRON_INGOT)
                    .addCriterion("has_iron_ingot", this.hasItem(Items.IRON_INGOT))
                    .build(consumer);
        }
    }

    static class ThingsLootTableProvider extends LootTableProvider {
        public ThingsLootTableProvider(DataGenerator generator) {
            super(generator);
        }

        @Override
        protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
            return ImmutableList.of(Pair.of(ThingsBlockLootTables::new, LootParameterSets.BLOCK));
        }

        @Override
        protected void validate(Map<ResourceLocation, LootTable> map, ValidationResults results) {
            map.forEach((name, table) -> LootTableManager.func_215302_a(results, name, table, map::get));
        }
    }

    static class ThingsBlockLootTables extends BlockLootTables {
        @Override
        protected Iterable<Block> getKnownBlocks() {
            return ThingsBlocks.REG.getEntries().stream().map(ThingsData::get).collect(Collectors.toList());
        }

        @Override
        protected void addTables() {
            this.dropSelf(ThingsBlocks.FURNISHING_STATION);
            this.dropSelf(ThingsBlocks.GRAVESTONE_MOON);
            this.dropSelf(ThingsBlocks.GRAVESTONE_SKULL);
            this.dropSelf(ThingsBlocks.GRAVESTONE_HEART);
            this.dropSelf(ThingsBlocks.GLOBE_GOLD);
            this.dropSelf(ThingsBlocks.GLOBE_IRON);
            this.dropSelf(ThingsBlocks.GLOBE_ALT_GOLD);
            this.dropSelf(ThingsBlocks.GLOBE_ALT_IRON);
            this.dropSelf(ThingsBlocks.MUSHROOM_LAMP_RED);
            this.dropSelf(ThingsBlocks.CRYSTAL_BALL_PURPLE);
            this.dropSelf(ThingsBlocks.MAGENTA_DRUM);
            this.dropSelf(ThingsBlocks.CYMBAL);
            this.dropSelf(ThingsBlocks.BIG_DRUM);
            this.dropSelf(ThingsBlocks.CRASH_CYMBAL);
            this.dropSelf(ThingsBlocks.KEYBOARD);
            this.dropSelf(ThingsBlocks.KEYBOARD_STAND);
            this.dropSelf(ThingsBlocks.COWBELL);
            this.dropSelf(ThingsBlocks.BOOK_UPRIGHT_SINGLE);
            this.dropSelf(ThingsBlocks.BOOK_UPRIGHT_TRIO);
            this.dropSelf(ThingsBlocks.BOOK_UPRIGHT_FOUR);
            this.dropSelf(ThingsBlocks.BOOK_MAGIC_UPRIGHT_SINGLE);
            this.dropSelf(ThingsBlocks.BOOK_MAGIC_UPRIGHT_TRIO);
            this.dropSelf(ThingsBlocks.BOOK_MAGIC_UPRIGHT_FOUR);
            this.dropSelf(ThingsBlocks.BOOK_LAID_SINGLE);
            this.dropSelf(ThingsBlocks.BOOK_LAID_DOUBLE);
            this.dropSelf(ThingsBlocks.BOOK_LAID_TRIPLE);
            this.dropSelf(ThingsBlocks.BLUE_CHINA_VASE_TALL);
            this.dropSelf(ThingsBlocks.BLUE_CHINA_VASE_SHORT);
            this.dropSelf(ThingsBlocks.BLUE_CHINA_VASE_DOUBLE);
            this.dropSelf(ThingsBlocks.RED_CELEBRATION_VASE_TALL);
            this.dropSelf(ThingsBlocks.RED_CELEBRATION_VASE_SHORT);
            this.dropSelf(ThingsBlocks.RED_CELEBRATION_VASE_DOUBLE);
            this.dropSelf(ThingsBlocks.GIFT_SQUARE_PURPLE);
            this.dropSelf(ThingsBlocks.GIFT_TALL_RED);
            this.dropSelf(ThingsBlocks.GIFT_DOUBLE_ONE);
            this.dropSelf(ThingsBlocks.GIFT_SQUARE_PINK);
            this.dropSelf(ThingsBlocks.TV);
            this.dropSelf(ThingsBlocks.PINK_TV);
            this.dropSelf(ThingsBlocks.CYAN_TV);
            this.dropSelf(ThingsBlocks.PIRATE_SIGN);
            this.dropSelf(ThingsBlocks.WOODEN_WINDOW_BOX_TULIP);
            this.dropSelf(ThingsBlocks.WHITE_WOODEN_WINDOW_BOX_TULIP);
            this.dropSelf(ThingsBlocks.BLUE_WOODEN_WINDOW_BOX_TULIP);
            this.dropSelf(ThingsBlocks.PINK_WOODEN_WINDOW_BOX_TULIP);
            this.dropSelf(ThingsBlocks.YELLOW_WOODEN_WINDOW_BOX_TULIP);
            this.dropSelf(ThingsBlocks.WOODEN_CHAIR);
            this.dropSelf(ThingsBlocks.FROGGY_CHAIR);
            this.dropSelf(ThingsBlocks.PINK_CHAIR);
            this.dropSelf(ThingsBlocks.CYAN_CHAIR);
            this.dropSelf(ThingsBlocks.LIGHT_BLUE_CHAIR);
            this.dropSelf(ThingsBlocks.PURPLE_CHAIR);
            this.dropSelf(ThingsBlocks.WHITE_CHAIR);
            this.dropSelf(ThingsBlocks.YELLOW_CHAIR);
            this.dropSelf(ThingsBlocks.HOT_PINK_CHAIR);
            this.dropSelf(ThingsBlocks.GREEN_CHAIR);
            this.dropSelf(ThingsBlocks.WOODEN_TABLE);
            this.dropSelf(ThingsBlocks.PINK_TABLE);
            this.dropSelf(ThingsBlocks.CYAN_TABLE);
            this.dropSelf(ThingsBlocks.LIGHT_BLUE_TABLE);
            this.dropSelf(ThingsBlocks.PURPLE_TABLE);
            this.dropSelf(ThingsBlocks.WHITE_TABLE);
            this.dropSelf(ThingsBlocks.YELLOW_TABLE);
            this.dropSelf(ThingsBlocks.HOT_PINK_TABLE);
            this.dropSelf(ThingsBlocks.GREEN_TABLE);
            this.dropSelf(ThingsBlocks.FOURBYFOUR_WOODEN_WINDOW);
            this.dropSelf(ThingsBlocks.FOURBYFOUR_BLACK_WINDOW);
            this.dropSelf(ThingsBlocks.FOURBYFOUR_CYAN_WINDOW);
            this.dropSelf(ThingsBlocks.FOURBYFOUR_LIGHT_BLUE_WINDOW);
            this.dropSelf(ThingsBlocks.FOURBYFOUR_GREEN_WINDOW);
            this.dropSelf(ThingsBlocks.FOURBYFOUR_LIME_WINDOW);
            this.dropSelf(ThingsBlocks.FOURBYFOUR_MAGENTA_WINDOW);
            this.dropSelf(ThingsBlocks.FOURBYFOUR_ORANGE_WINDOW);
            this.dropSelf(ThingsBlocks.FOURBYFOUR_PINK_WINDOW);
            this.dropSelf(ThingsBlocks.FOURBYFOUR_PURPLE_WINDOW);
            this.dropSelf(ThingsBlocks.FOURBYFOUR_RED_WINDOW);
            this.dropSelf(ThingsBlocks.FOURBYFOUR_WHITE_WINDOW);
            this.dropSelf(ThingsBlocks.FOURBYFOUR_YELLOW_WINDOW);
            this.dropSelf(ThingsBlocks.SMALL_WOODEN_WINDOW);
            this.dropSelf(ThingsBlocks.SMALL_BLACK_WINDOW);
            this.dropSelf(ThingsBlocks.SMALL_CYAN_WINDOW);
            this.dropSelf(ThingsBlocks.SMALL_LIGHT_BLUE_WINDOW);
            this.dropSelf(ThingsBlocks.SMALL_GREEN_WINDOW);
            this.dropSelf(ThingsBlocks.SMALL_LIME_WINDOW);
            this.dropSelf(ThingsBlocks.SMALL_MAGENTA_WINDOW);
            this.dropSelf(ThingsBlocks.SMALL_ORANGE_WINDOW);
            this.dropSelf(ThingsBlocks.SMALL_PINK_WINDOW);
            this.dropSelf(ThingsBlocks.SMALL_PURPLE_WINDOW);
            this.dropSelf(ThingsBlocks.SMALL_RED_WINDOW);
            this.dropSelf(ThingsBlocks.SMALL_WHITE_WINDOW);
            this.dropSelf(ThingsBlocks.SMALL_YELLOW_WINDOW);
            this.dropSelf(ThingsBlocks.BLUE_OAK_DECK_CHAIR);
            this.dropSelf(ThingsBlocks.PINK_OAK_DECK_CHAIR);
            this.dropSelf(ThingsBlocks.YELLOW_OAK_DECK_CHAIR);
            this.dropSelf(ThingsBlocks.GREEN_SPRUCE_DECK_CHAIR);
            this.dropSelf(ThingsBlocks.RED_SPRUCE_DECK_CHAIR);
            this.dropSelf(ThingsBlocks.STEW_POT);
            this.dropSelf(ThingsBlocks.PINK_CAT_TREE);
            this.dropSelf(ThingsBlocks.CYAN_CAT_TREE);
            this.dropSelf(ThingsBlocks.WHITE_CAT_TREE);
            this.dropSelf(ThingsBlocks.RED_CAT_TREE);
            this.dropSelf(ThingsBlocks.COFFEE_MUG);
            this.dropSelf(ThingsBlocks.DOG_BOWL);
            this.dropSelf(ThingsBlocks.PINK_PET_BED);
            this.dropSelf(ThingsBlocks.RED_PET_BED);
            this.dropSelf(ThingsBlocks.WHITE_PET_BED);
            this.dropSelf(ThingsBlocks.CYAN_PET_BED);
            this.dropSelf(ThingsBlocks.GOLD_PLAY_BUTTON);
            this.dropSelf(ThingsBlocks.SILVER_PLAY_BUTTON);
            this.dropSelf(ThingsBlocks.GREY_STAR_CANOPY);
            this.dropSelf(ThingsBlocks.PINK_STAR_CANOPY);
            this.dropSelf(ThingsBlocks.PURPLE_STAR_CANOPY);
            this.dropSelf(ThingsBlocks.BLUE_STRIPE_CANOPY);
            this.dropSelf(ThingsBlocks.GREEN_STRIPE_CANOPY);
            this.dropSelf(ThingsBlocks.MAGENTA_STRIPE_CANOPY);

        }

        void dropSelf(RegistryObject<? extends Block> block) {
            this.func_218492_c(get(block));
        }
    }

    static class ThingsAdvancementProvider extends AbstractAdvancementProvider {
        public ThingsAdvancementProvider(DataGenerator generator) {
            super(generator);
        }

        @Override
        List<Consumer<Consumer<Advancement>>> getAdvancements() {
            return ImmutableList.of(new FurnishingAdvancements());
        }
    }

    static <T extends IForgeRegistryEntry<? super T>> T get(RegistryObject<? extends T> obj) {
        return obj.orElseThrow(() -> new IllegalStateException("Absent registry object: \"" + obj.getId() + "\""));
    }
}
