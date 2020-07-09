package com.ldshadowlady.things.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.ldshadowlady.things.Things.ID;

public final class ThingsBlocks {
    private ThingsBlocks() {}

    public static final DeferredRegister<Block> REG = new DeferredRegister<>(ForgeRegistries.BLOCKS, ID);

    public static final RegistryObject<FurnishingStationBlock> FURNISHING_STATION = REG.register("furnishing_station", () -> new FurnishingStationBlock(Block.Properties.create(Material.WOOD).hardnessAndResistance(2.5F).sound(SoundType.WOOD)));

    public static final RegistryObject<BlockRotational> GRAVESTONE_MOON = REG.register("gravestone_moon", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockRotational> GRAVESTONE_SKULL = REG.register("gravestone_skull", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockRotational> GRAVESTONE_HEART = REG.register("gravestone_heart", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalLamp> GLOBE_GOLD = REG.register("globe_gold", () -> new BlockDirectionalLamp(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).lightValue(14).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalLamp> GLOBE_IRON = REG.register("globe_iron", () -> new BlockDirectionalLamp(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).lightValue(14).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalLamp> GLOBE_ALT_GOLD = REG.register("globe_alt_gold", () -> new BlockDirectionalLamp(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).lightValue(14).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalLamp> GLOBE_ALT_IRON = REG.register("globe_alt_iron", () -> new BlockDirectionalLamp(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).lightValue(14).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalLamp> MUSHROOM_LAMP_RED = REG.register("mushroom_lamp_red", () -> new BlockDirectionalLamp(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).lightValue(14).sound(SoundType.WOOD), Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 14.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalCrystalBall> CRYSTAL_BALL_PURPLE = REG.register("crystal_ball_purple", () -> new BlockDirectionalCrystalBall(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).lightValue(10).sound(SoundType.WOOD), Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D)));

    public static final RegistryObject<BlockDrum> MAGENTA_DRUM = REG.register("magenta_drum", () -> new BlockDrum(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockCymbal> CYMBAL = REG.register("cymbal", () -> new BlockCymbal(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockBigDrum> BIG_DRUM = REG.register("big_drum", () -> new BlockBigDrum(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 2.0D, 16.0D, 16.0D, 11.0D)));
    public static final RegistryObject<BlockCrashCymbal> CRASH_CYMBAL = REG.register("crash_cymbal", () -> new BlockCrashCymbal(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D)));
    public static final RegistryObject<BlockKeyboard> KEYBOARD = REG.register("keyboard", () -> new BlockKeyboard(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).hardnessAndResistance(0.1F).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 5.0D, 16.0D, 3.0D, 12.0D)));
    public static final RegistryObject<BlockDirectional> KEYBOARD_STAND = REG.register("keyboard_stand", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).lightValue(10).sound(SoundType.WOOD), Block.makeCuboidShape(3.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockCowbell> COWBELL = REG.register("cowbell", () -> new BlockCowbell(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(5.0D, 9.0D, 6.0D, 11.0D, 16.0D, 10.0D)));
    public static final RegistryObject<BlockRotational> BOOK_UPRIGHT_SINGLE = REG.register("book_upright_single", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D)));
    public static final RegistryObject<BlockRotational> BOOK_UPRIGHT_TRIO = REG.register("book_upright_trio", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D)));
    public static final RegistryObject<BlockRotational> BOOK_UPRIGHT_FOUR = REG.register("book_upright_four", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D)));
    public static final RegistryObject<BlockRotational> BOOK_MAGIC_UPRIGHT_SINGLE = REG.register("book_magic_upright_single", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D)));
    public static final RegistryObject<BlockRotational> BOOK_MAGIC_UPRIGHT_TRIO = REG.register("book_magic_upright_trio", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D)));
    public static final RegistryObject<BlockRotational> BOOK_MAGIC_UPRIGHT_FOUR = REG.register("book_magic_upright_four", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D)));
    public static final RegistryObject<BlockRotational> BOOK_LAID_SINGLE = REG.register("book_laid_single", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 3.0D, 12.0D)));
    public static final RegistryObject<BlockRotational> BOOK_LAID_DOUBLE = REG.register("book_laid_double", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 6.0D, 12.0D)));
    public static final RegistryObject<BlockRotational> BOOK_LAID_TRIPLE = REG.register("book_laid_triple", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D)));
    public static final RegistryObject<BlockDirectional> BLUE_CHINA_VASE_TALL = REG.register("blue_china_vase_tall", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(6.5D, 0.0D, 6.5D, 11.5D, 11.0D, 11.5D)));
    public static final RegistryObject<BlockDirectional> BLUE_CHINA_VASE_SHORT = REG.register("blue_china_vase_short", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(3.5D, 0.0D, 5.0D, 10.5D, 9.0D, 12.5D)));
    public static final RegistryObject<BlockDirectional> BLUE_CHINA_VASE_DOUBLE = REG.register("blue_china_vase_double", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(1.0D, 0.0D, 3.0D, 16.0D, 11.0D, 15.0D)));
    public static final RegistryObject<BlockDirectional> RED_CELEBRATION_VASE_TALL = REG.register("red_celebration_vase_tall", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(6.5D, 0.0D, 6.5D, 11.5D, 11.0D, 11.5D)));
    public static final RegistryObject<BlockDirectional> RED_CELEBRATION_VASE_SHORT = REG.register("red_celebration_vase_short", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(3.5D, 0.0D, 5.0D, 10.5D, 9.0D, 12.5D)));
    public static final RegistryObject<BlockDirectional> RED_CELEBRATION_VASE_DOUBLE = REG.register("red_celebration_vase_double", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(1.0D, 0.0D, 3.0D, 16.0D, 11.0D, 15.0D)));
    public static final RegistryObject<BlockRotationalTransparency> GIFT_SQUARE_PURPLE = REG.register("gift_square_purple", () -> new BlockRotationalTransparency(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D)));
    public static final RegistryObject<BlockRotationalTransparency> GIFT_TALL_RED = REG.register("gift_tall_red", () -> new BlockRotationalTransparency(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D)));
    public static final RegistryObject<BlockRotationalTransparency> GIFT_DOUBLE_ONE = REG.register("gift_double_one", () -> new BlockRotationalTransparency(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 12.0D, 15.0D)));
    public static final RegistryObject<BlockRotationalTransparency> GIFT_SQUARE_PINK = REG.register("gift_square_pink", () -> new BlockRotationalTransparency(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D)));
    public static final RegistryObject<BlockRotational> TV = REG.register("tv", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D)));
    public static final RegistryObject<BlockRotational> PINK_TV = REG.register("pink_tv", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D)));
    public static final RegistryObject<BlockRotational> CYAN_TV = REG.register("cyan_tv", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D)));
    public static final RegistryObject<BlockRotational> PIRATE_SIGN = REG.register("pirate_sign", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalTransparency> WOODEN_WINDOW_BOX_TULIP = REG.register("wooden_window_box_tulip", () -> new BlockDirectionalTransparency(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 6.0D)));
    public static final RegistryObject<BlockDirectionalTransparency> WHITE_WOODEN_WINDOW_BOX_TULIP = REG.register("white_wooden_window_box_tulip", () -> new BlockDirectionalTransparency(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 6.0D)));
    public static final RegistryObject<BlockDirectionalTransparency> BLUE_WOODEN_WINDOW_BOX_TULIP = REG.register("blue_wooden_window_box_tulip", () -> new BlockDirectionalTransparency(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 6.0D)));
    public static final RegistryObject<BlockDirectionalTransparency> PINK_WOODEN_WINDOW_BOX_TULIP = REG.register("pink_wooden_window_box_tulip", () -> new BlockDirectionalTransparency(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 6.0D)));
    public static final RegistryObject<BlockDirectionalTransparency> YELLOW_WOODEN_WINDOW_BOX_TULIP = REG.register("yellow_wooden_window_box_tulip", () -> new BlockDirectionalTransparency(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 6.0D)));
    public static final RegistryObject<BlockDirectionalChair> WOODEN_CHAIR = REG.register("wooden_chair", () -> new BlockDirectionalChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockDirectionalChair> FROGGY_CHAIR = REG.register("froggy_chair", () -> new BlockDirectionalChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockDirectionalChair> PINK_CHAIR = REG.register("pink_chair", () -> new BlockDirectionalChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockDirectionalChair> CYAN_CHAIR = REG.register("cyan_chair", () -> new BlockDirectionalChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockDirectionalChair> LIGHT_BLUE_CHAIR = REG.register("light_blue_chair", () -> new BlockDirectionalChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockDirectionalChair> PURPLE_CHAIR = REG.register("purple_chair", () -> new BlockDirectionalChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockDirectionalChair> WHITE_CHAIR = REG.register("white_chair", () -> new BlockDirectionalChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockDirectionalChair> YELLOW_CHAIR = REG.register("yellow_chair", () -> new BlockDirectionalChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockDirectionalChair> HOT_PINK_CHAIR = REG.register("hot_pink_chair", () -> new BlockDirectionalChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockDirectionalChair> GREEN_CHAIR = REG.register("green_chair", () -> new BlockDirectionalChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));

    public static final RegistryObject<BlockTable> WOODEN_TABLE = REG.register("wooden_table", () -> new BlockTable(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockTable> PINK_TABLE = REG.register("pink_table", () -> new BlockTable(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockTable> CYAN_TABLE = REG.register("cyan_table", () -> new BlockTable(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockTable> LIGHT_BLUE_TABLE = REG.register("light_blue_table", () -> new BlockTable(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockTable> PURPLE_TABLE = REG.register("purple_table", () -> new BlockTable(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockTable> WHITE_TABLE = REG.register("white_table", () -> new BlockTable(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockTable> YELLOW_TABLE = REG.register("yellow_table", () -> new BlockTable(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockTable> HOT_PINK_TABLE = REG.register("hot_pink_table", () -> new BlockTable(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockTable> GREEN_TABLE = REG.register("green_table", () -> new BlockTable(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockLargeWindow> FOURBYFOUR_WOODEN_WINDOW = REG.register("fourbyfour_wooden_window", () -> new BlockLargeWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<BlockLargeWindow> FOURBYFOUR_BLACK_WINDOW = REG.register("fourbyfour_black_window", () -> new BlockLargeWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<BlockLargeWindow> FOURBYFOUR_CYAN_WINDOW = REG.register("fourbyfour_cyan_window", () -> new BlockLargeWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<BlockLargeWindow> FOURBYFOUR_GREEN_WINDOW = REG.register("fourbyfour_green_window", () -> new BlockLargeWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<BlockLargeWindow> FOURBYFOUR_LIGHT_BLUE_WINDOW = REG.register("fourbyfour_light_blue_window", () -> new BlockLargeWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<BlockLargeWindow> FOURBYFOUR_LIME_WINDOW = REG.register("fourbyfour_lime_window", () -> new BlockLargeWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<BlockLargeWindow> FOURBYFOUR_MAGENTA_WINDOW = REG.register("fourbyfour_magenta_window", () -> new BlockLargeWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<BlockLargeWindow> FOURBYFOUR_ORANGE_WINDOW = REG.register("fourbyfour_orange_window", () -> new BlockLargeWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<BlockLargeWindow> FOURBYFOUR_PINK_WINDOW = REG.register("fourbyfour_pink_window", () -> new BlockLargeWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<BlockLargeWindow> FOURBYFOUR_PURPLE_WINDOW = REG.register("fourbyfour_purple_window", () -> new BlockLargeWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<BlockLargeWindow> FOURBYFOUR_RED_WINDOW = REG.register("fourbyfour_red_window", () -> new BlockLargeWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<BlockLargeWindow> FOURBYFOUR_WHITE_WINDOW = REG.register("fourbyfour_white_window", () -> new BlockLargeWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<BlockLargeWindow> FOURBYFOUR_YELLOW_WINDOW = REG.register("fourbyfour_yellow_window", () -> new BlockLargeWindow(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE)));
    public static final RegistryObject<BlockDirectional> SMALL_WOODEN_WINDOW = REG.register("small_wooden_window", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 7.0D)));
    public static final RegistryObject<BlockDirectional> SMALL_BLACK_WINDOW = REG.register("small_black_window", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 7.0D)));
    public static final RegistryObject<BlockDirectional> SMALL_CYAN_WINDOW = REG.register("small_cyan_window", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 7.0D)));
    public static final RegistryObject<BlockDirectional> SMALL_GREEN_WINDOW = REG.register("small_green_window", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 7.0D)));
    public static final RegistryObject<BlockDirectional> SMALL_LIGHT_BLUE_WINDOW = REG.register("small_light_blue_window", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 7.0D)));
    public static final RegistryObject<BlockDirectional> SMALL_LIME_WINDOW = REG.register("small_lime_window", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 7.0D)));
    public static final RegistryObject<BlockDirectional> SMALL_MAGENTA_WINDOW = REG.register("small_magenta_window", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 7.0D)));
    public static final RegistryObject<BlockDirectional> SMALL_ORANGE_WINDOW = REG.register("small_orange_window", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 7.0D)));
    public static final RegistryObject<BlockDirectional> SMALL_PINK_WINDOW = REG.register("small_pink_window", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 7.0D)));
    public static final RegistryObject<BlockDirectional> SMALL_PURPLE_WINDOW = REG.register("small_purple_window", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 7.0D)));
    public static final RegistryObject<BlockDirectional> SMALL_RED_WINDOW = REG.register("small_red_window", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 7.0D)));
    public static final RegistryObject<BlockDirectional> SMALL_WHITE_WINDOW = REG.register("small_white_window", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 7.0D)));
    public static final RegistryObject<BlockDirectional> SMALL_YELLOW_WINDOW = REG.register("small_yellow_window", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.STONE), Block.makeCuboidShape(0.0D, 0.0D, 11.0D, 16.0D, 16.0D, 7.0D)));
    public static final RegistryObject<BlockDirectionalDeckChair> BLUE_OAK_DECK_CHAIR = REG.register("blue_oak_deck_chair", () -> new BlockDirectionalDeckChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockDirectionalDeckChair> PINK_OAK_DECK_CHAIR = REG.register("pink_oak_deck_chair", () -> new BlockDirectionalDeckChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockDirectionalDeckChair> YELLOW_OAK_DECK_CHAIR = REG.register("yellow_oak_deck_chair", () -> new BlockDirectionalDeckChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockDirectionalDeckChair> GREEN_SPRUCE_DECK_CHAIR = REG.register("green_spruce_deck_chair", () -> new BlockDirectionalDeckChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockDirectionalDeckChair> RED_SPRUCE_DECK_CHAIR = REG.register("red_spruce_deck_chair", () -> new BlockDirectionalDeckChair(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockRotational> STEW_POT = REG.register("stew_pot", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D)));
    public static final RegistryObject<BlockDirectional> PINK_CAT_TREE = REG.register("pink_cat_tree", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 15.0D, 13.0D)));
    public static final RegistryObject<BlockDirectional> CYAN_CAT_TREE = REG.register("cyan_cat_tree", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 15.0D, 13.0D)));
    public static final RegistryObject<BlockDirectional> WHITE_CAT_TREE = REG.register("white_cat_tree", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 15.0D, 13.0D)));
    public static final RegistryObject<BlockDirectional> RED_CAT_TREE = REG.register("red_cat_tree", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 15.0D, 13.0D)));
    public static final RegistryObject<BlockRotational> COFFEE_MUG = REG.register("coffee_mug", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(6.0D, 0.0D, 6.0D, 10.0D, 4.0D, 10.0D)));
    public static final RegistryObject<BlockRotational> DOG_BOWL = REG.register("dog_bowl", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 3.0D, 13.0D)));
    public static final RegistryObject<BlockDirectional> PINK_PET_BED = REG.register("pink_pet_bed", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D)));
    public static final RegistryObject<BlockDirectional> RED_PET_BED = REG.register("red_pet_bed", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D)));
    public static final RegistryObject<BlockDirectional> WHITE_PET_BED = REG.register("white_pet_bed", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D)));
    public static final RegistryObject<BlockDirectional> CYAN_PET_BED = REG.register("cyan_pet_bed", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D)));
    public static final RegistryObject<BlockRotational> GOLD_PLAY_BUTTON = REG.register("gold_play_button", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 7.0D, 13.0D)));
    public static final RegistryObject<BlockRotational> SILVER_PLAY_BUTTON = REG.register("silver_play_button", () -> new BlockRotational(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 7.0D, 13.0D)));

    public static final RegistryObject<BlockDirectional> PURPLE_STAR_CANOPY = REG.register("purple_star_canopy", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 11.0D)));
    public static final RegistryObject<BlockDirectional> PINK_STAR_CANOPY = REG.register("pink_star_canopy", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 11.0D)));
    public static final RegistryObject<BlockDirectional> GREY_STAR_CANOPY = REG.register("grey_star_canopy", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 11.0D)));
    public static final RegistryObject<BlockDirectional> BLUE_STRIPE_CANOPY = REG.register("blue_stripe_canopy", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 11.0D)));
    public static final RegistryObject<BlockDirectional> GREEN_STRIPE_CANOPY = REG.register("green_stripe_canopy", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 11.0D)));
    public static final RegistryObject<BlockDirectional> MAGENTA_STRIPE_CANOPY = REG.register("magenta_stripe_canopy", () -> new BlockDirectional(Block.Properties.create(Material.WOOD).hardnessAndResistance(0.5F).sound(SoundType.WOOD), Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 11.0D)));



}