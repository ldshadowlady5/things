package com.ldshadowlady.things.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.advancements.Advancement;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

// Using this until https://github.com/MinecraftForge/MinecraftForge/pull/6735
public abstract class AbstractAdvancementProvider implements IDataProvider {
   private static final Logger LOGGER = LogManager.getLogger();

   private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

   private final DataGenerator generator;

   public AbstractAdvancementProvider(DataGenerator generator) {
      this.generator = generator;
   }

   @Override
   public void act(DirectoryCache cache) {
      Path root = this.generator.getOutputFolder();
      Set<ResourceLocation> set = new HashSet<>();
      Consumer<Advancement> consumer = adv -> {
         if (!set.add(adv.getId())) {
            throw new IllegalStateException("Duplicate advancement " + adv.getId());
         }
         Path path = getPath(root, adv);
         try {
            IDataProvider.save(GSON, cache, adv.copy().serialize(), path);
         } catch (IOException e) {
            LOGGER.error("Couldn't save advancement {}", path, e);
         }
      };
      for (Consumer<Consumer<Advancement>> provider : this.getAdvancements()) {
         provider.accept(consumer);
      }
   }

   private static Path getPath(Path path, Advancement advancement) {
      return path.resolve("data/" + advancement.getId().getNamespace() + "/advancements/" + advancement.getId().getPath() + ".json");
   }

   abstract List<Consumer<Consumer<Advancement>>> getAdvancements();

   @Override
   public String getName() {
      return "Advancements";
   }
}
