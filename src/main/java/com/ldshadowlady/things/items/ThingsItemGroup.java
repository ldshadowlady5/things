package com.ldshadowlady.things.items;

import com.ldshadowlady.things.blocks.ThingsBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ThingsItemGroup extends ItemGroup {

    public ThingsItemGroup() {
        super("lizziesthings");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ThingsBlocks.GRAVESTONE_MOON.get());
    }
}
