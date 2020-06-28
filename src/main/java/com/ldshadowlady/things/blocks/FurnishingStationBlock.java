package com.ldshadowlady.things.blocks;

import com.ldshadowlady.things.blockentities.FurnishingStationBlockEntity;
import com.ldshadowlady.things.common.ItemHandlers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;

import javax.annotation.Nullable;

public class FurnishingStationBlock extends Block {
    public FurnishingStationBlock(Block.Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new FurnishingStationBlockEntity();
    }

    @Override
    public void onReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            TileEntity tileentity = world.getTileEntity(pos);
            if (tileentity instanceof FurnishingStationBlockEntity) {
                tileentity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(handler -> ItemHandlers.dropInventory(world, pos, handler));
            }
            super.onReplaced(state, world, pos, newState, isMoving);
        }
    }

    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult hit) {
        if (!world.isRemote) {
            TileEntity entity = world.getTileEntity(pos);
            if (entity instanceof FurnishingStationBlockEntity) {
                player.openContainer((INamedContainerProvider) entity);
            }
        }
        return true;
    }

    @Nullable
    @Override
    public INamedContainerProvider getContainer(BlockState state, World world, BlockPos pos) {
        TileEntity entity = world.getTileEntity(pos);
        if (entity instanceof INamedContainerProvider) {
            return (INamedContainerProvider) entity;
        }
        return null;
    }
}
