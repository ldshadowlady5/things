package com.ldshadowlady.things.client.screen;

import com.ldshadowlady.things.Things;
import com.ldshadowlady.things.container.FurnishingStationContainer;
import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.multiplayer.ClientAdvancementManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FurnishingStationScreen extends ContainerScreen<FurnishingStationContainer> implements ClientAdvancementManager.IListener {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Things.ID, "textures/gui/container/furnishing_station.png");

    private static final int ROWS = 3;

    private static final int COLUMNS = 5;

    private static final int TILE = 18;

    @Nullable
    private ClientAdvancementManager advancementManager;

    private boolean scrolling;

    private float scroll;

    private List<ItemStack> items = new ArrayList<>();

    public FurnishingStationScreen(FurnishingStationContainer station, PlayerInventory inventory, ITextComponent title) {
        super(station, inventory, title);
        this.advancementManager = inventory.player instanceof ClientPlayerEntity ? ((ClientPlayerEntity) inventory.player).connection.getAdvancementManager() : null;
    }

    @Override
    public void init(final Minecraft minecraft, final int width, final int height) {
        super.init(minecraft, width, height);
        this.items.clear();
        if (this.advancementManager != null) {
            this.advancementManager.setListener(this);
        }
    }

    @Override
    public void removed() {
        super.removed();
        if (this.advancementManager != null) {
            this.advancementManager.setListener(null);
        }
    }

    private boolean canScroll() {
        return this.items.size() > ROWS * COLUMNS;
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
        int k = (int) (41.0F * this.scroll);
        this.blit(x + 123, y + 15 + k, 232 + (this.canScroll() ? 0 : 12), 0, 12, 15);
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
            if (index <= this.items.size()) {
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
            if (index <= this.items.size()) {
                this.minecraft.getItemRenderer().renderItemAndEffectIntoGUI(this.items.get(index - 1), tx + 1, ty + 1);
            }
        }
        RenderHelper.disableStandardItemLighting();
    }

    private int computeScrollOffset() {
        return 1 + (int) (this.scroll * (this.items.size() / COLUMNS) + 0.5D) * COLUMNS;
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
            if (ordinal <= this.items.size() && ordinal != this.container.getSelection() && x >= 0 && y >= 0 && x < TILE && y < TILE && this.container.enchantItem(this.minecraft.player, ordinal)) {
                Minecraft.getInstance().getSoundHandler().play(SimpleSound.master(SoundEvents.UI_LOOM_SELECT_PATTERN, 1.0F));
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
    public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
        if (this.canScroll()) {
            this.scroll = MathHelper.clamp((float) (this.scroll - delta / (this.items.size() - COLUMNS)), 0.0F, 1.0F);
        }
        return true;
    }

    @Override
    public void rootAdvancementAdded(Advancement advancement) {
    }

    @Override
    public void rootAdvancementRemoved(Advancement advancement) {
    }

    @Override
    public void nonRootAdvancementAdded(Advancement advancement) {
    }

    @Override
    public void nonRootAdvancementRemoved(Advancement advancement) {
    }

    @Override
    public void advancementsCleared() {
        this.items.clear();
    }

    @Override
    public void onUpdateAdvancementProgress(Advancement advancement, AdvancementProgress progress) {
        Advancement parent = advancement.getParent();
        if (parent != null && parent.getId().equals(new ResourceLocation(Things.ID, "furnishing/root")) && progress.isDone()) {
            String p = advancement.getId().getPath();
            final Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(advancement.getId().getNamespace(), p.substring(p.indexOf('/') + 1)));
            if (item != Items.AIR) {
                this.items.add(new ItemStack(item));
                this.items.sort(Comparator.comparing(stack -> stack.getItem().getRegistryName()));
            }
        }
    }

    @Override
    public void setSelectedTab(@Nullable Advancement advancement) {
    }
}
