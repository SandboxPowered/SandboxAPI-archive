package org.sandboxpowered.api.ecs;

import org.sandboxpowered.api.world.World;

public abstract class BaseEntitySystem extends BaseSystem {
    protected Subscription subscription;

    public BaseEntitySystem(World world, Subscription subscription) {
        super(world);
        this.subscription = subscription;
    }
}
