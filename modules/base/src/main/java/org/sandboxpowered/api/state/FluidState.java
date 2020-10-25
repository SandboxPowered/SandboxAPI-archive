package org.sandboxpowered.api.state;

import org.sandboxpowered.api.fluid.Fluid;
import org.sandboxpowered.api.state.property.PropertyContainer;
import org.sandboxpowered.api.tags.Tag;

public interface FluidState extends PropertyContainer<FluidState> {
    Fluid getFluid();

    default BlockState asBlockState() {
        return getFluid().asBlockState(this);
    }

    default boolean isStill() {
        return getFluid().isStill(this);
    }

    default float getLevel() {
        return getFluid().getLevel(this);
    }

    default boolean isIn(Tag<Fluid> tag) {
        return tag.contains(getFluid());
    }
}
