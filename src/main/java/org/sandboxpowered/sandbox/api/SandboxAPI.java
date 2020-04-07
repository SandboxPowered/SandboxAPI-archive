package org.sandboxpowered.sandbox.api;

import org.sandboxpowered.sandbox.api.util.Log;
import org.sandboxpowered.sandbox.api.util.Side;

public interface SandboxAPI {
    Side getSide();

    default void execute(Side side, Runnable runnable) {
        if (getSide() == side) {
            runnable.run();
        }
    }

    Log getLog();
}