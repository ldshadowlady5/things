package com.ldshadowlady.things.blockentities;

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

    public void accept(Advancement advancement, AdvancementProgress progress) {
        Advancement parent = advancement.getParent();
        if (parent != null && ROOT.equals(parent.getId()) && progress.isDone()) {
            String p = advancement.getId().getPath();
            Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(advancement.getId().getNamespace(), p.substring(p.indexOf('/') + 1)));
            if (item != Items.AIR) {
                this.items.add(new ItemStack(item));
                this.items.sort(ORDER);
            }
        }
    }
}
