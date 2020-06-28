package com.ldshadowlady.things.common;

import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;

public final class ItemHandlers {
    private ItemHandlers() {
    }

    public static void dropInventory(World world, BlockPos pos, IItemHandler handler) {
        for (int i = 0; i < handler.getSlots(); i++) {
            ItemStack stack = handler.extractItem(i, handler.getSlotLimit(i), false);
            InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
        }
    }
}
