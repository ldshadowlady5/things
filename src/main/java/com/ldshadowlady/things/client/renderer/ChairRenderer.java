package com.ldshadowlady.things.client.renderer;

import com.ldshadowlady.things.entities.ChairEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class ChairRenderer extends EntityRenderer<ChairEntity> {
    public ChairRenderer(final EntityRendererManager manager) {
        super(manager);
    }

    @Override
    public void doRender(final ChairEntity postilion, final double x, final double y, final double z, final float yaw, final float delta) {
    }

    @Nullable
    @Override
    protected ResourceLocation getEntityTexture(final ChairEntity postilion) {
        return null;
    }
}
