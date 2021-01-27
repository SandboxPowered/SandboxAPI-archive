package org.sandboxpowered.api.ecs;

import org.sandboxpowered.api.ecs.component.Component;
import org.sandboxpowered.api.inject.Sandbox;
import org.sandboxpowered.api.world.WorldReader;

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
        Builder add(Class<? extends Component> type);

        Builder addAll(Class<? extends Component>... types);

        Builder remove(Class<? extends Component> type);

        Builder removeAll(Class<? extends Component>... types);

        EntityBlueprint build(WorldReader reader);
    }
}