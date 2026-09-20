package dev.anvilcraft.ccb.data.recipe;

import dev.anvilcraft.ccb.AnvilCraftCCB;
import dev.anvilcraft.ccb.init.CCBItems;
import dev.anvilcraft.lib.v2.registrum.providers.RegistrumRecipeProvider;
import dev.dubhe.anvilcraft.recipe.anvil.wrap.StampingRecipe;

public class StampingRecipeLoader {
    public static void init(RegistrumRecipeProvider provider) {
        StampingRecipe.builder()
            .requires(CCBItems.MUSH_BAR_BOWL)
            .result(CCBItems.MUSH_BAR)
            .save(provider, AnvilCraftCCB.of("stamping/mush_bar"));
    }
}
