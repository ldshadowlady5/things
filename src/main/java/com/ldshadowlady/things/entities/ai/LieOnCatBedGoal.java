package com.ldshadowlady.things.entities.ai;

import com.ldshadowlady.things.tags.ThingsTags;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorldReader;

import java.util.EnumSet;

public class LieOnCatBedGoal extends MoveToBlockGoal {
   private final CatEntity cat;

   public LieOnCatBedGoal(CatEntity cat, double speed, int distance) {
      super(cat, speed, distance, 6);
      this.cat = cat;
      this.field_203112_e = 0;
      this.setMutexFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
   }

   @Override
   public boolean shouldExecute() {
      return this.cat.isTamed() && !this.cat.isSitting() && !this.cat.func_213416_eg() && super.shouldExecute();
   }

   @Override
   public void startExecuting() {
      super.startExecuting();
      this.cat.getAISit().setSitting(false);
   }

   @Override
   protected int getRunDelay(CreatureEntity creature) {
      return 600 + creature.getRNG().nextInt(1200);
   }

   @Override
   public void resetTask() {
      super.resetTask();
      this.cat.func_213419_u(false);
   }

   @Override
   public void tick() {
      boolean far = !this.destinationBlock.withinDistance(this.creature.getPositionVec(), this.getTargetDistanceSq());
      if (far) {
         this.timeoutCounter++;
         if (this.shouldMove()) {
            this.creature.getNavigator().tryMoveToXYZ(this.destinationBlock.getX() + 0.5D, this.destinationBlock.getY(), this.destinationBlock.getZ() + 0.5D, this.movementSpeed);
         }
      } else {
         this.timeoutCounter--;
         if (!this.cat.func_213416_eg()) {
            this.creature.setLocationAndAngles(this.destinationBlock.getX() + 0.5D, this.destinationBlock.getY() + 0.25D, this.destinationBlock.getZ() + 0.5D, this.creature.rotationYaw, this.creature.rotationPitch);
            this.creature.setMotion(Vec3d.ZERO);
         }
      }
      this.cat.getAISit().setSitting(false);
      if (far) {
         this.cat.func_213419_u(false);
      } else if (!this.cat.func_213416_eg()) {
         this.cat.func_213419_u(true);
      }
   }

   @Override
   protected boolean shouldMoveTo(IWorldReader world, BlockPos pos) {
      return world.isAirBlock(pos.up()) && world.getBlockState(pos).getBlock().isIn(ThingsTags.PET_BEDS);
   }
}
