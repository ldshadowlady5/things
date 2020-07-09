package com.ldshadowlady.things.blocks;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.ldshadowlady.things.entities.ChairEntity;
import com.ldshadowlady.things.entities.ThingsEntities;
import com.ldshadowlady.things.util.VoxelShapeHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class BlockLargeWindow extends HorizontalBlock {

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public BlockLargeWindow(Properties properties) {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.SOUTH));
        SHAPES = this.generateShapes(this.getStateContainer().getValidStates());
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite().getOpposite());
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> state) {
        state.add(HORIZONTAL_FACING);
    }

    private ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] ShapeIn1 = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.makeCuboidShape(0, 0, 11, 32, 32, 7), Direction.SOUTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
            Direction direction = state.get(HORIZONTAL_FACING);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(ShapeIn1[direction.getHorizontalIndex()]);

            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context)
    {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getRenderShape(BlockState state, IBlockReader reader, BlockPos pos)
    {
        return SHAPES.get(state);
    }
    
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }



}
