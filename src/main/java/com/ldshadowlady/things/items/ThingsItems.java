package com.ldshadowlady.things.items;

import com.ldshadowlady.things.blocks.ThingsBlocks;
import com.ldshadowlady.things.furnishing.Furnishing;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.ldshadowlady.things.Things.ID;

public final class ThingsItems {
    private ThingsItems() {
    }

    public static final DeferredRegister<Item> REG = new DeferredRegister<>(ForgeRegistries.ITEMS, ID);

    public static final RegistryObject<BlockItem> FURNISHING_STATION = REG.register("furnishing_station", ThingsItems.create(ThingsBlocks.FURNISHING_STATION));

    public static final RegistryObject<ThingsBlockItem> GRAVESTONE_MOON = REG.register("gravestone_moon", ThingsItems.create(ThingsBlocks.GRAVESTONE_MOON, f -> f.group("gravestone").blue(2)));
    public static final RegistryObject<ThingsBlockItem> GRAVESTONE_SKULL = REG.register("gravestone_skull", ThingsItems.create(ThingsBlocks.GRAVESTONE_SKULL, f -> f.group("gravestone").blue(2)));
    public static final RegistryObject<ThingsBlockItem> GRAVESTONE_HEART = REG.register("gravestone_heart", ThingsItems.create(ThingsBlocks.GRAVESTONE_HEART, f -> f.group("gravestone").blue(2)));
    public static final RegistryObject<ThingsBlockItem> GLOBE_GOLD = REG.register("globe_gold", ThingsItems.create(ThingsBlocks.GLOBE_GOLD, f -> f.group("globe").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> GLOBE_IRON = REG.register("globe_iron", ThingsItems.create(ThingsBlocks.GLOBE_IRON, f -> f.group("globe")));
    public static final RegistryObject<ThingsBlockItem> GLOBE_ALT_GOLD = REG.register("globe_alt_gold", ThingsItems.create(ThingsBlocks.GLOBE_ALT_GOLD, f -> f.group("globe")));
    public static final RegistryObject<ThingsBlockItem> GLOBE_ALT_IRON = REG.register("globe_alt_iron", ThingsItems.create(ThingsBlocks.GLOBE_ALT_IRON, f -> f.group("globe")));
    public static final RegistryObject<ThingsBlockItem> MUSHROOM_LAMP_RED = REG.register("mushroom_lamp_red", ThingsItems.create(ThingsBlocks.MUSHROOM_LAMP_RED, f -> f));
    public static final RegistryObject<ThingsBlockItem> CRYSTAL_BALL_PURPLE = REG.register("crystal_ball_purple", ThingsItems.create(ThingsBlocks.CRYSTAL_BALL_PURPLE, f -> f));
    public static final RegistryObject<ThingsBlockItem> MAGENTA_DRUM = REG.register("magenta_drum", ThingsItems.create(ThingsBlocks.MAGENTA_DRUM, f -> f.group("drums")));
    public static final RegistryObject<ThingsBlockItem> CYMBAL = REG.register("cymbal", ThingsItems.create(ThingsBlocks.CYMBAL, f -> f.group("drums")));
    public static final RegistryObject<ThingsBlockItem> BIG_DRUM = REG.register("big_drum", ThingsItems.create(ThingsBlocks.BIG_DRUM, f -> f.group("drums")));
    public static final RegistryObject<ThingsBlockItem> CRASH_CYMBAL = REG.register("crash_cymbal", ThingsItems.create(ThingsBlocks.CRASH_CYMBAL, f -> f.group("drums")));
    public static final RegistryObject<ThingsBlockItem> KEYBOARD_STAND = REG.register("keyboard_stand", ThingsItems.create(ThingsBlocks.KEYBOARD_STAND, f -> f.group("keyboard")));
    public static final RegistryObject<ThingsBlockItem> KEYBOARD = REG.register("keyboard", ThingsItems.create(ThingsBlocks.KEYBOARD, f -> f.group("keyboard")));
    public static final RegistryObject<ThingsBlockItem> COWBELL = REG.register("cowbell", ThingsItems.create(ThingsBlocks.COWBELL, f -> f.group("drums")));
    public static final RegistryObject<ThingsBlockItem> BOOK_UPRIGHT_SINGLE = REG.register("book_upright_single", ThingsItems.create(ThingsBlocks.BOOK_UPRIGHT_SINGLE, f -> f.group("book/upright")));
    public static final RegistryObject<ThingsBlockItem> BOOK_UPRIGHT_TRIO = REG.register("book_upright_trio", ThingsItems.create(ThingsBlocks.BOOK_UPRIGHT_TRIO, f -> f.group("book/upright")));
    public static final RegistryObject<ThingsBlockItem> BOOK_UPRIGHT_FOUR = REG.register("book_upright_four", ThingsItems.create(ThingsBlocks.BOOK_UPRIGHT_FOUR, f -> f.group("book/upright")));
    public static final RegistryObject<ThingsBlockItem> BOOK_MAGIC_UPRIGHT_SINGLE = REG.register("book_magic_upright_single", ThingsItems.create(ThingsBlocks.BOOK_MAGIC_UPRIGHT_SINGLE, f -> f.group("book/magic")));
    public static final RegistryObject<ThingsBlockItem> BOOK_MAGIC_UPRIGHT_TRIO = REG.register("book_magic_upright_trio", ThingsItems.create(ThingsBlocks.BOOK_MAGIC_UPRIGHT_TRIO, f -> f.group("book/magic")));
    public static final RegistryObject<ThingsBlockItem> BOOK_MAGIC_UPRIGHT_FOUR = REG.register("book_magic_upright_four", ThingsItems.create(ThingsBlocks.BOOK_MAGIC_UPRIGHT_FOUR, f -> f.group("book/magic")));
    public static final RegistryObject<ThingsBlockItem> BOOK_LAID_SINGLE = REG.register("book_laid_single", ThingsItems.create(ThingsBlocks.BOOK_LAID_SINGLE, f -> f.group("book/laid")));
    public static final RegistryObject<ThingsBlockItem> BOOK_LAID_DOUBLE = REG.register("book_laid_double", ThingsItems.create(ThingsBlocks.BOOK_LAID_DOUBLE, f -> f.group("book/laid")));
    public static final RegistryObject<ThingsBlockItem> BOOK_LAID_TRIPLE = REG.register("book_laid_triple", ThingsItems.create(ThingsBlocks.BOOK_LAID_TRIPLE, f -> f.group("book/laid")));
    public static final RegistryObject<ThingsBlockItem> BLUE_CHINA_VASE_TALL = REG.register("blue_china_vase_tall", ThingsItems.create(ThingsBlocks.BLUE_CHINA_VASE_TALL, f -> f.group("vase/china")));
    public static final RegistryObject<ThingsBlockItem> BLUE_CHINA_VASE_SHORT = REG.register("blue_china_vase_short", ThingsItems.create(ThingsBlocks.BLUE_CHINA_VASE_SHORT, f -> f.group("vase/china")));
    public static final RegistryObject<ThingsBlockItem> BLUE_CHINA_VASE_DOUBLE = REG.register("blue_china_vase_double", ThingsItems.create(ThingsBlocks.BLUE_CHINA_VASE_DOUBLE, f -> f.group("vase/china")));
    public static final RegistryObject<ThingsBlockItem> RED_CELEBRATION_VASE_TALL = REG.register("red_celebration_vase_tall", ThingsItems.create(ThingsBlocks.RED_CELEBRATION_VASE_TALL, f -> f.group("vase/china")));
    public static final RegistryObject<ThingsBlockItem> RED_CELEBRATION_VASE_SHORT = REG.register("red_celebration_vase_short", ThingsItems.create(ThingsBlocks.RED_CELEBRATION_VASE_SHORT, f -> f.group("vase/celebration")));
    public static final RegistryObject<ThingsBlockItem> RED_CELEBRATION_VASE_DOUBLE = REG.register("red_celebration_vase_double", ThingsItems.create(ThingsBlocks.RED_CELEBRATION_VASE_DOUBLE, f -> f.group("vase/celebation")));
    public static final RegistryObject<ThingsBlockItem> GIFT_SQUARE_PURPLE = REG.register("gift_square_purple", ThingsItems.create(ThingsBlocks.GIFT_SQUARE_PURPLE, f -> f.group("gift")));
    public static final RegistryObject<ThingsBlockItem> GIFT_TALL_RED = REG.register("gift_tall_red", ThingsItems.create(ThingsBlocks.GIFT_TALL_RED, f -> f.group("gift")));
    public static final RegistryObject<ThingsBlockItem> GIFT_DOUBLE_ONE = REG.register("gift_double_one", ThingsItems.create(ThingsBlocks.GIFT_DOUBLE_ONE, f -> f.group("gift")));
    public static final RegistryObject<ThingsBlockItem> GIFT_SQUARE_PINK = REG.register("gift_square_pink", ThingsItems.create(ThingsBlocks.GIFT_SQUARE_PINK, f -> f.group("gift")));

    public static final RegistryObject<ThingsBlockItem> TV = REG.register("tv", ThingsItems.create(ThingsBlocks.TV, f -> f.group("tv")));
    public static final RegistryObject<ThingsBlockItem> PINK_TV = REG.register("pink_tv", ThingsItems.create(ThingsBlocks.PINK_TV, f -> f.group("tv")));
    public static final RegistryObject<ThingsBlockItem> CYAN_TV = REG.register("cyan_tv", ThingsItems.create(ThingsBlocks.CYAN_TV, f -> f.group("tv")));
    public static final RegistryObject<ThingsBlockItem> PIRATE_SIGN = REG.register("pirate_sign", ThingsItems.create(ThingsBlocks.PIRATE_SIGN, f -> f));
    public static final RegistryObject<ThingsBlockItem> WOODEN_WINDOW_BOX_TULIP = REG.register("wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.WOODEN_WINDOW_BOX_TULIP, f -> f.group("window_box")));
    public static final RegistryObject<ThingsBlockItem> WHITE_WOODEN_WINDOW_BOX_TULIP = REG.register("white_wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.WHITE_WOODEN_WINDOW_BOX_TULIP, f -> f.group("window_box")));
    public static final RegistryObject<ThingsBlockItem> BLUE_WOODEN_WINDOW_BOX_TULIP = REG.register("blue_wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.BLUE_WOODEN_WINDOW_BOX_TULIP, f -> f.group("window_box")));
    public static final RegistryObject<ThingsBlockItem> PINK_WOODEN_WINDOW_BOX_TULIP = REG.register("pink_wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.PINK_WOODEN_WINDOW_BOX_TULIP, f -> f.group("window_box")));
    public static final RegistryObject<ThingsBlockItem> YELLOW_WOODEN_WINDOW_BOX_TULIP = REG.register("yellow_wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.YELLOW_WOODEN_WINDOW_BOX_TULIP, f -> f.group("window_box")));

    public static final RegistryObject<ThingsBlockItem> FROGGY_CHAIR = REG.register("froggy_chair", ThingsItems.create(ThingsBlocks.FROGGY_CHAIR, f -> f.group("chair")));
    public static final RegistryObject<ThingsBlockItem> PINK_CHAIR = REG.register("pink_chair", ThingsItems.create(ThingsBlocks.PINK_CHAIR, f -> f.group("chair")));
    public static final RegistryObject<ThingsBlockItem> CYAN_CHAIR = REG.register("cyan_chair", ThingsItems.create(ThingsBlocks.CYAN_CHAIR, f -> f.group("chair")));
    public static final RegistryObject<ThingsBlockItem> LIGHT_BLUE_CHAIR = REG.register("light_blue_chair", ThingsItems.create(ThingsBlocks.LIGHT_BLUE_CHAIR, f -> f.group("chair")));
    public static final RegistryObject<ThingsBlockItem> PURPLE_CHAIR = REG.register("purple_chair", ThingsItems.create(ThingsBlocks.PURPLE_CHAIR, f -> f.group("chair")));
    public static final RegistryObject<ThingsBlockItem> WHITE_CHAIR = REG.register("white_chair", ThingsItems.create(ThingsBlocks.WHITE_CHAIR, f -> f.group("chair")));
    public static final RegistryObject<ThingsBlockItem> YELLOW_CHAIR = REG.register("yellow_chair", ThingsItems.create(ThingsBlocks.YELLOW_CHAIR, f -> f.group("chair")));
    public static final RegistryObject<ThingsBlockItem> HOT_PINK_CHAIR = REG.register("hot_pink_chair", ThingsItems.create(ThingsBlocks.HOT_PINK_CHAIR, f -> f.group("chair")));
    public static final RegistryObject<ThingsBlockItem> GREEN_CHAIR = REG.register("green_chair", ThingsItems.create(ThingsBlocks.GREEN_CHAIR, f -> f.group("chair")));

    public static final ItemGroup THINGS = new ThingsItemGroup();

    private static Item.Properties defaultProperties() {
        return new Item.Properties().group(THINGS);
    }

    private static Supplier<BlockItem> create(final RegistryObject<? extends Block> block) {
        return () -> new BlockItem(block.orElseThrow(IllegalStateException::new), defaultProperties());
    }

    private static Supplier<ThingsBlockItem> create(final RegistryObject<? extends Block> block, Function<Furnishing.Builder, Furnishing.Builder> furnishing) {
        return () -> new ThingsBlockItem(block.orElseThrow(IllegalStateException::new), defaultProperties(), furnishing.apply(new Furnishing.Builder()).build());
    }
}

