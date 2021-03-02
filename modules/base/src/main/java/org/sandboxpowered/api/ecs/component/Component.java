package org.sandboxpowered.api.ecs.component;

/**
 * Components are pure data classes with optionally some helper methods.
 * <br>
 * Extend to create your own components.
 * or extend {@link PooledComponent} to make the component pooled.
 *
 * @see PooledComponent
 */
public interface Component {
    default boolean ableToApplyOn(Type type) {
        return true;
    }

    enum Type {
        ENTITY,
        BLOCK_ENTITY
    }
}
