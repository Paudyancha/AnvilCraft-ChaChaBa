package dev.anvilcraft.ccb;

import dev.anvilcraft.ccb.config.CCBServerConfig;
import dev.anvilcraft.ccb.data.CCBDatagen;
import dev.anvilcraft.ccb.init.CCBBlockEntities;
import dev.anvilcraft.ccb.init.CCBBlocks;
import dev.anvilcraft.ccb.init.CCBEntities;
import dev.anvilcraft.ccb.init.CCBFluids;
import dev.anvilcraft.ccb.init.CCBInteractionMaps;
import dev.anvilcraft.ccb.init.CCBItemGroups;
import dev.anvilcraft.ccb.init.CCBItems;
import dev.anvilcraft.lib.v2.config.ConfigManager;
import dev.anvilcraft.lib.v2.integration.IntegrationHook;
import dev.anvilcraft.lib.v2.network.register.NetworkRegistrar;
import dev.anvilcraft.lib.v2.registrum.Registrum;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.loading.progress.StartupNotificationManager;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod(AnvilCraftCCB.MOD_ID)
public class AnvilCraftCCB {
    public static final String MOD_ID = "anvilcraft_chachaba";
    public static final String MOD_NAME = "Anvilcraft-ChaChaBa";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
    public static final CCBServerConfig CONFIG = ConfigManager.register(MOD_ID, CCBServerConfig::new);
    public static final Registrum REGISTRUM = Registrum.create(AnvilCraftCCB.MOD_ID);

    public AnvilCraftCCB(IEventBus modEventBus, ModContainer container) {
        CCBItems.register();
        CCBBlocks.register();
        CCBBlockEntities.register();
        CCBItemGroups.register(modEventBus);
        CCBEntities.register();
        CCBFluids.register(modEventBus);
        CCBDatagen.init();
        registerEvents(modEventBus);
        StartupNotificationManager.addModMessage("FISH AND CHA");
        IntegrationHook.setModEventBus(modEventBus);
        IntegrationHook.setModContainer(container);
        LOGGER.info("铁砧工艺,启动!");
    }

    private void registerEvents(IEventBus event) {
        event.addListener(AnvilCraftCCB::commonSetup);
        event.addListener(this::registerPayloads);
    }

    private void registerPayloads(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar("1");

        NetworkRegistrar.register(registrar, AnvilCraftCCB.MOD_ID);
    }

    public static ResourceLocation of(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(CCBInteractionMaps::init);
    }
}
