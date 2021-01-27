package org.sandboxpowered.api.capability;

import org.sandboxpowered.internal.InternalService;

public final class Capabilities {
    public static final Capability<Inventory> INVENTORY_CAPABILITY = get(Inventory.class);
    public static final Capability<FluidContainer> FLUID_CAPABILITY = get(FluidContainer.class);

    private Capabilities() {
    }

    private static <X> Capability<X> get(Class<X> xClass) {
        return InternalService.getInstance().componentFunction(xClass);
    }
}