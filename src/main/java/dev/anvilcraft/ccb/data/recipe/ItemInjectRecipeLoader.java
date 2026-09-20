package dev.anvilcraft.ccb.data.recipe;

import dev.anvilcraft.ccb.AnvilCraftCCB;
import dev.anvilcraft.ccb.init.CCBBlocks;
import dev.anvilcraft.lib.v2.registrum.providers.RegistrumRecipeProvider;
import dev.dubhe.anvilcraft.recipe.anvil.wrap.ItemInjectRecipe;
import net.neoforged.neoforge.common.Tags;

public class ItemInjectRecipeLoader {
    public static void init(RegistrumRecipeProvider provider) {
        ItemInjectRecipe.builder()
            .requires(Tags.Items.FOODS)
            .inputBlock(CCBBlocks.GENETIC_OOZE_BLOCK)
            .resultBlock(CCBBlocks.GENETIC_OOZE_BLOCK)
            .save(provider, AnvilCraftCCB.of("item_inject/genetic_ooze_block"));
    }
}
