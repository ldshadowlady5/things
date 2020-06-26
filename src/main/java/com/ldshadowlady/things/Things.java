package com.ldshadowlady.things;

import com.ldshadowlady.things.blockentities.ThingsBlockEntities;
import com.ldshadowlady.things.blocks.ThingsBlocks;
import com.ldshadowlady.things.client.screen.FurnishingStationScreen;
import com.ldshadowlady.things.container.ThingsContainers;
import com.ldshadowlady.things.data.ThingsData;
import com.ldshadowlady.things.items.ThingsItems;
import com.ldshadowlady.things.lists.SoundList;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(Things.ID)
public class Things {
    public static final String ID = "lizziesthings";

    private static final Logger LOGGER = LogManager.getLogger();

    public Things() {
        SoundList.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ThingsBlocks.REG.register(FMLJavaModLoadingContext.get().getModEventBus());
        ThingsItems.REG.register(FMLJavaModLoadingContext.get().getModEventBus());
        ThingsBlockEntities.REG.register(FMLJavaModLoadingContext.get().getModEventBus());
        ThingsContainers.REG.register(FMLJavaModLoadingContext.get().getModEventBus());
        ThingsData.register(FMLJavaModLoadingContext.get().getModEventBus());
        DistExecutor.runWhenOn(Dist.CLIENT, () -> Client::init);
    }

    static class Client {
        @SuppressWarnings("deprecation")
        static void init() {
            FMLJavaModLoadingContext.get().getModEventBus().<FMLClientSetupEvent>addListener(e -> {
                DeferredWorkQueue.runLater(() -> {
                    ScreenManager.registerFactory(ThingsContainers.FURNISHING_STATION.orElseThrow(IllegalStateException::new), FurnishingStationScreen::new);
                });
            });
        }
    }
}
