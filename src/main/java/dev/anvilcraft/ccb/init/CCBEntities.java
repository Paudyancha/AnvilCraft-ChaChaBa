package dev.anvilcraft.ccb.init;

import dev.anvilcraft.ccb.client.renderer.entity.ForkRenderer;
import dev.anvilcraft.ccb.entity.ThrownForkEntity;
import dev.anvilcraft.lib.v2.registrum.util.entry.EntityEntry;
import net.minecraft.world.entity.MobCategory;

import static dev.anvilcraft.ccb.AnvilCraftCCB.REGISTRUM;

public class CCBEntities {

    public static EntityEntry<ThrownForkEntity> THROWN_FORK = REGISTRUM
        .entity("thrown_fork", ThrownForkEntity::new, MobCategory.MISC)
        .renderer(() -> ForkRenderer::new)
        .properties(builder -> builder
            .sized(0.5F, 0.5F)
            .eyeHeight(0.13F)
                .clientTrackingRange(4)
                .updateInterval(20)
        )
        .register()
        ;

    public static void register(){}
}
