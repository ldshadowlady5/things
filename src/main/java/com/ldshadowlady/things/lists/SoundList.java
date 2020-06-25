package com.ldshadowlady.things.lists;

import static com.ldshadowlady.things.Things.modid;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class SoundList {

    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, modid);

    public static final RegistryObject<SoundEvent> MAGENTA_DRUM_SOUND = SOUNDS.register("block.magenta_drum",() -> new SoundEvent(new ResourceLocation(modid, "block.magenta_drum")));
    public static final RegistryObject<SoundEvent> COWBELL_SOUND = SOUNDS.register("block.cowbell",() -> new SoundEvent(new ResourceLocation(modid, "block.cowbell")));
    public static final RegistryObject<SoundEvent> BIG_DRUM_SOUND = SOUNDS.register("block.big_drum",() -> new SoundEvent(new ResourceLocation(modid, "block.big_drum")));
    public static final RegistryObject<SoundEvent> SYMBOL_SOUND = SOUNDS.register("block.symbol",() -> new SoundEvent(new ResourceLocation(modid, "block.symbol")));
    public static final RegistryObject<SoundEvent> CRASH_SYMBOL_SOUND = SOUNDS.register("block.crash_symbol",() -> new SoundEvent(new ResourceLocation(modid, "block.crash_symbol")));
    public static final RegistryObject<SoundEvent> KEYBOARD_SOUND = SOUNDS.register("block.keyboard",() -> new SoundEvent(new ResourceLocation(modid, "block.keyboard")));



}
