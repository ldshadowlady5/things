package com.ldshadowlady.things.blocks;

import com.ldshadowlady.things.common.VoxelShapeUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class BlockDirectional extends HorizontalBlock {

    private final VoxelShape northShape;

    private final VoxelShape southShape;

    private final VoxelShape westShape;

    private final VoxelShape eastShape;


    public BlockDirectional(Properties properties, VoxelShape ShapeIn) {
        super(properties);
        this.northShape = ShapeIn;
        this.southShape = VoxelShapeUtils.rotateHorizontal (ShapeIn, Direction.SOUTH);
        this.westShape = VoxelShapeUtils.rotateHorizontal (ShapeIn, Direction.WEST);
        this.eastShape = VoxelShapeUtils.rotateHorizontal (ShapeIn, Direction.EAST);
        this.setDefaultState((BlockState)((BlockState)this.stateContainer.getBaseState()).with(HORIZONTAL_FACING, Direction.SOUTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return (BlockState)this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite().getOpposite());
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> state) {
        state.add(new IProperty[]{HORIZONTAL_FACING});
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        switch (state.get(HORIZONTAL_FACING)) {
            case NORTH:
            default:
                return this.northShape;
            case SOUTH:
                return this.southShape;
            case WEST:
                return this.westShape;
            case EAST:
                return this.eastShape;
        }
    }

}
