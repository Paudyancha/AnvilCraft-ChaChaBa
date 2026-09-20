package dev.anvilcraft.ccb.client.event;

import dev.anvilcraft.ccb.AnvilCraftCCB;
import dev.anvilcraft.ccb.init.CCBFluids;
import dev.dubhe.anvilcraft.util.ModClientFluidTypeExtensionImpl;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

@EventBusSubscriber(modid = AnvilCraftCCB.MOD_ID, value = Dist.CLIENT)
public class AddonFluidClientExtensions {
    private AddonFluidClientExtensions() {}

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(
            new ModClientFluidTypeExtensionImpl(
                AnvilCraftCCB.of("block/genetic_ooze_block"),
                AnvilCraftCCB.of("block/genetic_ooze_block")
            ),
            CCBFluids.GENETIC_OOZE_TYPE
        );
    }
}
