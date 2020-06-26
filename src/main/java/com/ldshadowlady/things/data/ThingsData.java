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