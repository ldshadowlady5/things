package com.ldshadowlady.things.blocks;

import com.ldshadowlady.things.common.VoxelShapeUtils;
import com.ldshadowlady.things.lists.SoundList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockKeyboard extends HorizontalBlock {

    private final VoxelShape northShape;

    private final VoxelShape southShape;

    private final VoxelShape westShape;

    private final VoxelShape eastShape;


    public BlockKeyboard(Properties properties, VoxelShape ShapeIn) {
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

    public boolean onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        this.playSound(player, worldIn, pos);
        worldIn.addParticle(ParticleTypes.NOTE, pos.getX()+0.5, pos.getY()+0.3, pos.getZ()+0.5, 0.0D, 0.0D, 0.0D);
        return true;
    }

    protected void playSound(@Nullable PlayerEntity player, IWorld world, BlockPos pos) {
        world.playSound(player, pos, SoundList.KEYBOARD_SOUND.get(), SoundCategory.BLOCKS, 1F, 1F);
    }

}
