package com.ldshadowlady.things.lists;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.ldshadowlady.things.Things.ID;


public class SoundList {

    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, ID);

    public static final RegistryObject<SoundEvent> MAGENTA_DRUM_SOUND = SOUNDS.register("block.magenta_drum", () -> new SoundEvent(new ResourceLocation(ID, "block.magenta_drum")));
    public static final RegistryObject<SoundEvent> COWBELL_SOUND = SOUNDS.register("block.cowbell", () -> new SoundEvent(new ResourceLocation(ID, "block.cowbell")));
    public static final RegistryObject<SoundEvent> BIG_DRUM_SOUND = SOUNDS.register("block.big_drum", () -> new SoundEvent(new ResourceLocation(ID, "block.big_drum")));
    public static final RegistryObject<SoundEvent> CYMBAL_SOUND = SOUNDS.register("block.cymbal", () -> new SoundEvent(new ResourceLocation(ID, "block.cymbal")));
    public static final RegistryObject<SoundEvent> CRASH_CYMBAL_SOUND = SOUNDS.register("block.crash_cymbal", () -> new SoundEvent(new ResourceLocation(ID, "block.crash_cymbal")));
    public static final RegistryObject<SoundEvent> KEYBOARD_SOUND = SOUNDS.register("block.keyboard", () -> new SoundEvent(new ResourceLocation(ID, "block.keyboard")));


}
