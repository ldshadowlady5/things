package com.ldshadowlady.things.blocks;

import com.ldshadowlady.things.common.VoxelShapeUtils;
import com.ldshadowlady.things.lists.SoundList;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
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
        this.southShape = VoxelShapeUtils.rotateHorizontal(ShapeIn, Direction.SOUTH);
        this.westShape = VoxelShapeUtils.rotateHorizontal(ShapeIn, Direction.WEST);
        this.eastShape = VoxelShapeUtils.rotateHorizontal(ShapeIn, Direction.EAST);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.SOUTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> state) {
        state.add(HORIZONTAL_FACING);
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

    @Override
    public boolean onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!world.isRemote) {
            Vec3d start = player.getEyePosition(1.0F);
            Vec3d end = start.add(player.getLook(1.0F).scale(2.0D));
            Direction facing = state.get(HORIZONTAL_FACING);
            VoxelShape keys = VoxelShapeUtils.rotateHorizontal(Block.makeCuboidShape(0.5D, 0.0D, 8.0D, 15.5D, 1.0D, 11.5D), facing);
            BlockRayTraceResult result = keys.rayTrace(start, end, pos);
            if (result != null && result.getType() == RayTraceResult.Type.BLOCK) {
                Vec3d p = result.getHitVec();
                double lx = facing == Direction.NORTH || facing == Direction.SOUTH ? p.x - pos.getX() : p.z - pos.getZ();
                if (facing == Direction.SOUTH || facing == Direction.WEST) lx = 1.0D - lx;
                double ly = facing == Direction.WEST || facing == Direction.EAST ? p.x - pos.getX() : p.z - pos.getZ();
                if (facing == Direction.NORTH || facing == Direction.WEST) ly = 1.0D - ly;
                double wx = (lx - 0.5D / 16.0D) / 15.0D * 16.0D;
                double bx = ((lx - 0.5D / 16.0D) / 15.0D * 16.0D - 0.5D / 16.0D) * 16.0D;
                double ky = (ly - 4.5D / 16.0D) / 3.5D * 16.0D;
                int keyIndex = MathHelper.clamp((int) (wx * 14.0D), 0, 13);
                int note = new int[] { -1, 1, 3, 5, 6, 8, 10, 11, 13, 15, 17, 18, 20, 22 }[keyIndex];
                if (note != -1) {
                    world.addBlockEvent(pos, this, 0, note);
                }
            }
        }
        return true;
    }

    protected void playSound(@Nullable PlayerEntity player, IWorld world, BlockPos pos) {
        world.playSound(player, pos, SoundList.KEYBOARD_SOUND.get(), SoundCategory.BLOCKS, 1F, 1F);
    }

    @Override
    public boolean eventReceived(BlockState state, World worldIn, BlockPos pos, int id, int param) {
        worldIn.playSound(null, pos, SoundEvents.BLOCK_NOTE_BLOCK_PLING, SoundCategory.BLOCKS, 1.0F, (float) Math.pow(2.0D, (param - 12) / 12.0D));
        worldIn.addParticle(ParticleTypes.NOTE, pos.getX() + 0.5D, pos.getY() + 0.3D, pos.getZ() + 0.5D, param / 24.0D, 0.0D, 0.0D);
        return true;
    }
}
