package org.sandboxpowered.api.ecs;

public interface ComponentMapper<C> {
    C get(int entityId);

    boolean has(int entityId);

    void remove(int entityId);

    C create(int entityId);
}
