package dev.anvilcraft.ccb.client.event;

import dev.anvilcraft.ccb.AnvilCraftCCB;
import dev.anvilcraft.ccb.item.TuningFork;
import dev.anvilcraft.ccb.network.TuningForkPacket;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber(modid = AnvilCraftCCB.MOD_ID ,value = Dist.CLIENT)
public class TuningForkClientEventListener {
    private TuningForkClientEventListener() {}

    @SubscribeEvent
    public static void breakBlock(PlayerInteractEvent.LeftClickBlock event){
        if (!(event.getItemStack().getItem() instanceof TuningFork)) return;
        PacketDistributor.sendToServer(new TuningForkPacket(event.getPos(),event.getHand()));
        event.setCanceled(true);
    }

}
