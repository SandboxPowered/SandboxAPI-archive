package org.sandboxpowered.api.addon;

import org.sandboxpowered.api.SandboxAPI;
import org.sandboxpowered.api.registry.Registrar;

public interface Addon {
    /**
     * General mod init, event registration etc
     */
    default void init(SandboxAPI api) {}

    default void register(SandboxAPI api, Registrar registrar) {}

    default void finishLoad(SandboxAPI api) {}
}
