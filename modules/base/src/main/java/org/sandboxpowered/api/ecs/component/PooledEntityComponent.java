package org.sandboxpowered.api.ecs.component;

/**
 * Component that recycles instances.
 * <p>
 * Expects no <code>final</code> fields.
 */
public interface PooledEntityComponent extends EntityComponent {
    void reset();
}
