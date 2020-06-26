package com.ldshadowlady.things.container;

import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.ldshadowlady.things.Things.ID;

public final class ThingsContainers {
    private ThingsContainers() {
    }

    public static final DeferredRegister<ContainerType<?>> REG = new DeferredRegister<>(ForgeRegistries.CONTAINERS, ID);

    public static final RegistryObject<ContainerType<FurnishingStationContainer>> FURNISHING_STATION = REG.register("furnishing_station", () -> new ContainerType<>(FurnishingStationContainer::new));
}
