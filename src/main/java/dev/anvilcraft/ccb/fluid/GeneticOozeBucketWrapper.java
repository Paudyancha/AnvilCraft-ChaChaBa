package dev.anvilcraft.ccb.fluid;

import dev.anvilcraft.ccb.init.CCBFluids;
import dev.anvilcraft.ccb.init.CCBItems;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.fluids.capability.wrappers.FluidBucketWrapper;

public class GeneticOozeBucketWrapper extends FluidBucketWrapper {
    public GeneticOozeBucketWrapper(ItemStack container) {
        super(container);
    }

    @Override
    public FluidStack getFluid() {
        if (this.container.is(CCBItems.GENETIC_OOZE_BUCKET.get())) {
            return new FluidStack(CCBFluids.GENETIC_OOZE, FluidType.BUCKET_VOLUME);
        }
        return super.getFluid();
    }
}
