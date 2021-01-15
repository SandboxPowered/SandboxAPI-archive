package org.sandboxpowered.api.inject;

import com.google.inject.Inject;

public final class Sandbox {
    @Inject
    private static Implementation implementation;

    public static Implementation getImplementation() {
        if (implementation == null) {
            throw new IllegalStateException("Sandbox has not been initialized!");
        }
        return implementation;
    }

    public static FactoryProvider getFactoryProvider() {
        return getImplementation().getFactoryProvider();
    }
}
