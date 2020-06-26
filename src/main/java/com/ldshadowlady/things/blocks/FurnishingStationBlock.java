package com.ldshadowlady.things.blocks;

import com.ldshadowlady.things.blockentities.FurnishingStationBlockEntity;
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
