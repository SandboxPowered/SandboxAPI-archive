package org.sandboxpowered.api.ecs;

public abstract class EntitySystem {
    /**
     * Called before system processing begins.
     */
    protected void begin() {
    }

    /**
     * Process system.
     * <p>
     * Does nothing if {@link #doProcessing()} is false or the system
     * is disabled.
     */
    public final void process() {
        if (doProcessing()) {
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
     * Returns:
     * true if the system should be processed, false if not.
     */
    protected boolean doProcessing() {
        return true;
    }
}