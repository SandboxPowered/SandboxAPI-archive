package org.sandboxpowered.api.ecs;

import org.sandboxpowered.api.ecs.component.EntityComponent;
import org.sandboxpowered.api.inject.Sandbox;
import org.sandboxpowered.api.world.World;

public interface EntityBlueprint {

    static Builder builder() {
        return Sandbox.getFactoryProvider().get(Factory.class).newBuilder();
    }

    static Builder builder(EntityBlueprint existing) {
        return Sandbox.getFactoryProvider().get(Factory.class).newBuilder(existing);
    }

    interface Factory {
        Builder newBuilder();

        Builder newBuilder(EntityBlueprint blueprint);
    }

    interface Builder {
        Builder add(Class<? extends EntityComponent> type);

        Builder addAll(Class<? extends EntityComponent>... types);

        Builder remove(Class<? extends EntityComponent> type);

        Builder removeAll(Class<? extends EntityComponent>... types);

        EntityBlueprint build(World world);
    }
}