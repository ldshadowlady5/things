package com.ldshadowlady.things.data;

import com.google.common.collect.ImmutableList;
import com.ldshadowlady.things.blocks.ThingsBlocks;
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
