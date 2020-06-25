package com.ldshadowlady.things.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.ldshadowlady.things.Things.modid;

public final class ThingsBlocks {
    private ThingsBlocks() {}
    public static final DeferredRegister<Block> REG = new DeferredRegister<>(ForgeRegistries.BLOCKS, modid);
    
    
    public static final RegistryObject<BlockRotational> GRAVESTONE_MOON = REG.register("gravestone_moon", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockRotational> GRAVESTONE_SKULL = REG.register("gravestone_skull", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockRotational> GRAVESTONE_HEART = REG.register("gravestone_heart", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalLamp> GLOBE_GOLD = REG.register("globe_gold", () -> new BlockDirectionalLamp(Block.Properties.create(Material.MISCELLANEOUS).lightValue(14).sound(SoundType.WOOD),Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalLamp> GLOBE_IRON = REG.register("globe_iron", () -> new BlockDirectionalLamp(Block.Properties.create(Material.MISCELLANEOUS).lightValue(14).sound(SoundType.WOOD),Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalLamp> GLOBE_ALT_GOLD = REG.register("globe_alt_gold", () -> new BlockDirectionalLamp(Block.Properties.create(Material.MISCELLANEOUS).lightValue(14).sound(SoundType.WOOD),Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalLamp> GLOBE_ALT_IRON = REG.register("globe_alt_iron", () -> new BlockDirectionalLamp(Block.Properties.create(Material.MISCELLANEOUS).lightValue(14).sound(SoundType.WOOD),Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalLamp> MUSHROOM_LAMP_RED = REG.register("mushroom_lamp_red", () -> new BlockDirectionalLamp(Block.Properties.create(Material.MISCELLANEOUS).lightValue(14).sound(SoundType.WOOD),Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 14.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalCrystalBall> CRYSTAL_BALL_PURPLE = REG.register("crystal_ball_purple", () -> new BlockDirectionalCrystalBall(Block.Properties.create(Material.MISCELLANEOUS).lightValue(10).sound(SoundType.WOOD),Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D)));

    public static final RegistryObject<BlockDrum> MAGENTA_DRUM = REG.register("magenta_drum", () -> new BlockDrum(Block.Properties.create(Material.MISCELLANEOUS).lightValue(10).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockSymbol> SYMBOL = REG.register("symbol", () -> new BlockSymbol(Block.Properties.create(Material.MISCELLANEOUS).lightValue(10).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockBigDrum> BIG_DRUM = REG.register("big_drum", () -> new BlockBigDrum(Block.Properties.create(Material.MISCELLANEOUS).lightValue(10).sound(SoundType.WOOD),Block.makeCuboidShape(0.0D, 0.0D, 2.0D, 16.0D, 16.0D, 11.0D)));
    public static final RegistryObject<BlockCrashSymbol> CRASH_SYMBOL = REG.register("crash_symbol", () -> new BlockCrashSymbol(Block.Properties.create(Material.MISCELLANEOUS).lightValue(10).sound(SoundType.WOOD),Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D)));
    public static final RegistryObject<BlockKeyboard> KEYBOARD = REG.register("keyboard", () -> new BlockKeyboard(Block.Properties.create(Material.MISCELLANEOUS).lightValue(10).sound(SoundType.WOOD),Block.makeCuboidShape(0.0D, 0.0D, 4.0D, 16.0D, 3.0D, 11.0D)));
    public static final RegistryObject<BlockDirectional> KEYBOARD_STAND = REG.register("keyboard_stand", () -> new BlockDirectional(Block.Properties.create(Material.MISCELLANEOUS).lightValue(10).sound(SoundType.WOOD),Block.makeCuboidShape(3.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockCowbell> COWBELL = REG.register("cowbell", () -> new BlockCowbell(Block.Properties.create(Material.MISCELLANEOUS).lightValue(10).sound(SoundType.WOOD),Block.makeCuboidShape(5.0D, 9.0D, 6.0D, 11.0D, 16.0D, 10.0D)));
    public static final RegistryObject<BlockRotational> BOOK_UPRIGHT_SINGLE = REG.register("book_upright_single", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D)));
    public static final RegistryObject<BlockRotational> BOOK_UPRIGHT_TRIO = REG.register("book_upright_trio", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D)));
    public static final RegistryObject<BlockRotational> BOOK_UPRIGHT_FOUR = REG.register("book_upright_four", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D)));
    public static final RegistryObject<BlockRotational> BOOK_MAGIC_UPRIGHT_SINGLE = REG.register("book_magic_upright_single", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 8.0D, 12.0D)));
    public static final RegistryObject<BlockRotational> BOOK_MAGIC_UPRIGHT_TRIO = REG.register("book_magic_upright_trio", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 8.0D, 13.0D)));
    public static final RegistryObject<BlockRotational> BOOK_MAGIC_UPRIGHT_FOUR = REG.register("book_magic_upright_four", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 8.0D, 14.0D)));
    public static final RegistryObject<BlockRotational> BOOK_LAID_SINGLE = REG.register("book_laid_single", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 3.0D, 12.0D)));
    public static final RegistryObject<BlockRotational> BOOK_LAID_DOUBLE = REG.register("book_laid_double", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 6.0D, 12.0D)));
    public static final RegistryObject<BlockRotational> BOOK_LAID_TRIPLE = REG.register("book_laid_triple", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 9.0D, 12.0D)));
    public static final RegistryObject<BlockDirectional> BLUE_CHINA_VASE_TALL = REG.register("blue_china_vase_tall", () -> new BlockDirectional(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(6.5D, 0.0D, 6.5D, 11.5D, 11.0D, 11.5D)));
    public static final RegistryObject<BlockDirectional> BLUE_CHINA_VASE_SHORT = REG.register("blue_china_vase_short", () -> new BlockDirectional(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(3.5D, 0.0D, 5.0D, 10.5D, 9.0D, 12.5D)));
    public static final RegistryObject<BlockDirectional> BLUE_CHINA_VASE_DOUBLE = REG.register("blue_china_vase_double", () -> new BlockDirectional(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(1.0D, 0.0D, 3.0D, 16.0D, 11.0D, 15.0D)));
    public static final RegistryObject<BlockDirectional> RED_CELEBRATION_VASE_TALL = REG.register("red_celebration_vase_tall", () -> new BlockDirectional(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(6.5D, 0.0D, 6.5D, 11.5D, 11.0D, 11.5D)));
    public static final RegistryObject<BlockDirectional> RED_CELEBRATION_VASE_SHORT = REG.register("red_celebration_vase_short", () -> new BlockDirectional(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(3.5D, 0.0D, 5.0D, 10.5D, 9.0D, 12.5D)));
    public static final RegistryObject<BlockDirectional> RED_CELEBRATION_VASE_DOUBLE = REG.register("red_celebration_vase_double", () -> new BlockDirectional(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(1.0D, 0.0D, 3.0D, 16.0D, 11.0D, 15.0D)));
    public static final RegistryObject<BlockRotationalTransparency> GIFT_SQUARE_PURPLE = REG.register("gift_square_purple", () -> new BlockRotationalTransparency(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D)));
    public static final RegistryObject<BlockRotationalTransparency> GIFT_TALL_RED = REG.register("gift_tall_red", () -> new BlockRotationalTransparency(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D)));
    public static final RegistryObject<BlockRotationalTransparency> GIFT_DOUBLE_ONE = REG.register("gift_double_one", () -> new BlockRotationalTransparency(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(1.0D, 0.0D, 1.0D, 15.0D, 12.0D, 15.0D)));
    public static final RegistryObject<BlockRotationalTransparency> GIFT_SQUARE_PINK = REG.register("gift_square_pink", () -> new BlockRotationalTransparency(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D)));
    public static final RegistryObject<BlockRotational> TV = REG.register("tv", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D)));
    public static final RegistryObject<BlockRotational> PINK_TV = REG.register("pink_tv", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D)));
    public static final RegistryObject<BlockRotational> CYAN_TV = REG.register("cyan_tv", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(3.0D, 0.0D, 3.0D, 13.0D, 10.0D, 13.0D)));
    public static final RegistryObject<BlockRotational> PIRATE_SIGN = REG.register("pirate_sign", () -> new BlockRotational(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D)));
    public static final RegistryObject<BlockDirectionalTransparency> WOODEN_WINDOW_BOX_TULIP = REG.register("wooden_window_box_tulip", () -> new BlockDirectionalTransparency(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 6.0D)));
    public static final RegistryObject<BlockDirectionalTransparency> WHITE_WOODEN_WINDOW_BOX_TULIP = REG.register("white_wooden_window_box_tulip", () -> new BlockDirectionalTransparency(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 6.0D)));
    public static final RegistryObject<BlockDirectionalTransparency> BLUE_WOODEN_WINDOW_BOX_TULIP = REG.register("blue_wooden_window_box_tulip", () -> new BlockDirectionalTransparency(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 6.0D)));
    public static final RegistryObject<BlockDirectionalTransparency> PINK_WOODEN_WINDOW_BOX_TULIP = REG.register("pink_wooden_window_box_tulip", () -> new BlockDirectionalTransparency(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 6.0D)));
    public static final RegistryObject<BlockDirectionalTransparency> YELLOW_WOODEN_WINDOW_BOX_TULIP = REG.register("yellow_wooden_window_box_tulip", () -> new BlockDirectionalTransparency(Block.Properties.create(Material.MISCELLANEOUS).sound(SoundType.STONE),Block.makeCuboidShape(0.0D, 9.0D, 0.0D, 16.0D, 16.0D, 6.0D)));




}