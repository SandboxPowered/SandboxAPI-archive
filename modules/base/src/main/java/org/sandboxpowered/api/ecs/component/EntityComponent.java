package org.sandboxpowered.api.ecs.component;

/**
 * Components are pure data classes with optionally some helper methods.
 * <p/>
 * Extend to create your own components.
 * or extend {@link PooledEntityComponent} to make the component pooled.
 *
 * @see PooledEntityComponent
 */
public interface EntityComponent {
    default boolean ableToApplyOn(Type type) {
        return true;
    }

    enum Type {
        ENTITY,
        BLOCK_ENTITY
    }
}
