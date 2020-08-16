package com.ldshadowlady.things.items;

import com.ldshadowlady.things.blocks.BlockDirectional;
import com.ldshadowlady.things.blocks.BlockRotational;
import com.ldshadowlady.things.blocks.ThingsBlocks;
import com.ldshadowlady.things.furnishing.Furnishing;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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
    public static final RegistryObject<ThingsBlockItem> GLOBE_GOLD = REG.register("globe_gold", ThingsItems.create(ThingsBlocks.GLOBE_GOLD, f -> f.group("globe").yellow(1).blue(2)));
    public static final RegistryObject<ThingsBlockItem> GLOBE_IRON = REG.register("globe_iron", ThingsItems.create(ThingsBlocks.GLOBE_IRON, f -> f.group("globe").yellow(1).blue(2)));
    public static final RegistryObject<ThingsBlockItem> GLOBE_ALT_GOLD = REG.register("globe_alt_gold", ThingsItems.create(ThingsBlocks.GLOBE_ALT_GOLD, f -> f.group("globe").red(1).blue(2)));
    public static final RegistryObject<ThingsBlockItem> GLOBE_ALT_IRON = REG.register("globe_alt_iron", ThingsItems.create(ThingsBlocks.GLOBE_ALT_IRON, f -> f.group("globe").red(1).blue(2)));
    public static final RegistryObject<ThingsBlockItem> MUSHROOM_LAMP_RED = REG.register("mushroom_lamp_red", ThingsItems.create(ThingsBlocks.MUSHROOM_LAMP_RED, f -> f.group("lamp").red(2).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> CRYSTAL_BALL_PURPLE = REG.register("crystal_ball_purple", ThingsItems.create(ThingsBlocks.CRYSTAL_BALL_PURPLE, f -> f.group("lamp").red(2).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> MAGENTA_DRUM = REG.register("magenta_drum", ThingsItems.create(ThingsBlocks.MAGENTA_DRUM, f -> f.group("drums").red(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> CYMBAL = REG.register("cymbal", ThingsItems.create(ThingsBlocks.CYMBAL, f -> f.group("drums").red(1).blue(1).yellow(1)));
    public static final RegistryObject<ThingsBlockItem> BIG_DRUM = REG.register("big_drum", ThingsItems.create(ThingsBlocks.BIG_DRUM, f -> f.group("drums").red(1).blue(1).yellow(1)));
    public static final RegistryObject<ThingsBlockItem> CRASH_CYMBAL = REG.register("crash_cymbal", ThingsItems.create(ThingsBlocks.CRASH_CYMBAL, f -> f.group("drums").red(1).blue(1).yellow(1)));
    public static final RegistryObject<ThingsBlockItem> KEYBOARD_STAND = REG.register("keyboard_stand", ThingsItems.create(ThingsBlocks.KEYBOARD_STAND, f -> f.group("keyboard").red(1).blue(2).yellow(3)));
    public static final RegistryObject<ThingsBlockItem> KEYBOARD = REG.register("keyboard", ThingsItems.create(ThingsBlocks.KEYBOARD, f -> f.group("keyboard").red(3).blue(3).yellow(5)));
    public static final RegistryObject<ThingsBlockItem> COWBELL = REG.register("cowbell", ThingsItems.create(ThingsBlocks.COWBELL, f -> f.group("drums").red(1).blue(1).yellow(4)));
    public static final RegistryObject<ThingsBlockItem> BOOK_UPRIGHT_SINGLE = REG.register("book_upright_single", ThingsItems.create(ThingsBlocks.BOOK_UPRIGHT_SINGLE, f -> f.group("book/upright").red(1).yellow(1)));
    public static final RegistryObject<ThingsBlockItem> BOOK_UPRIGHT_TRIO = REG.register("book_upright_trio", ThingsItems.create(ThingsBlocks.BOOK_UPRIGHT_TRIO, f -> f.group("book/upright").red(3).yellow(3)));
    public static final RegistryObject<ThingsBlockItem> BOOK_UPRIGHT_FOUR = REG.register("book_upright_four", ThingsItems.create(ThingsBlocks.BOOK_UPRIGHT_FOUR, f -> f.group("book/upright").red(4).yellow(4)));
    public static final RegistryObject<ThingsBlockItem> BOOK_MAGIC_UPRIGHT_SINGLE = REG.register("book_magic_upright_single", ThingsItems.create(ThingsBlocks.BOOK_MAGIC_UPRIGHT_SINGLE, f -> f.group("book/magic").red(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> BOOK_MAGIC_UPRIGHT_TRIO = REG.register("book_magic_upright_trio", ThingsItems.create(ThingsBlocks.BOOK_MAGIC_UPRIGHT_TRIO, f -> f.group("book/magic").red(3).blue(3)));
    public static final RegistryObject<ThingsBlockItem> BOOK_MAGIC_UPRIGHT_FOUR = REG.register("book_magic_upright_four", ThingsItems.create(ThingsBlocks.BOOK_MAGIC_UPRIGHT_FOUR, f -> f.group("book/magic").red(4).blue(4)));
    public static final RegistryObject<ThingsBlockItem> BOOK_LAID_SINGLE = REG.register("book_laid_single", ThingsItems.create(ThingsBlocks.BOOK_LAID_SINGLE, f -> f.group("book/laid").blue(1)));
    public static final RegistryObject<ThingsBlockItem> BOOK_LAID_DOUBLE = REG.register("book_laid_double", ThingsItems.create(ThingsBlocks.BOOK_LAID_DOUBLE, f -> f.group("book/laid").blue(2)));
    public static final RegistryObject<ThingsBlockItem> BOOK_LAID_TRIPLE = REG.register("book_laid_triple", ThingsItems.create(ThingsBlocks.BOOK_LAID_TRIPLE, f -> f.group("book/laid").blue(3)));
    public static final RegistryObject<ThingsBlockItem> BLUE_CHINA_VASE_TALL = REG.register("blue_china_vase_tall", ThingsItems.create(ThingsBlocks.BLUE_CHINA_VASE_TALL, f -> f.group("vase/china").red(1).blue(2).yellow(1)));
    public static final RegistryObject<ThingsBlockItem> BLUE_CHINA_VASE_SHORT = REG.register("blue_china_vase_short", ThingsItems.create(ThingsBlocks.BLUE_CHINA_VASE_SHORT, f -> f.group("vase/china").red(1).blue(1).yellow(1)));
    public static final RegistryObject<ThingsBlockItem> BLUE_CHINA_VASE_DOUBLE = REG.register("blue_china_vase_double", ThingsItems.create(ThingsBlocks.BLUE_CHINA_VASE_DOUBLE, f -> f.group("vase/china").red(1).blue(4).yellow(1)));
    public static final RegistryObject<ThingsBlockItem> RED_CELEBRATION_VASE_TALL = REG.register("red_celebration_vase_tall", ThingsItems.create(ThingsBlocks.RED_CELEBRATION_VASE_TALL, f -> f.group("vase/china").red(2).blue(1).yellow(2)));
    public static final RegistryObject<ThingsBlockItem> RED_CELEBRATION_VASE_SHORT = REG.register("red_celebration_vase_short", ThingsItems.create(ThingsBlocks.RED_CELEBRATION_VASE_SHORT, f -> f.group("vase/celebration").red(2).blue(1).yellow(2)));
    public static final RegistryObject<ThingsBlockItem> RED_CELEBRATION_VASE_DOUBLE = REG.register("red_celebration_vase_double", ThingsItems.create(ThingsBlocks.RED_CELEBRATION_VASE_DOUBLE, f -> f.group("vase/celebation").red(4).blue(1).yellow(4)));
    public static final RegistryObject<ThingsBlockItem> GIFT_SQUARE_PURPLE = REG.register("gift_square_purple", ThingsItems.create(ThingsBlocks.GIFT_SQUARE_PURPLE, f -> f.group("gift").red(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> GIFT_TALL_RED = REG.register("gift_tall_red", ThingsItems.create(ThingsBlocks.GIFT_TALL_RED, f -> f.group("gift").red(2).blue(1)));
    public static final RegistryObject<ThingsBlockItem> GIFT_DOUBLE_ONE = REG.register("gift_double_one", ThingsItems.create(ThingsBlocks.GIFT_DOUBLE_ONE, f -> f.group("gift").red(3).blue(3)));
    public static final RegistryObject<ThingsBlockItem> GIFT_SQUARE_PINK = REG.register("gift_square_pink", ThingsItems.create(ThingsBlocks.GIFT_SQUARE_PINK, f -> f.group("gift").red(3).blue(4)));
    public static final RegistryObject<ThingsBlockItem> TV = REG.register("tv", ThingsItems.create(ThingsBlocks.TV, f -> f.group("tv").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> PINK_TV = REG.register("pink_tv", ThingsItems.create(ThingsBlocks.PINK_TV, f -> f.group("tv").red(2).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> CYAN_TV = REG.register("cyan_tv", ThingsItems.create(ThingsBlocks.CYAN_TV, f -> f.group("tv").red(1).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> PIRATE_SIGN = REG.register("pirate_sign", ThingsItems.create(ThingsBlocks.PIRATE_SIGN, f -> f.group("signage").red(1).yellow(2).blue(1)));
    public static final RegistryObject<ThingsBlockItem> WOODEN_WINDOW_BOX_TULIP = REG.register("wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.WOODEN_WINDOW_BOX_TULIP, f -> f.group("window_box").red(1).yellow(2).blue(1)));
    public static final RegistryObject<ThingsBlockItem> WHITE_WOODEN_WINDOW_BOX_TULIP = REG.register("white_wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.WHITE_WOODEN_WINDOW_BOX_TULIP, f -> f.group("window_box").red(1).yellow(2).blue(1)));
    public static final RegistryObject<ThingsBlockItem> BLUE_WOODEN_WINDOW_BOX_TULIP = REG.register("blue_wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.BLUE_WOODEN_WINDOW_BOX_TULIP, f -> f.group("window_box").red(1).yellow(1).blue(2)));
    public static final RegistryObject<ThingsBlockItem> PINK_WOODEN_WINDOW_BOX_TULIP = REG.register("pink_wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.PINK_WOODEN_WINDOW_BOX_TULIP, f -> f.group("window_box").red(2).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> YELLOW_WOODEN_WINDOW_BOX_TULIP = REG.register("yellow_wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.YELLOW_WOODEN_WINDOW_BOX_TULIP, f -> f.group("window_box").red(1).yellow(2).blue(1)));
    public static final RegistryObject<ThingsBlockItem> WOODEN_CHAIR = REG.register("wooden_chair", ThingsItems.create(ThingsBlocks.WOODEN_CHAIR, f -> f.group("chair").red(2).yellow(3).blue(2)));
    public static final RegistryObject<ThingsBlockItem> FROGGY_CHAIR = REG.register("froggy_chair", ThingsItems.create(ThingsBlocks.FROGGY_CHAIR, f -> f.group("chair").red(2).yellow(3).blue(2)));
    public static final RegistryObject<ThingsBlockItem> PINK_CHAIR = REG.register("pink_chair", ThingsItems.create(ThingsBlocks.PINK_CHAIR, f -> f.group("chair").red(2).yellow(3).blue(2)));
    public static final RegistryObject<ThingsBlockItem> CYAN_CHAIR = REG.register("cyan_chair", ThingsItems.create(ThingsBlocks.CYAN_CHAIR, f -> f.group("chair").red(2).yellow(3).blue(2)));
    public static final RegistryObject<ThingsBlockItem> LIGHT_BLUE_CHAIR = REG.register("light_blue_chair", ThingsItems.create(ThingsBlocks.LIGHT_BLUE_CHAIR, f -> f.group("chair").red(2).yellow(3).blue(2)));
    public static final RegistryObject<ThingsBlockItem> PURPLE_CHAIR = REG.register("purple_chair", ThingsItems.create(ThingsBlocks.PURPLE_CHAIR, f -> f.group("chair").red(2).yellow(3).blue(2)));
    public static final RegistryObject<ThingsBlockItem> WHITE_CHAIR = REG.register("white_chair", ThingsItems.create(ThingsBlocks.WHITE_CHAIR, f -> f.group("chair").red(2).yellow(3).blue(2)));
    public static final RegistryObject<ThingsBlockItem> YELLOW_CHAIR = REG.register("yellow_chair", ThingsItems.create(ThingsBlocks.YELLOW_CHAIR, f -> f.group("chair").red(2).yellow(3).blue(2)));
    public static final RegistryObject<ThingsBlockItem> HOT_PINK_CHAIR = REG.register("hot_pink_chair", ThingsItems.create(ThingsBlocks.HOT_PINK_CHAIR, f -> f.group("chair").red(2).yellow(3).blue(2)));
    public static final RegistryObject<ThingsBlockItem> GREEN_CHAIR = REG.register("green_chair", ThingsItems.create(ThingsBlocks.GREEN_CHAIR, f -> f.group("chair").red(2).yellow(3).blue(2)));
    public static final RegistryObject<ThingsBlockItem> WOODEN_TABLE = REG.register("wooden_table", ThingsItems.create(ThingsBlocks.WOODEN_TABLE, f -> f.group("table").red(4).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> PINK_TABLE = REG.register("pink_table", ThingsItems.create(ThingsBlocks.PINK_TABLE, f -> f.group("table").red(4).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> CYAN_TABLE = REG.register("cyan_table", ThingsItems.create(ThingsBlocks.CYAN_TABLE, f -> f.group("table").red(4).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> LIGHT_BLUE_TABLE = REG.register("light_blue_table", ThingsItems.create(ThingsBlocks.LIGHT_BLUE_TABLE, f -> f.group("table").red(4).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> PURPLE_TABLE = REG.register("purple_table", ThingsItems.create(ThingsBlocks.PURPLE_TABLE, f -> f.group("table").red(4).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> WHITE_TABLE = REG.register("white_table", ThingsItems.create(ThingsBlocks.WHITE_TABLE, f -> f.group("table").red(4).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> YELLOW_TABLE = REG.register("yellow_table", ThingsItems.create(ThingsBlocks.YELLOW_TABLE, f -> f.group("table").red(4).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> HOT_PINK_TABLE = REG.register("hot_pink_table", ThingsItems.create(ThingsBlocks.HOT_PINK_TABLE, f -> f.group("table").red(4).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> GREEN_TABLE = REG.register("green_table", ThingsItems.create(ThingsBlocks.GREEN_TABLE, f -> f.group("table").red(4).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> FOURBYFOUR_WOODEN_WINDOW = REG.register("fourbyfour_wooden_window", ThingsItems.create(ThingsBlocks.FOURBYFOUR_WOODEN_WINDOW, f -> f.group("window").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> FOURBYFOUR_BLACK_WINDOW = REG.register("fourbyfour_black_window", ThingsItems.create(ThingsBlocks.FOURBYFOUR_BLACK_WINDOW, f -> f.group("window").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> FOURBYFOUR_CYAN_WINDOW = REG.register("fourbyfour_cyan_window", ThingsItems.create(ThingsBlocks.FOURBYFOUR_CYAN_WINDOW, f -> f.group("window").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> FOURBYFOUR_LIGHT_BLUE_WINDOW = REG.register("fourbyfour_light_blue_window", ThingsItems.create(ThingsBlocks.FOURBYFOUR_LIGHT_BLUE_WINDOW, f -> f.group("window").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> FOURBYFOUR_GREEN_WINDOW = REG.register("fourbyfour_green_window", ThingsItems.create(ThingsBlocks.FOURBYFOUR_GREEN_WINDOW, f -> f.group("window").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> FOURBYFOUR_LIME_WINDOW = REG.register("fourbyfour_lime_window", ThingsItems.create(ThingsBlocks.FOURBYFOUR_LIME_WINDOW, f -> f.group("window").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> FOURBYFOUR_MAGENTA_WINDOW = REG.register("fourbyfour_magenta_window", ThingsItems.create(ThingsBlocks.FOURBYFOUR_MAGENTA_WINDOW, f -> f.group("window").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> FOURBYFOUR_ORANGE_WINDOW = REG.register("fourbyfour_orange_window", ThingsItems.create(ThingsBlocks.FOURBYFOUR_ORANGE_WINDOW, f -> f.group("window").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> FOURBYFOUR_PINK_WINDOW = REG.register("fourbyfour_pink_window", ThingsItems.create(ThingsBlocks.FOURBYFOUR_PINK_WINDOW, f -> f.group("window").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> FOURBYFOUR_PURPLE_WINDOW = REG.register("fourbyfour_purple_window", ThingsItems.create(ThingsBlocks.FOURBYFOUR_PURPLE_WINDOW, f -> f.group("window").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> FOURBYFOUR_RED_WINDOW = REG.register("fourbyfour_red_window", ThingsItems.create(ThingsBlocks.FOURBYFOUR_RED_WINDOW, f -> f.group("window").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> FOURBYFOUR_WHITE_WINDOW = REG.register("fourbyfour_white_window", ThingsItems.create(ThingsBlocks.FOURBYFOUR_WHITE_WINDOW, f -> f.group("window").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> FOURBYFOUR_YELLOW_WINDOW = REG.register("fourbyfour_yellow_window", ThingsItems.create(ThingsBlocks.FOURBYFOUR_YELLOW_WINDOW, f -> f.group("window").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> SMALL_WOODEN_WINDOW = REG.register("small_wooden_window", ThingsItems.create(ThingsBlocks.SMALL_WOODEN_WINDOW, f -> f.group("window").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> SMALL_BLACK_WINDOW = REG.register("small_black_window", ThingsItems.create(ThingsBlocks.SMALL_BLACK_WINDOW, f -> f.group("window").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> SMALL_CYAN_WINDOW = REG.register("small_cyan_window", ThingsItems.create(ThingsBlocks.SMALL_CYAN_WINDOW, f -> f.group("window").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> SMALL_LIGHT_BLUE_WINDOW = REG.register("small_light_blue_window", ThingsItems.create(ThingsBlocks.SMALL_LIGHT_BLUE_WINDOW, f -> f.group("window").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> SMALL_GREEN_WINDOW = REG.register("small_green_window", ThingsItems.create(ThingsBlocks.SMALL_GREEN_WINDOW, f -> f.group("window").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> SMALL_LIME_WINDOW = REG.register("small_lime_window", ThingsItems.create(ThingsBlocks.SMALL_LIME_WINDOW, f -> f.group("window").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> SMALL_MAGENTA_WINDOW = REG.register("small_magenta_window", ThingsItems.create(ThingsBlocks.SMALL_MAGENTA_WINDOW, f -> f.group("window").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> SMALL_ORANGE_WINDOW = REG.register("small_orange_window", ThingsItems.create(ThingsBlocks.SMALL_ORANGE_WINDOW, f -> f.group("window").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> SMALL_PINK_WINDOW = REG.register("small_pink_window", ThingsItems.create(ThingsBlocks.SMALL_PINK_WINDOW, f -> f.group("window").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> SMALL_PURPLE_WINDOW = REG.register("small_purple_window", ThingsItems.create(ThingsBlocks.SMALL_PURPLE_WINDOW, f -> f.group("window").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> SMALL_RED_WINDOW = REG.register("small_red_window", ThingsItems.create(ThingsBlocks.SMALL_RED_WINDOW, f -> f.group("window").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> SMALL_WHITE_WINDOW = REG.register("small_white_window", ThingsItems.create(ThingsBlocks.SMALL_WHITE_WINDOW, f -> f.group("window").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> SMALL_YELLOW_WINDOW = REG.register("small_yellow_window", ThingsItems.create(ThingsBlocks.SMALL_YELLOW_WINDOW, f -> f.group("window").red(1).yellow(1).blue(1)));
    public static final RegistryObject<ThingsBlockItem> BLUE_OAK_DECK_CHAIR = REG.register("blue_oak_deck_chair", ThingsItems.create(ThingsBlocks.BLUE_OAK_DECK_CHAIR, f -> f.group("chair").red(2).yellow(2).blue(5)));
    public static final RegistryObject<ThingsBlockItem> PINK_OAK_DECK_CHAIR = REG.register("pink_oak_deck_chair", ThingsItems.create(ThingsBlocks.PINK_OAK_DECK_CHAIR, f -> f.group("chair").red(4).yellow(3).blue(2)));
    public static final RegistryObject<ThingsBlockItem> YELLOW_OAK_DECK_CHAIR = REG.register("yellow_oak_deck_chair", ThingsItems.create(ThingsBlocks.YELLOW_OAK_DECK_CHAIR, f -> f.group("chair").red(2).yellow(5).blue(2)));
    public static final RegistryObject<ThingsBlockItem> GREEN_SPRUCE_DECK_CHAIR = REG.register("green_spruce_deck_chair", ThingsItems.create(ThingsBlocks.GREEN_SPRUCE_DECK_CHAIR, f -> f.group("chair").red(2).yellow(3).blue(3)));
    public static final RegistryObject<ThingsBlockItem> RED_SPRUCE_DECK_CHAIR = REG.register("red_spruce_deck_chair", ThingsItems.create(ThingsBlocks.RED_SPRUCE_DECK_CHAIR, f -> f.group("chair").red(5).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> STEW_POT = REG.register("stew_pot", ThingsItems.create(ThingsBlocks.STEW_POT, f -> f.group("kitchen").red(6).yellow(2).blue(5)));
    public static final RegistryObject<ThingsBlockItem> PINK_CAT_TREE = REG.register("pink_cat_tree", ThingsItems.create(ThingsBlocks.PINK_CAT_TREE, f -> f.group("scott_tree").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> CYAN_CAT_TREE = REG.register("cyan_cat_tree", ThingsItems.create(ThingsBlocks.CYAN_CAT_TREE, f -> f.group("scott_tree").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> WHITE_CAT_TREE = REG.register("white_cat_tree", ThingsItems.create(ThingsBlocks.WHITE_CAT_TREE, f -> f.group("scott_tree").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> RED_CAT_TREE = REG.register("red_cat_tree", ThingsItems.create(ThingsBlocks.RED_CAT_TREE, f -> f.group("scott_tree").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> COFFEE_MUG = REG.register("coffee_mug", ThingsItems.create(ThingsBlocks.COFFEE_MUG, f -> f.group("scott_decor").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> DOG_BOWL = REG.register("dog_bowl", ThingsItems.create(ThingsBlocks.DOG_BOWL, f -> f.group("scott_decor").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> PINK_PET_BED = REG.register("pink_pet_bed", ThingsItems.create(ThingsBlocks.PINK_PET_BED, f -> f.group("scott_pet_bed").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> RED_PET_BED = REG.register("red_pet_bed", ThingsItems.create(ThingsBlocks.RED_PET_BED, f -> f.group("scott_pet_bed").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> WHITE_PET_BED = REG.register("white_pet_bed", ThingsItems.create(ThingsBlocks.WHITE_PET_BED, f -> f.group("scott_pet_bed").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> CYAN_PET_BED = REG.register("cyan_pet_bed", ThingsItems.create(ThingsBlocks.CYAN_PET_BED, f -> f.group("scott_pet_bed").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> GOLD_PLAY_BUTTON = REG.register("gold_play_button", ThingsItems.create(ThingsBlocks.GOLD_PLAY_BUTTON, f -> f.group("scott_decor").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> SILVER_PLAY_BUTTON = REG.register("silver_play_button", ThingsItems.create(ThingsBlocks.SILVER_PLAY_BUTTON, f -> f.group("scott_decor").red(2).yellow(2).blue(2)));

    public static final RegistryObject<ThingsBlockItem> GREY_STAR_CANOPY = REG.register("grey_star_canopy", ThingsItems.create(ThingsBlocks.GREY_STAR_CANOPY, f -> f.group("canopy").red(3).yellow(2).blue(3)));
    public static final RegistryObject<ThingsBlockItem> PINK_STAR_CANOPY = REG.register("pink_star_canopy", ThingsItems.create(ThingsBlocks.PINK_STAR_CANOPY, f -> f.group("canopy").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> PURPLE_STAR_CANOPY = REG.register("purple_star_canopy", ThingsItems.create(ThingsBlocks.PURPLE_STAR_CANOPY, f -> f.group("canopy").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> BLUE_STRIPE_CANOPY = REG.register("blue_stripe_canopy", ThingsItems.create(ThingsBlocks.BLUE_STRIPE_CANOPY, f -> f.group("canopy").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> GREEN_STRIPE_CANOPY = REG.register("green_stripe_canopy", ThingsItems.create(ThingsBlocks.GREEN_STRIPE_CANOPY, f -> f.group("canopy").red(2).yellow(2).blue(2)));
    public static final RegistryObject<ThingsBlockItem> MAGENTA_STRIPE_CANOPY = REG.register("magenta_stripe_canopy", ThingsItems.create(ThingsBlocks.MAGENTA_STRIPE_CANOPY, f -> f.group("canopy").red(2).yellow(2).blue(2)));

    public static final RegistryObject<ThingsBlockItem> COFFEE_MACHINE = REG.register("coffee_machine", ThingsItems.create(ThingsBlocks.COFFEE_MACHINE, f -> f.group("kitchen").red(6).yellow(12).blue(18)));


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

