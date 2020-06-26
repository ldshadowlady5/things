package com.ldshadowlady.things.data;

import com.ldshadowlady.things.blocks.FurnishingStationBlock;
import com.ldshadowlady.things.blocks.ThingsBlocks;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.criterion.ImpossibleTrigger;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Consumer;

import static com.ldshadowlady.things.Things.ID;

public class FurnishingAdvancements implements Consumer<Consumer<Advancement>> {
    @Override
    public void accept(Consumer<Advancement> consumer) {
        Advancement root = this.build(Advancement.Builder.builder().withCriterion("impossible", new ImpossibleTrigger.Instance()), consumer, "furnishing/root");
        for (RegistryObject<? extends Block> obj : ThingsBlocks.REG.getEntries()) {
            Block block = obj.orElseThrow(IllegalStateException::new);
            if (!(block instanceof FurnishingStationBlock)) {
                String name = block.getRegistryName().getPath();
                this.build(Advancement.Builder.builder().withParent(root).withCriterion("get_" + name, InventoryChangeTrigger.Instance.forItems(block)), consumer, "furnishing/" + name);
            }
        }
    }

    private Advancement build(Advancement.Builder builder, Consumer<Advancement> consumer, String name) {
        Advancement advancement = builder.build(new ResourceLocation(ID, name));
        consumer.accept(advancement);
        return advancement;
    }
}
