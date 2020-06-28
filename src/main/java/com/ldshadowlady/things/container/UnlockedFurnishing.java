package com.ldshadowlady.things.container;

import com.ldshadowlady.things.blockentities.FurnishingItemList;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementManager;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.multiplayer.ClientAdvancementManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.DistExecutor;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Function;

public abstract class UnlockedFurnishing {
    protected final FurnishingItemList list = new FurnishingItemList();

    public abstract void init();

    public abstract void remove();

    public final List<? extends ItemStack> getItems() {
        return this.list.getItems();
    }

    public static UnlockedFurnishing get(PlayerEntity player) {
        return DistExecutor.<Function<PlayerEntity, UnlockedFurnishing>>runForDist(
            () -> () -> Client::get,
            () -> () -> Server::get
        ).apply(player);
    }

    static class Empty extends UnlockedFurnishing {
        @Override
        public void init() {
        }

        @Override
        public void remove() {
        }
    }

    static class Server extends UnlockedFurnishing {
        final PlayerAdvancements progress;

        final AdvancementManager manager;

        public Server(ServerPlayerEntity player) {
            this.progress = player.getAdvancements();
            this.manager = player.server.getAdvancementManager();
        }

        @Override
        public void init() {
            this.list.clear();
            Advancement root = this.manager.getAdvancement(FurnishingItemList.ROOT);
            if (root != null) {
                for (Advancement adv : root.getChildren()) {
                    this.list.accept(adv, this.progress.getProgress(adv));
                }
            }
        }

        @Override
        public void remove() {
        }

        public static UnlockedFurnishing get(PlayerEntity player) {
            if (player instanceof ServerPlayerEntity) {
                return new Server((ServerPlayerEntity) player);
            }
            return new Empty();
        }
    }

    static class Client extends UnlockedFurnishing implements ClientAdvancementManager.IListener {
        final ClientAdvancementManager manager;

        public Client(ClientPlayerEntity player) {
            this.manager = player.connection.getAdvancementManager();
        }

        @Override
        public void init() {
            this.list.clear();
            this.manager.setListener(this);
        }

        @Override
        public void remove() {
            this.manager.setListener(null);
        }

        @Override
        public void onUpdateAdvancementProgress(Advancement advancement, AdvancementProgress progress) {
            this.list.accept(advancement, progress);
        }

        @Override
        public void setSelectedTab(@Nullable Advancement advancement) {
        }

        @Override
        public void rootAdvancementAdded(Advancement advancement) {
        }

        @Override
        public void rootAdvancementRemoved(Advancement advancement) {
        }

        @Override
        public void nonRootAdvancementAdded(Advancement advancement) {
        }

        @Override
        public void nonRootAdvancementRemoved(Advancement advancement) {
            // TODO: removal
        }

        @Override
        public void advancementsCleared() {
            this.list.clear();
        }

        public static UnlockedFurnishing get(PlayerEntity player) {
            if (player instanceof ClientPlayerEntity) {
                return new Client((ClientPlayerEntity) player);
            }
            return Server.get(player);
        }
    }
}
