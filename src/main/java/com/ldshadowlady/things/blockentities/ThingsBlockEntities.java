package com.ldshadowlady.things.blockentities;

import com.ldshadowlady.things.blocks.ThingsBlocks;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.ldshadowlady.things.Things.ID;

public final class ThingsBlockEntities {
    private ThingsBlockEntities() {
    }

    public static final DeferredRegister<TileEntityType<?>> REG = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, ID);

    public static final RegistryObject<TileEntityType<FurnishingStationBlockEntity>> FURNISHING_STATION = REG.register("furnishing_station", () ->
        TileEntityType.Builder.create(FurnishingStationBlockEntity::new, ThingsBlocks.FURNISHING_STATION.orElseThrow(IllegalStateException::new)).build(null)
    );
}
