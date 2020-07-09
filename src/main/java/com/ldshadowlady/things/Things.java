package com.ldshadowlady.things;

import com.ldshadowlady.things.blockentities.ThingsBlockEntities;
import com.ldshadowlady.things.blocks.ThingsBlocks;
import com.ldshadowlady.things.client.renderer.ChairRenderer;
import com.ldshadowlady.things.client.screen.FurnishingStationScreen;
import com.ldshadowlady.things.container.ThingsContainers;
import com.ldshadowlady.things.data.ThingsData;
import com.ldshadowlady.things.entities.ChairEntity;
import com.ldshadowlady.things.entities.ThingsEntities;
import com.ldshadowlady.things.entities.ai.LieOnCatBedGoal;
import com.ldshadowlady.things.items.ThingsItems;
import com.ldshadowlady.things.lists.SoundList;
import com.ldshadowlady.things.util.GoalAdder;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.entity.passive.CatEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
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
        ThingsEntities.REG.register(FMLJavaModLoadingContext.get().getModEventBus());
        ThingsItems.REG.register(FMLJavaModLoadingContext.get().getModEventBus());
        ThingsBlockEntities.REG.register(FMLJavaModLoadingContext.get().getModEventBus());
        ThingsContainers.REG.register(FMLJavaModLoadingContext.get().getModEventBus());
        ThingsData.register(FMLJavaModLoadingContext.get().getModEventBus());
        GoalAdder.mobGoal(CatEntity.class)
            .add(5, cat -> new LieOnCatBedGoal(cat, 1.1D, 8))
            .build(MinecraftForge.EVENT_BUS);
        DistExecutor.runWhenOn(Dist.CLIENT, () -> Client::init);
    }

    static class Client {
        @SuppressWarnings("deprecation")
        static void init() {
            FMLJavaModLoadingContext.get().getModEventBus().<FMLClientSetupEvent>addListener(e -> {
                RenderingRegistry.registerEntityRenderingHandler(ChairEntity.class, ChairRenderer::new);
                DeferredWorkQueue.runLater(() -> {
                    ScreenManager.registerFactory(ThingsContainers.FURNISHING_STATION.orElseThrow(IllegalStateException::new), FurnishingStationScreen::new);
                });
            });
        }
    }
}
