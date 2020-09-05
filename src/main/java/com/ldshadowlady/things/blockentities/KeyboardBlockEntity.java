package com.ldshadowlady.things.blockentities;

import com.ldshadowlady.things.furnishing.FurnishingItemList;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;

public class KeyboardBlockEntity extends TileEntity {
    private final int[] mask = { 0x7f, 0xff, 0xff, 0xbf, 0xff, 0xff, 0xff, 0xdf, 0xe0 };

    private int state = 0xfe;

    public KeyboardBlockEntity() {
        super(ThingsBlockEntities.KEYBOARD.orElseThrow(IllegalStateException::new));
    }

    public void onPlay(PlayerEntity player, int note) {
        if (player instanceof ServerPlayerEntity && note >= 10 && note <= 18 && ((this.state = (this.state | this.mask[note - 10]) << 1) & 0x100) == 0) {
            int granted = grant((ServerPlayerEntity) player, FurnishingItemList.ROOT);
            if (granted > 0) {
                player.sendMessage(new TranslationTextComponent("things.true_shadow_cadet", granted).applyTextStyles(TextFormatting.LIGHT_PURPLE, TextFormatting.ITALIC));
            }
        }
    }

    private static int grant(ServerPlayerEntity player, ResourceLocation advancement) {
        PlayerAdvancements advancements = player.getAdvancements();
        Advancement root = player.server.getAdvancementManager().getAdvancement(advancement);
        int granted = 0;
        if (root != null) {
            for (Advancement child : root.getChildren()) {
                AdvancementProgress progress = advancements.getProgress(child);
                if (!progress.isDone()) {
                    for (String criterion : progress.getRemaningCriteria()) {
                        if (advancements.grantCriterion(child, criterion)) {
                            granted++;
                        }
                    }
                }
            }
        }
        return granted;
    }
}
