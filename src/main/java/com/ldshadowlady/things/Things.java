package com.ldshadowlady.things;

import com.ldshadowlady.things.blocks.ThingsBlocks;
import com.ldshadowlady.things.items.ThingsItems;
import com.ldshadowlady.things.lists.SoundList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Things.modid)
public class Things {
    public static final String modid = "lizziesthings";

    private static final Logger LOGGER = LogManager.getLogger();

    public Things() {
        ThingsBlocks.REG.register(FMLJavaModLoadingContext.get().getModEventBus());
        ThingsItems.REG.register(FMLJavaModLoadingContext.get().getModEventBus());
        SoundList.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
