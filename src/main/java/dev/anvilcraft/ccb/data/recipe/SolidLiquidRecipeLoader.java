package dev.anvilcraft.ccb.data.recipe;

import dev.anvilcraft.ccb.AnvilCraftCCB;
import dev.anvilcraft.ccb.init.CCBFluids;
import dev.anvilcraft.lib.v2.registrum.providers.RegistrumRecipeProvider;
import dev.dubhe.anvilcraft.recipe.anvil.wrap.SolidLiquidRecipe;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;

public class SolidLiquidRecipeLoader {
    public static void init(RegistrumRecipeProvider provider) {
        SolidLiquidRecipe.builder()
            .cauldron(CCBFluids.GENETIC_OOZE.get())
            .consume(250)
            .requires(Tags.Items.FOODS, 1)
            .requires(Items.DIRT)
            .transform(CCBFluids.GENETIC_OOZE, 500)
            .save(provider, AnvilCraftCCB.of("solid_liquid/genetic_ooze"));

    }
}
