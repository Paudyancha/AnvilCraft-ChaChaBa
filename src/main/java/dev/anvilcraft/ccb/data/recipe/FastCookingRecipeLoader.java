package dev.anvilcraft.ccb.data.recipe;

import dev.anvilcraft.ccb.AnvilCraftCCB;
import dev.anvilcraft.ccb.init.CCBItems;
import dev.anvilcraft.lib.v2.registrum.providers.RegistrumRecipeProvider;
import dev.dubhe.anvilcraft.recipe.anvil.wrap.FastCookingRecipe;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

public class FastCookingRecipeLoader {
    public static void init(RegistrumRecipeProvider provider) {
        FastCookingRecipe.builder()
            .cauldron(Blocks.WATER_CAULDRON)
            .requires(Items.DIRT)
            .requires(Tags.Items.FOODS)
            .requires(Items.BOWL)
            .result(CCBItems.MUSH_BAR_BOWL)
            .save(provider , AnvilCraftCCB.of("fast_cooking/mush_bar_bowl"));
    }
}
