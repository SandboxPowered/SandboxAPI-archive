package org.sandboxpowered.api.server;

import org.sandboxpowered.internal.InternalService;

public interface Server {
    static Server getInstance() {
        return InternalService.getInstance().serverInstance();
    }
}
