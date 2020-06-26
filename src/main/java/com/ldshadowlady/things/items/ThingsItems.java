package com.ldshadowlady.things.items;

import com.ldshadowlady.things.blocks.ThingsBlocks;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

import static com.ldshadowlady.things.Things.ID;

public final class ThingsItems {
    private ThingsItems() {
    }

    public static final DeferredRegister<Item> REG = new DeferredRegister<>(ForgeRegistries.ITEMS, ID);

    public static final RegistryObject<BlockItem> FURNISHING_STATION = REG.register("furnishing_station", ThingsItems.create(ThingsBlocks.FURNISHING_STATION));

    public static final RegistryObject<ThingsBlockItem> GRAVESTONE_MOON = REG.register("gravestone_moon", ThingsItems.create(ThingsBlocks.GRAVESTONE_MOON));
    public static final RegistryObject<ThingsBlockItem> GRAVESTONE_SKULL = REG.register("gravestone_skull", ThingsItems.create(ThingsBlocks.GRAVESTONE_SKULL));
    public static final RegistryObject<ThingsBlockItem> GRAVESTONE_HEART = REG.register("gravestone_heart", ThingsItems.create(ThingsBlocks.GRAVESTONE_HEART));
    public static final RegistryObject<ThingsBlockItem> GLOBE_GOLD = REG.register("globe_gold", ThingsItems.create(ThingsBlocks.GLOBE_GOLD));
    public static final RegistryObject<ThingsBlockItem> GLOBE_IRON = REG.register("globe_iron", ThingsItems.create(ThingsBlocks.GLOBE_IRON));
    public static final RegistryObject<ThingsBlockItem> GLOBE_ALT_GOLD = REG.register("globe_alt_gold", ThingsItems.create(ThingsBlocks.GLOBE_ALT_GOLD));
    public static final RegistryObject<ThingsBlockItem> GLOBE_ALT_IRON = REG.register("globe_alt_iron", ThingsItems.create(ThingsBlocks.GLOBE_ALT_IRON));
    public static final RegistryObject<ThingsBlockItem> MUSHROOM_LAMP_RED = REG.register("mushroom_lamp_red", ThingsItems.create(ThingsBlocks.MUSHROOM_LAMP_RED));
    public static final RegistryObject<ThingsBlockItem> CRYSTAL_BALL_PURPLE = REG.register("crystal_ball_purple", ThingsItems.create(ThingsBlocks.CRYSTAL_BALL_PURPLE));
    public static final RegistryObject<ThingsBlockItem> MAGENTA_DRUM = REG.register("magenta_drum", ThingsItems.create(ThingsBlocks.MAGENTA_DRUM));
    public static final RegistryObject<ThingsBlockItem> CYMBAL = REG.register("cymbal", ThingsItems.create(ThingsBlocks.CYMBAL));
    public static final RegistryObject<ThingsBlockItem> BIG_DRUM = REG.register("big_drum", ThingsItems.create(ThingsBlocks.BIG_DRUM));
    public static final RegistryObject<ThingsBlockItem> CRASH_CYMBAL = REG.register("crash_cymbal", ThingsItems.create(ThingsBlocks.CRASH_CYMBAL));
    public static final RegistryObject<ThingsBlockItem> KEYBOARD_STAND = REG.register("keyboard_stand", ThingsItems.create(ThingsBlocks.KEYBOARD_STAND));
    public static final RegistryObject<ThingsBlockItem> KEYBOARD = REG.register("keyboard", ThingsItems.create(ThingsBlocks.KEYBOARD));
    public static final RegistryObject<ThingsBlockItem> COWBELL = REG.register("cowbell", ThingsItems.create(ThingsBlocks.COWBELL));
    public static final RegistryObject<ThingsBlockItem> BOOK_UPRIGHT_SINGLE = REG.register("book_upright_single", ThingsItems.create(ThingsBlocks.BOOK_UPRIGHT_SINGLE));
    public static final RegistryObject<ThingsBlockItem> BOOK_UPRIGHT_TRIO = REG.register("book_upright_trio", ThingsItems.create(ThingsBlocks.BOOK_UPRIGHT_TRIO));
    public static final RegistryObject<ThingsBlockItem> BOOK_UPRIGHT_FOUR = REG.register("book_upright_four", ThingsItems.create(ThingsBlocks.BOOK_UPRIGHT_FOUR));
    public static final RegistryObject<ThingsBlockItem> BOOK_MAGIC_UPRIGHT_SINGLE = REG.register("book_magic_upright_single", ThingsItems.create(ThingsBlocks.BOOK_MAGIC_UPRIGHT_SINGLE));
    public static final RegistryObject<ThingsBlockItem> BOOK_MAGIC_UPRIGHT_TRIO = REG.register("book_magic_upright_trio", ThingsItems.create(ThingsBlocks.BOOK_MAGIC_UPRIGHT_TRIO));
    public static final RegistryObject<ThingsBlockItem> BOOK_MAGIC_UPRIGHT_FOUR = REG.register("book_magic_upright_four", ThingsItems.create(ThingsBlocks.BOOK_MAGIC_UPRIGHT_FOUR));
    public static final RegistryObject<ThingsBlockItem> BOOK_LAID_SINGLE = REG.register("book_laid_single", ThingsItems.create(ThingsBlocks.BOOK_LAID_SINGLE));
    public static final RegistryObject<ThingsBlockItem> BOOK_LAID_DOUBLE = REG.register("book_laid_double", ThingsItems.create(ThingsBlocks.BOOK_LAID_DOUBLE));
    public static final RegistryObject<ThingsBlockItem> BOOK_LAID_TRIPLE = REG.register("book_laid_triple", ThingsItems.create(ThingsBlocks.BOOK_LAID_TRIPLE));
    public static final RegistryObject<ThingsBlockItem> BLUE_CHINA_VASE_TALL = REG.register("blue_china_vase_tall", ThingsItems.create(ThingsBlocks.BLUE_CHINA_VASE_TALL));
    public static final RegistryObject<ThingsBlockItem> BLUE_CHINA_VASE_SHORT = REG.register("blue_china_vase_short", ThingsItems.create(ThingsBlocks.BLUE_CHINA_VASE_SHORT));
    public static final RegistryObject<ThingsBlockItem> BLUE_CHINA_VASE_DOUBLE = REG.register("blue_china_vase_double", ThingsItems.create(ThingsBlocks.BLUE_CHINA_VASE_DOUBLE));
    public static final RegistryObject<ThingsBlockItem> RED_CELEBRATION_VASE_TALL = REG.register("red_celebration_vase_tall", ThingsItems.create(ThingsBlocks.RED_CELEBRATION_VASE_TALL));
    public static final RegistryObject<ThingsBlockItem> RED_CELEBRATION_VASE_SHORT = REG.register("red_celebration_vase_short", ThingsItems.create(ThingsBlocks.RED_CELEBRATION_VASE_SHORT));
    public static final RegistryObject<ThingsBlockItem> RED_CELEBRATION_VASE_DOUBLE = REG.register("red_celebration_vase_double", ThingsItems.create(ThingsBlocks.RED_CELEBRATION_VASE_DOUBLE));
    public static final RegistryObject<ThingsBlockItem> GIFT_SQUARE_PURPLE = REG.register("gift_square_purple", ThingsItems.create(ThingsBlocks.GIFT_SQUARE_PURPLE));
    public static final RegistryObject<ThingsBlockItem> GIFT_TALL_RED = REG.register("gift_tall_red", ThingsItems.create(ThingsBlocks.GIFT_TALL_RED));
    public static final RegistryObject<ThingsBlockItem> GIFT_DOUBLE_ONE = REG.register("gift_double_one", ThingsItems.create(ThingsBlocks.GIFT_DOUBLE_ONE));
    public static final RegistryObject<ThingsBlockItem> GIFT_SQUARE_PINK = REG.register("gift_square_pink", ThingsItems.create(ThingsBlocks.GIFT_SQUARE_PINK));

