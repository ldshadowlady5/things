package com.ldshadowlady.things.furnishing;

import com.ldshadowlady.things.Things;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FurnishingItemList {
    public static final ResourceLocation ROOT = new ResourceLocation(Things.ID, "furnishing/root");

    public static final Comparator<ItemStack> ORDER = Comparator.comparing(stack -> stack.getItem().getRegistryName());

    private List<ItemStack> items = new ArrayList<>();

    private List<ItemStack> itemsView = Collections.unmodifiableList(this.items);

    public List<? extends ItemStack> getItems() {
        return this.itemsView;
    }

    public void clear() {
        this.items.clear();
    }

    public void remove(Advancement advancement) {
        if (this.isFurnishing(advancement)) {
            Item item = this.getItem(advancement);
            this.items.removeIf(stack -> stack.getItem() == item);
        }
    }

    public void accept(Advancement advancement, AdvancementProgress progress) {
        if (this.isFurnishing(advancement) && progress.isDone()) {
            Item item = this.getItem(advancement);
            if (item != Items.AIR) {
                this.items.add(new ItemStack(item));
                this.items.sort(ORDER);
            }
        }
    }

    private boolean isFurnishing(Advancement advancement) {
        Advancement parent = advancement.getParent();
        return parent != null && ROOT.equals(parent.getId());
    }

    private Item getItem(Advancement advancement) {
        ResourceLocation id = advancement.getId();
        String path = id.getPath();
        return ForgeRegistries.ITEMS.getValue(new ResourceLocation(id.getNamespace(), path.substring(path.indexOf('/') + 1)));
    }
}
