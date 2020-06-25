package com.ldshadowlady.things.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockRotationalTransparency extends HorizontalBlock {
    public static final IntegerProperty ROTATION;
    private final VoxelShape Shape;

    public BlockRotationalTransparency(Properties properties, VoxelShape ShapeIn) {
        super(properties);
        this.Shape = ShapeIn;
        this.setDefaultState(this.stateContainer.getBaseState().with(ROTATION, 0));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext p_196258_1_) {
        return this.getDefaultState().with(ROTATION, MathHelper.floor((double) ((180.0F + p_196258_1_.getPlacementYaw()) * 16.0F / 360.0F) + 0.5D) & 15);
    }

    public BlockState rotate(BlockState p_185499_1_, Rotation p_185499_2_) {
        return p_185499_1_.with(ROTATION, p_185499_2_.rotate(p_185499_1_.get(ROTATION), 16));
    }

    public BlockState mirror(BlockState p_185471_1_, Mirror p_185471_2_) {
        return p_185471_1_.with(ROTATION, p_185471_2_.mirrorRotation(p_185471_1_.get(ROTATION), 16));
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> p_206840_1_) {
        p_206840_1_.add(ROTATION);
    }

    static {
        ROTATION = BlockStateProperties.ROTATION_0_15;
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return this.Shape;
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }


}
