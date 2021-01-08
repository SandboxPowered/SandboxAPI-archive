package org.sandboxpowered.api.ecs;

import org.sandboxpowered.api.world.World;

/**
 * Basic system to run on the world
 * <p>
 * Flow:
 * <p>
 * {@link #begin()} Called before entities are processed.
 * <p>
 * {@link #processSystem()} Called once per tick.
 * <p>
 * {@link #end()} Called after entities have been processed.
 */
public abstract class BaseSystem {
    private final World world;

    public BaseSystem(World world) {
        this.world = world;
    }

    /**
     * Called before system processing begins.
     */
    protected void begin() {
    }

    /**
     * Process system.
     * <p>
     * Does nothing if {@link #shouldProcess()} is false or the system is disabled.
     */
    public final void process() {
        if (shouldProcess()) {
            begin();
            processSystem();
            end();
        }
    }

    /**
     * Process the system.
     */
    protected abstract void processSystem();

    /**
     * Called after the systems has finished processing.
     */
    protected void end() {
    }

    /**
     * Does the system desire processing. Useful when the system is enabled, but only occasionally needs to process. This only affects processing, and does not affect events or subscription lists.
     *
     * @return true if the system should be processed, false if not.
     */
    protected boolean shouldProcess() {
        return true;
    }
}