    public static final RegistryObject<ThingsBlockItem> TV = REG.register("tv", ThingsItems.create(ThingsBlocks.TV));
    public static final RegistryObject<ThingsBlockItem> PINK_TV = REG.register("pink_tv", ThingsItems.create(ThingsBlocks.PINK_TV));
    public static final RegistryObject<ThingsBlockItem> CYAN_TV = REG.register("cyan_tv", ThingsItems.create(ThingsBlocks.CYAN_TV));
    public static final RegistryObject<ThingsBlockItem> PIRATE_SIGN = REG.register("pirate_sign", ThingsItems.create(ThingsBlocks.PIRATE_SIGN));
    public static final RegistryObject<ThingsBlockItem> WOODEN_WINDOW_BOX_TULIP = REG.register("wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.WOODEN_WINDOW_BOX_TULIP));
    public static final RegistryObject<ThingsBlockItem> WHITE_WOODEN_WINDOW_BOX_TULIP = REG.register("white_wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.WHITE_WOODEN_WINDOW_BOX_TULIP));
    public static final RegistryObject<ThingsBlockItem> BLUE_WOODEN_WINDOW_BOX_TULIP = REG.register("blue_wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.BLUE_WOODEN_WINDOW_BOX_TULIP));
    public static final RegistryObject<ThingsBlockItem> PINK_WOODEN_WINDOW_BOX_TULIP = REG.register("pink_wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.PINK_WOODEN_WINDOW_BOX_TULIP));
    public static final RegistryObject<ThingsBlockItem> YELLOW_WOODEN_WINDOW_BOX_TULIP = REG.register("yellow_wooden_window_box_tulip", ThingsItems.create(ThingsBlocks.YELLOW_WOODEN_WINDOW_BOX_TULIP));


    public static final ItemGroup THINGS = new ThingsItemGroup();

    private static Item.Properties defaultProperties() {
        return new Item.Properties().group(THINGS);
    }

    private static Supplier<ThingsBlockItem> create(final RegistryObject<? extends Block> block) {
        return () -> new ThingsBlockItem(block.orElseThrow(IllegalStateException::new), defaultProperties());
    }

}

