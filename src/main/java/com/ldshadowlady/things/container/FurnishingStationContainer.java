package com.ldshadowlady.things.container;

import com.ldshadowlady.things.blocks.ThingsBlocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.Tags;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

import java.util.List;

public class FurnishingStationContainer extends Container {
    private final IWorldPosCallable position;

    private final IntReferenceHolder selection = IntReferenceHolder.single();

    private final Slot redDyeSlot;

    private final Slot yellowDyeSlot;

    private final Slot blueDyeSlot;

    private final Slot output;

    private final UnlockedFurnishing furnishing;

    public FurnishingStationContainer(int id, PlayerInventory player) {
        this(id, player, new ItemStackHandler(3), IWorldPosCallable.DUMMY);
    }

    public FurnishingStationContainer(int id, PlayerInventory inventory, IItemHandler station, IWorldPosCallable position) {
        super(ThingsContainers.FURNISHING_STATION.orElseThrow(IllegalStateException::new), id);
        this.position = position;
        this.redDyeSlot = this.addSlot(new SlotItemHandler(station, 0, 11, 15) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return stack.getItem().isIn(Tags.Items.DYES_RED);
            }
        });
        this.yellowDyeSlot = this.addSlot(new SlotItemHandler(station, 1, 11, 34) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return stack.getItem().isIn(Tags.Items.DYES_YELLOW);
            }
        });
        this.blueDyeSlot = this.addSlot(new SlotItemHandler(station, 2, 11, 53) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return stack.getItem().isIn(Tags.Items.DYES_BLUE);
            }
        });
        this.output = this.addSlot(new SlotItemHandler(new ItemStackHandler(1), 0, 146, 33) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }

            @Override
            public ItemStack onTake(PlayerEntity thePlayer, ItemStack stack) {
                FurnishingStationContainer.this.redDyeSlot.decrStackSize(1);
                FurnishingStationContainer.this.yellowDyeSlot.decrStackSize(1);
                FurnishingStationContainer.this.blueDyeSlot.decrStackSize(1);
                position.consume((world, pos) -> {
                    // TODO: take sound
                    world.playSound(null, pos, SoundEvents.UI_LOOM_TAKE_RESULT, SoundCategory.BLOCKS, 1.0F, 1.0F);
                });
                return super.onTake(thePlayer, stack);
            }
        });
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlot(new Slot(inventory, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
        for (int col = 0; col < 9; col++) {
            this.addSlot(new Slot(inventory, col, 8 + col * 18, 142));
        }
        this.trackInt(this.selection);
        this.furnishing = UnlockedFurnishing.get(inventory.player);
        this.furnishing.init();
    }

    public List<? extends ItemStack> getFurnishings() {
        return this.furnishing.getItems();
    }

    public Slot getRedDyeSlot() {
        return this.redDyeSlot;
    }

    public Slot getYellowDyeSlot() {
        return this.yellowDyeSlot;
    }

    public Slot getBlueDyeSlot() {
        return this.blueDyeSlot;
    }

    public int getSelection() {
        return this.selection.get();
    }

    @Override
    public boolean canInteractWith(PlayerEntity player) {
        return isWithinUsableDistance(this.position, player, ThingsBlocks.FURNISHING_STATION.orElseThrow(IllegalStateException::new));
    }

    @Override
    public boolean enchantItem(PlayerEntity player, int value) {
        if (value > 0 && value <= this.furnishing.getItems().size()) {
            this.selection.set(value);
            this.updateOutput();
            return true;
        }
        return false;
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity player, int index) {
        ItemStack result = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack stack = slot.getStack();
            result = stack.copy();
            if (index == this.output.slotNumber) {
                if (!this.mergeItemStack(stack, 4, 40, true)) {
                    return ItemStack.EMPTY;
                }
                slot.onSlotChange(stack, result);
            } else if (index != this.redDyeSlot.slotNumber && index != this.yellowDyeSlot.slotNumber && index != this.blueDyeSlot.slotNumber) {
                if (stack.getItem().isIn(Tags.Items.DYES_RED)) {
                    if (!this.mergeItemStack(stack, this.redDyeSlot.slotNumber, this.redDyeSlot.slotNumber + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (stack.getItem().isIn(Tags.Items.DYES_YELLOW)) {
                    if (!this.mergeItemStack(stack, this.yellowDyeSlot.slotNumber, this.yellowDyeSlot.slotNumber + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (stack.getItem().isIn(Tags.Items.DYES_BLUE)) {
                    if (!this.mergeItemStack(stack, this.blueDyeSlot.slotNumber, this.blueDyeSlot.slotNumber + 1, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 4 && index < 31) {
                    if (!this.mergeItemStack(stack, 31, 40, false)) {
                        return ItemStack.EMPTY;
                    }
                } else if (index >= 31 && index < 40 && !this.mergeItemStack(stack, 4, 31, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(stack, 4, 40, false)) {
                return ItemStack.EMPTY;
            }
            if (stack.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
            if (stack.getCount() == result.getCount()) {
                return ItemStack.EMPTY;
            }
            slot.onTake(player, stack);
        }
        return result;
    }

    @Override
    public void onCraftMatrixChanged(IInventory inventory) {
        this.updateOutput();
        super.onCraftMatrixChanged(inventory);
    }

    @Override
    public void onContainerClosed(PlayerEntity player) {
        super.onContainerClosed(player);
        this.furnishing.remove();
    }

    private void updateOutput() {
        int selection = this.selection.get();
        if (selection > 0 && selection <= this.furnishing.getItems().size()) {
            this.output.putStack(this.furnishing.getItems().get(selection - 1));
        } else {
            this.output.putStack(ItemStack.EMPTY);
        }
    }
}
