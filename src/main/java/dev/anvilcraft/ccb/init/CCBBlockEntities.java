package dev.anvilcraft.ccb.init;

import dev.anvilcraft.ccb.block.entity.CementWormBlockEntity;
import dev.anvilcraft.ccb.block.entity.WormBlockEntity;
import dev.anvilcraft.ccb.client.renderer.blockentity.WormBlockEntityRenderer;
import dev.anvilcraft.lib.v2.registrum.util.entry.BlockEntityEntry;

import static dev.anvilcraft.ccb.AnvilCraftCCB.REGISTRUM;

public class CCBBlockEntities {

    public static final BlockEntityEntry<WormBlockEntity> NORMAL_WORM_BLOCK_ENTITY = REGISTRUM
        .blockEntity("normal_worm", WormBlockEntity::new)
        .validBlock(CCBBlocks.CEMENT_WORM_BLOCK)
        .renderer(() -> WormBlockEntityRenderer::new)
        .register();

    public static final BlockEntityEntry<CementWormBlockEntity> CEMENT_WORM_BLOCK_BLOCK_ENTITY = REGISTRUM
        .blockEntity("cement_worm",CementWormBlockEntity::new)
        .validBlock(CCBBlocks.CEMENT_WORM_BLOCK)
        .renderer(() -> WormBlockEntityRenderer::new)
        .register();

    public static void register() {}
}
