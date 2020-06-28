package com.ldshadowlady.things.blockentities;

import com.ldshadowlady.things.container.FurnishingStationContainer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

public class FurnishingStationBlockEntity extends TileEntity implements INamedContainerProvider {
    private final ItemStackHandler stacks = new ItemStackHandler(3) {
        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            switch (slot) {
                default:
                    return false;
                case 0:
                    return stack.getItem().isIn(Tags.Items.DYES_RED);
                case 1:
                    return stack.getItem().isIn(Tags.Items.DYES_YELLOW);
                case 2:
                    return stack.getItem().isIn(Tags.Items.DYES_BLUE);
            }
        }

        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            FurnishingStationBlockEntity.this.markDirty();
        }

        @Override
        public CompoundNBT serializeNBT() {
            CompoundNBT tag = super.serializeNBT();
            tag.remove("Size");
            return tag;
        }

        @Override
        public void deserializeNBT(CompoundNBT nbt) {
            nbt.remove("Size");
            super.deserializeNBT(nbt);
        }
    };

    private final LazyOptional<IItemHandler> lazy = LazyOptional.of(() -> this.stacks);

    public FurnishingStationBlockEntity() {
        super(ThingsBlockEntities.FURNISHING_STATION.orElseThrow(IllegalStateException::new));
    }

    @Override
    public ITextComponent getDisplayName() {
        return new TranslationTextComponent("container.lizziesthings.furnishing_station");
    }

    @Override
    public Container createMenu(int id, PlayerInventory playerInventory, PlayerEntity player) {
        //noinspection ConstantConditions
        return new FurnishingStationContainer(id, playerInventory, this.stacks, IWorldPosCallable.of(this.world, this.pos));
    }

    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return this.lazy.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        compound.merge(this.stacks.serializeNBT());
        return compound;
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.stacks.deserializeNBT(compound);
    }

    @Override
    public void remove() {
        super.remove();
        this.lazy.invalidate();
    }
}
