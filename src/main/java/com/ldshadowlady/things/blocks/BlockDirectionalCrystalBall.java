package com.ldshadowlady.things.blocks;

import com.ldshadowlady.things.common.VoxelShapeUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class BlockDirectionalCrystalBall extends HorizontalBlock {

    private final VoxelShape northShape;

    private final VoxelShape southShape;

    private final VoxelShape westShape;

    private final VoxelShape eastShape;


    public BlockDirectionalCrystalBall(Properties properties, VoxelShape ShapeIn) {
        super(properties);
        this.northShape = ShapeIn;
        this.southShape = VoxelShapeUtils.rotateHorizontal (ShapeIn, Direction.SOUTH);
        this.westShape = VoxelShapeUtils.rotateHorizontal (ShapeIn, Direction.WEST);
        this.eastShape = VoxelShapeUtils.rotateHorizontal (ShapeIn, Direction.EAST);
        this.setDefaultState((BlockState)((BlockState)this.stateContainer.getBaseState()).with(HORIZONTAL_FACING, Direction.SOUTH));
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState state, World worldIn, BlockPos pos, Random rand) {
        Random rng = new Random();
        // to get a double between 0.3 and 0.7 i think?
         Double posi = rng.nextDouble() * 0.4 +0.3; // rng.nextDouble() is between 0 and 1
        double posX = (double)pos.getX() + posi;
        double posY = (double)pos.getY() + 0.5;
        double posZ = (double)pos.getZ() + posi;

        if (rand.nextDouble() < 0.4D) {
            worldIn.addParticle(ParticleTypes.WITCH, posX, posY, posZ, 0.0D, 0.0D, 0.0D);
        }
    }

    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.TRANSLUCENT;
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
