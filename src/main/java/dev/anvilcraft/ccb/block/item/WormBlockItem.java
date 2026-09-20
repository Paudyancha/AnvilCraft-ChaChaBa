package dev.anvilcraft.ccb.block.item;

import dev.anvilcraft.ccb.client.renderer.item.WormItemRenderer;
import dev.dubhe.anvilcraft.client.renderer.item.CustomRenderItemClientExtension;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

public class WormBlockItem extends BlockItem {
    public WormBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    @SuppressWarnings("removal")
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(CustomRenderItemClientExtension.of(WormItemRenderer.getInstance()));
    }
}
