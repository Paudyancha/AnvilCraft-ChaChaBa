package dev.anvilcraft.ccb.data.recipe;

import dev.anvilcraft.ccb.AnvilCraftCCB;
import dev.anvilcraft.ccb.init.CCBBlocks;
import dev.anvilcraft.lib.v2.registrum.providers.RegistrumRecipeProvider;
import dev.anvilcraft.lib.v2.util.predicate.ItemIngredientPredicate;
import dev.dubhe.anvilcraft.init.block.ModBlocks;
import dev.dubhe.anvilcraft.init.item.ModItemSubPredicates;
import dev.dubhe.anvilcraft.item.property.predicate.ItemSavedEntityPredicate;
import dev.dubhe.anvilcraft.recipe.anvil.procedural.ProceduralProcessRecipeBuilder;
import dev.dubhe.anvilcraft.recipe.anvil.wrap.BlockCompressRecipe;
import dev.dubhe.anvilcraft.recipe.anvil.wrap.ItemInjectRecipe;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

public class ProceduralProcessRecipeLoader {
    public static void init(RegistrumRecipeProvider provider) {
        ProceduralProcessRecipeBuilder.of(CCBBlocks.GENETIC_OOZE_BLOCK.get())
            .addStep(
                BlockCompressRecipe.builder()
                    .input(Blocks.SNOW_BLOCK)
                    .input(CCBBlocks.GENETIC_OOZE_BLOCK.get())
                    .result(ModBlocks.WIP_BLOCK.get())
                    .buildRecipe()
            )
            .addStep(
                ItemInjectRecipe.builder()
                    .inputBlock(ModBlocks.WIP_BLOCK.get())
                    .requires(
                        ItemIngredientPredicate
                            .of(ModBlocks.RESIN_BLOCK.asItem())
                            .withSubPredicate(
                                ModItemSubPredicates.SAVED_ENTITY.get(),
                                ItemSavedEntityPredicate.any()
                            )
                            .build()
                    )
                    .resultBlock(ModBlocks.WIP_BLOCK)
                    .buildRecipe()
            ).addStep(
                ItemInjectRecipe.builder()
                    .inputBlock(ModBlocks.WIP_BLOCK.get())
                    .requires(Tags.Items.GLASS_BLOCKS)
                    .resultBlock(ModBlocks.WIP_BLOCK.get())
                    .buildRecipe()
            )
            .result(CCBBlocks.CEMENT_WORM_BLOCK)
            .icon(CCBBlocks.CEMENT_WORM_BLOCK.asStack())
            .displayedModels(
                AnvilCraftCCB.of("cement_worm_wip0"),
                AnvilCraftCCB.of("cement_worm_wip1")
            )
            .save(provider, AnvilCraftCCB.of("procedural_process/cement_worm_block"));
    }
}
