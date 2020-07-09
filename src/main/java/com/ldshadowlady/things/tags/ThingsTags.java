package com.ldshadowlady.things.tags;

import com.ldshadowlady.things.Things;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public final class ThingsTags {
    private ThingsTags() {
    }

    public static final Tag<Block> PET_BEDS = new BlockTags.Wrapper(new ResourceLocation(Things.ID, "pet_beds"));
}
