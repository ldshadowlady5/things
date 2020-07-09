package com.ldshadowlady.things.entities;

import com.ldshadowlady.things.blocks.BlockDirectionalChair;
import com.ldshadowlady.things.blocks.BlockDirectionalDeckChair;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

public class ChairEntity extends Entity {
    public ChairEntity(EntityType<?> type, World world) {
        super(type, world);
    }

    @Override
    protected void registerData() {
    }

    @Override
    public void tick() {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        if (!this.world.isRemote && (this.getPassengers().isEmpty() || this.ticksExisted % 160 == 0 && !this.hasValidPosition())) {
            this.remove();
        }
    }

    private boolean hasValidPosition() {
        if (!this.world.isBlockPresent(new BlockPos(this))) return true;
        Block block = this.world.getBlockState(new BlockPos(this)).getBlock();
        return block instanceof BlockDirectionalChair || block instanceof BlockDirectionalDeckChair;
    }

    @Override
    public void move(MoverType type, Vec3d pos) {
        if (!this.world.isRemote && this.isAlive() && pos.lengthSquared() > 0.0D) {
            this.remove();
        }
    }

    @Override
    public void addVelocity(double x, double y, double z) {
        if (!this.world.isRemote && this.isAlive() && x * x + y * y + z * z > 0.0D) {
            this.remove();
        }
    }

    @Override
    protected void readAdditional(CompoundNBT compound) {
    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
}
