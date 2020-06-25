package com.ldshadowlady.things.blocks;

import com.ldshadowlady.things.common.VoxelShapeUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.WoodButtonBlock;
import net.minecraft.client.audio.SoundSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import static net.minecraft.state.properties.BlockStateProperties.LIT;

public class BlockDirectionalLamp extends HorizontalBlock {

    private final VoxelShape northShape;

    private final VoxelShape southShape;

    private final VoxelShape westShape;

    private final VoxelShape eastShape;


    public BlockDirectionalLamp(Properties properties, VoxelShape ShapeIn) {
        super(properties);
        this.northShape = ShapeIn;
        this.southShape = VoxelShapeUtils.rotateHorizontal (ShapeIn, Direction.SOUTH);
        this.westShape = VoxelShapeUtils.rotateHorizontal (ShapeIn, Direction.WEST);
        this.eastShape = VoxelShapeUtils.rotateHorizontal (ShapeIn, Direction.EAST);
        this.setDefaultState((BlockState)((BlockState)this.stateContainer.getBaseState()).with(LIT,false).with(HORIZONTAL_FACING, Direction.SOUTH));
    }

    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        activate(state, worldIn, pos);
        this.playSound(player, worldIn, pos);
        return true;
    }

    private static void activate(BlockState blockstate, World worldIn, BlockPos pos) {
        if (!blockstate.get(LIT)) {
            worldIn.setBlockState(pos, blockstate.with(LIT, Boolean.valueOf(true)));
        }
        else {
            worldIn.setBlockState(pos, blockstate.with(LIT, Boolean.valueOf(false)));
        }
    }

    protected void playSound(@Nullable PlayerEntity player, IWorld world, BlockPos pos) {
        world.playSound(player, pos, soundType.getPlaceSound(),SoundCategory.BLOCKS, 0.3F, 0.5F);
    }


    @Override
    public int getLightValue(BlockState blockstate) {
        return (Boolean)blockstate.get(LIT) ? super.getLightValue(blockstate) : 0;
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return (BlockState)this.getDefaultState().with(LIT,false).with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing());
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> state) {
        state.add(new IProperty[]{HORIZONTAL_FACING,LIT});
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
