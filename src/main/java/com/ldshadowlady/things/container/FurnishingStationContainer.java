package com.ldshadowlady.things.container;

import com.ldshadowlady.things.blocks.ThingsBlocks;
import com.ldshadowlady.things.furnishing.Furnishing;
import com.ldshadowlady.things.furnishing.FurnishingItem;
import com.ldshadowlady.things.furnishing.UnlockedFurnishing;
import com.ldshadowlady.things.lists.SoundList;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.SoundCategory;
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

    private long lastTakenTime = 0L;

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

            @Override
            public void onSlotChanged() {
                super.onSlotChanged();
                FurnishingStationContainer.this.onChanged();
            }
        });
        this.yellowDyeSlot = this.addSlot(new SlotItemHandler(station, 1, 11, 34) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return stack.getItem().isIn(Tags.Items.DYES_YELLOW);
            }

            @Override
            public void onSlotChanged() {
                super.onSlotChanged();
                FurnishingStationContainer.this.onChanged();
            }
        });
        this.blueDyeSlot = this.addSlot(new SlotItemHandler(station, 2, 11, 53) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return stack.getItem().isIn(Tags.Items.DYES_BLUE);
            }

            @Override
            public void onSlotChanged() {
                super.onSlotChanged();
                FurnishingStationContainer.this.onChanged();
            }
        });
        this.output = this.addSlot(new SlotItemHandler(new ItemStackHandler(1), 0, 146, 33) {
            @Override
            public boolean isItemValid(ItemStack stack) {
                return false;
            }

            @Override
            public ItemStack onTake(PlayerEntity player, ItemStack stack) {
                Item item = stack.getItem();
                if (item instanceof FurnishingItem) {
                    Furnishing furnishing = ((FurnishingItem) item).getFurnishing();
                    FurnishingStationContainer.this.redDyeSlot.decrStackSize(furnishing.getRed());
                    FurnishingStationContainer.this.yellowDyeSlot.decrStackSize(furnishing.getYellow());
                    FurnishingStationContainer.this.blueDyeSlot.decrStackSize(furnishing.getBlue());
                }
                stack.getItem().onCreated(stack, player.world, player);
                position.consume((world, pos) -> {
                    long time = world.getGameTime();
                    if (time != FurnishingStationContainer.this.lastTakenTime) {
                        world.playSound(null, pos, SoundList.UI_FURNISHING_STATION_TAKE_RESULT.orElseThrow(IllegalStateException::new), SoundCategory.BLOCKS, 1.0F, 1.0F);
                        FurnishingStationContainer.this.lastTakenTime = time;
                    }
                });
                return super.onTake(player, stack);
            }

            @Override
            public void onSlotChanged() {
                super.onSlotChanged();
                FurnishingStationContainer.this.onChanged();
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
            this.onChanged();
            return true;
        }
        return false;
    }

    @Override
    public boolean canMergeSlot(ItemStack stack, Slot slot) {
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

    public void onChanged() {
        this.updateOutput();
        this.detectAndSendChanges();
    }

    @Override
    public void onContainerClosed(PlayerEntity player) {
        super.onContainerClosed(player);
        this.furnishing.remove();
    }

    private void updateOutput() {
        int selection = this.selection.get();
        ItemStack output = ItemStack.EMPTY;
        if (selection > 0 && selection <= this.furnishing.getItems().size()) {
            ItemStack stack = this.furnishing.getItems().get(selection - 1);
            if (stack.getItem() instanceof FurnishingItem) {
                Furnishing furnishing = ((FurnishingItem) stack.getItem()).getFurnishing();
                if (this.redDyeSlot.getStack().getCount() >= furnishing.getRed() &&
                    this.yellowDyeSlot.getStack().getCount() >= furnishing.getYellow() &&
                    this.blueDyeSlot.getStack().getCount() >= furnishing.getBlue()) {
                    output = stack.copy();
                }
            }
        }
        if (!ItemStack.areItemStacksEqual(output, this.output.getStack())) {
            this.output.putStack(output);
        }
    }
}
