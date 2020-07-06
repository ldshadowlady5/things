package com.ldshadowlady.things.entities;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.ldshadowlady.things.Things.ID;

public class ThingsEntities {
    public static final DeferredRegister<EntityType<?>> REG = new DeferredRegister<>(ForgeRegistries.ENTITIES, ID);

    public static final RegistryObject<EntityType<ChairEntity>> CHAIR = REG.register("chair", () ->
        EntityType.Builder.create(ChairEntity::new, EntityClassification.MISC)
            .size(0.25F, 0.25F)
            .disableSummoning()
            .immuneToFire()
            .setUpdateInterval(Integer.MAX_VALUE)
            .setShouldReceiveVelocityUpdates(false)
            .build(ID + ":chair")
    );
}
