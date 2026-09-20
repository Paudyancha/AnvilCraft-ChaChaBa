package dev.anvilcraft.ccb.event;

import dev.anvilcraft.ccb.AnvilCraftCCB;
import dev.anvilcraft.ccb.api.fluid.BowlFluidHandler;
import dev.anvilcraft.ccb.fluid.GeneticOozeBucketWrapper;
import dev.anvilcraft.ccb.init.CCBBlockEntities;
import dev.anvilcraft.ccb.init.CCBBlocks;
import dev.anvilcraft.ccb.init.CCBFluids;
import dev.anvilcraft.ccb.init.CCBItems;
import dev.dubhe.anvilcraft.block.Layered4LevelCauldronBlock;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.fluids.RegisterCauldronFluidContentEvent;

@EventBusSubscriber(modid = AnvilCraftCCB.MOD_ID)
public class CCBCapabilitiesEventListener {
    private CCBCapabilitiesEventListener() {}

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerItem(
            Capabilities.FluidHandler.ITEM,
            (stack, context) -> new GeneticOozeBucketWrapper(stack),
            CCBItems.GENETIC_OOZE_BUCKET.get()
        );

        event.registerItem(
            Capabilities.FluidHandler.ITEM,
            (stack, ctx) -> new BowlFluidHandler(stack),
            CCBItems.MUSH_BAR_BOWL, Items.BOWL
        );

        event.registerBlockEntity(
            Capabilities.FluidHandler.BLOCK,
            CCBBlockEntities.NORMAL_WORM_BLOCK_ENTITY.get(),
            (be, side) -> be.getFluidHandler()
        );

        event.registerBlockEntity(
            Capabilities.FluidHandler.BLOCK,
            CCBBlockEntities.CEMENT_WORM_BLOCK_BLOCK_ENTITY.get(),
            (be, side) -> be.getFluidHandler()
        );
    }

    @SubscribeEvent
    public static void registerCauldronFluidContent(RegisterCauldronFluidContentEvent event) {
        event.register(
            CCBBlocks.GENETIC_OOZE_CAULDRON.get(),
            CCBFluids.GENETIC_OOZE.get(),
            1000,
            Layered4LevelCauldronBlock.LEVEL
        );
    }
}
