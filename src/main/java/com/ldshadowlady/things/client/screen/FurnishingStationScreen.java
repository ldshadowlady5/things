package com.ldshadowlady.things.client.screen;

import com.ldshadowlady.things.Things;
import com.ldshadowlady.things.container.FurnishingStationContainer;
import com.ldshadowlady.things.lists.SoundList;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;

public class FurnishingStationScreen extends ContainerScreen<FurnishingStationContainer> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Things.ID, "textures/gui/container/furnishing_station.png");

    private static final int ROWS = 3;

    private static final int COLUMNS = 5;

    private static final int TILE = 18;

    private boolean scrolling;

    private float scroll;

    public FurnishingStationScreen(FurnishingStationContainer station, PlayerInventory inventory, ITextComponent title) {
        super(station, inventory, title);
    }

    private boolean canScroll() {
        return this.container.getFurnishings().size() > ROWS * COLUMNS;
    }

    @Override
    public void render(int mouseX, int mouseY, float delta) {
        super.render(mouseX, mouseY, delta);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.font.drawString(this.title.getFormattedText(), 8.0F, 5.0F, 0x404040);
        this.font.drawString(this.playerInventory.getDisplayName().getFormattedText(), 8.0F, this.ySize - 94.0F, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float delta, int mouseX, int mouseY) {
        this.renderBackground();
        GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.minecraft.getTextureManager().bindTexture(TEXTURE);
        int x = this.guiLeft;
        int y = this.guiTop;
        this.blit(x, y, 0, 0, this.xSize, this.ySize);
        Slot red = this.container.getRedDyeSlot();
        Slot yellow = this.container.getYellowDyeSlot();
        Slot blue = this.container.getBlueDyeSlot();
        if (!red.getHasStack()) this.blit(x + red.xPos, y + red.yPos, this.xSize, 0, 16, 16);
        if (!yellow.getHasStack()) this.blit(x + yellow.xPos, y + yellow.yPos, this.xSize + 16, 0, 16, 16);
        if (!blue.getHasStack()) this.blit(x + blue.xPos, y + blue.yPos, this.xSize + 32, 0, 16, 16);
        this.blit(x + 123, y + 15 + (int) (39.0F * this.scroll), 232 + (this.canScroll() ? 0 : 12), 0, 12, 15);
        this.renderItemGrid(mouseX, mouseY);
    }

    private void renderItemGrid(final int mouseX, final int mouseY) {
        int gridX = this.guiLeft + 30;
        int gridY = this.guiTop + 15;
        int offset = this.computeScrollOffset();
        for (int i = 0; i < ROWS * COLUMNS; i++) {
            int tx = gridX + i % COLUMNS * TILE;
            int ty = gridY + i / COLUMNS * TILE;
            int index = offset + i;
            if (index <= this.container.getFurnishings().size()) {
                int v = this.ySize;
                if (index == this.container.getSelection()) {
                    v += TILE;
                } else if (mouseX >= tx && mouseY >= ty && mouseX < tx + TILE && mouseY < ty + TILE) {
                    v += 2 * TILE;
                }
                this.blit(tx, ty, 0, v, TILE, TILE);
            }
        }
        RenderHelper.enableGUIStandardItemLighting();
        for (int i = 0; i < ROWS * COLUMNS; i++) {
            int tx = gridX + i % COLUMNS * TILE;
            int ty = gridY + i / COLUMNS * TILE;
            int index = offset + i;
            if (index <= this.container.getFurnishings().size()) {
                this.minecraft.getItemRenderer().renderItemAndEffectIntoGUI(this.container.getFurnishings().get(index - 1), tx + 1, ty + 1);
            }
        }
        RenderHelper.disableStandardItemLighting();
    }

    private int computeScrollOffset() {
        return 1 + (int) (this.scroll * (this.container.getFurnishings().size() / COLUMNS) + 0.5D) * COLUMNS;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.scrolling = false;
        int gridX = this.guiLeft + 30;
        int gridY = this.guiTop + 15;
        int offset = this.computeScrollOffset();
        for(int i = 0; i < ROWS * COLUMNS; i++) {
            double x = mouseX - (gridX + i % COLUMNS * TILE);
            double y = mouseY - (gridY + i / COLUMNS * TILE);
            int ordinal = offset + i;
            if (ordinal <= this.container.getFurnishings().size() && ordinal != this.container.getSelection() && x >= 0 && y >= 0 && x < TILE && y < TILE && this.container.enchantItem(this.minecraft.player, ordinal)) {
                Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundList.UI_FURNISHING_STATION_SELECT_FURNISHING.orElseThrow(IllegalStateException::new), 1.0F));
                this.minecraft.playerController.sendEnchantPacket(this.container.windowId, ordinal);
                return true;
            }
        }
        if (this.canScroll()) {
            int thumbX = this.guiLeft + 123;
            int thumbY = this.guiTop + 15;
            if (mouseX >= thumbX && mouseX < (thumbX + 12) && mouseY >= thumbY && mouseY < (thumbY + 56)) {
                this.scrolling = true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (this.scrolling && this.canScroll()) {
            int x = this.guiTop + 15;
            this.scroll = MathHelper.clamp(((float) mouseY - x - 7.5F) / (54.0F - 15.0F), 0.0F, 1.0F);
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        if (this.canScroll()) {
            this.scroll = MathHelper.clamp((float) (this.scroll - delta / (this.container.getFurnishings().size() / COLUMNS)), 0.0F, 1.0F);
        }
        return true;
    }
}
