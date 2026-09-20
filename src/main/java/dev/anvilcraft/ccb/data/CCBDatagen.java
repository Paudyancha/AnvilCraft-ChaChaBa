package dev.anvilcraft.ccb.data;

import dev.anvilcraft.ccb.AnvilCraftCCB;
import dev.anvilcraft.ccb.data.lang.LangHandler;
import dev.anvilcraft.lib.v2.integration.IntegrationHook;
import dev.anvilcraft.lib.v2.registrum.providers.ProviderType;
import dev.anvilcraft.ccb.data.recipe.RecipeHandler;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import static dev.anvilcraft.ccb.AnvilCraftCCB.REGISTRUM;

@EventBusSubscriber(modid = AnvilCraftCCB.MOD_ID)
public class CCBDatagen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput packOutput = generator.getPackOutput();

        IntegrationHook.setEvent(event);
    }

    public static void init() {
        var genInit = REGISTRUM.getDataGenInitializer();
        REGISTRUM.addDataGenerator(ProviderType.LANG, LangHandler::init);
        REGISTRUM.addDataGenerator(ProviderType.RECIPE, RecipeHandler::init);
    }
}
