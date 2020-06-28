package com.ldshadowlady.things.items;

import com.ldshadowlady.things.furnishing.Furnishing;
import com.ldshadowlady.things.furnishing.FurnishingItem;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;

public class ThingsBlockItem extends BlockItem implements FurnishingItem {
    private final Furnishing furnishing;

    public ThingsBlockItem(Block block, Properties properties, Furnishing furnishing) {
        super(block, properties);
        this.furnishing = furnishing;
    }

    @Override
    public Furnishing getFurnishing() {
        return this.furnishing;
    }
}
