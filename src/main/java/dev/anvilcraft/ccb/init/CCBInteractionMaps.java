package dev.anvilcraft.ccb.init;

import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;

public class CCBInteractionMaps {
    public static final CauldronInteraction.InteractionMap GENETIC_OOZE = CauldronInteraction.newInteractionMap("genetic_ooze");

    public static void init() {
        var map = GENETIC_OOZE.map();
        map.put(
            Items.BUCKET,
            (state, level, pos, player, hand, stack) -> CauldronInteraction.fillBucket(
                state,
                level,
                pos,
                player,
                hand,
                stack,
                CCBItems.GENETIC_OOZE_BUCKET.asStack(),
                (s) -> CCBBlocks.GENETIC_OOZE_CAULDRON.get().isFull(s),
                SoundEvents.BUCKET_FILL
            )
        );
        var emptyMap = CauldronInteraction.EMPTY.map();
        emptyMap.put(
            CCBItems.GENETIC_OOZE_BUCKET.get(),
            (state, level, pos, player, hand, stack) -> CauldronInteraction.emptyBucket(
                level,
                pos,
                player,
                hand,
                stack,
                CCBBlocks.GENETIC_OOZE_CAULDRON.get().fullFilled(),
                SoundEvents.BUCKET_EMPTY
            )
        );
    }
}
