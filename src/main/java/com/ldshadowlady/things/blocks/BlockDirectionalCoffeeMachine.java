package com.ldshadowlady.things.blocks;

import com.ldshadowlady.things.common.VoxelShapeUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemHandlerHelper;

import javax.annotation.Nullable;

import java.util.UUID;

import static net.minecraft.state.properties.BlockStateProperties.LIT;

public class BlockDirectionalCoffeeMachine extends HorizontalBlock {

    private final VoxelShape northShape;

    private final VoxelShape southShape;

    private final VoxelShape westShape;

    private final VoxelShape eastShape;


    public BlockDirectionalCoffeeMachine(Properties properties, VoxelShape ShapeIn) {
        super(properties);
        this.northShape = ShapeIn;
        this.southShape = VoxelShapeUtils.rotateHorizontal(ShapeIn, Direction.SOUTH);
        this.westShape = VoxelShapeUtils.rotateHorizontal(ShapeIn, Direction.WEST);
        this.eastShape = VoxelShapeUtils.rotateHorizontal(ShapeIn, Direction.EAST);
        this.setDefaultState(this.stateContainer.getBaseState().with(HORIZONTAL_FACING, Direction.SOUTH));
    }



    private static final UUID JIMMY = UUID.fromString("dcdedb3c-b800-4414-aa64-414f17a179a2");
    private static final UUID LIZZIE = UUID.fromString("751b090e-012e-4847-974e-a666cfc2603d");

    @Override
    public boolean onBlockActivated(final BlockState state, final World world, final BlockPos pos, final PlayerEntity player, final Hand hand, final BlockRayTraceResult hit) {
        if (!world.isRemote) {
            if (JIMMY.equals(player.getUniqueID())) {
                ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ThingsBlocks.COFFEE_MUG.get()));
            } else if (LIZZIE.equals(player.getUniqueID())) {
                ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ThingsBlocks.COFFEE_MUG.get()));
            } else {
                player.sendMessage(new TranslationTextComponent("message.coffee_machine_error"));
            }
        }
        return true;
    }




    protected void playSound(@Nullable PlayerEntity player, IWorld world, BlockPos pos) {
        world.playSound(player, pos, soundType.getPlaceSound(), SoundCategory.BLOCKS, 0.3F, 0.5F);
    }


    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite().getOpposite());
    }

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

    public BlockRenderLayer getRenderLayer() {return BlockRenderLayer.CUTOUT;}



}
