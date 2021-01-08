package org.sandboxpowered.api.ecs;

public interface EntityBag {
    int get(int index);

    int size();

    boolean isEmpty();

    boolean contains(int entity);

    int[] getData();
}
