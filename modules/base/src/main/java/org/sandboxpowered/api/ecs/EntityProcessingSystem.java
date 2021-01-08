package org.sandboxpowered.api.ecs;

import org.sandboxpowered.api.world.World;

public abstract class EntityProcessingSystem extends BaseEntitySystem {
    public EntityProcessingSystem(World world, Subscription subscription) {
        super(world, subscription);
    }

    protected abstract void process(int entity);

    @Override
    protected final void processSystem() {
        EntityBag entities = subscription.getEntities();
        int entityCount = entities.size();
        if (entityCount == 0) {
            return;
        }

        int[] ids = entities.getData();
        for (int i = 0; entityCount > i; i++) {
            process(ids[i]);
        }
    }
}