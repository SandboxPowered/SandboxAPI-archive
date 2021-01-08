package org.sandboxpowered.api.ecs;

import org.sandboxpowered.api.ecs.component.EntityComponent;
import org.sandboxpowered.api.world.World;

public interface Entity {
    int getId();

    <T extends EntityComponent> T get(Class<T> type);

    World getWorld();

    default void delete() {
        getWorld().removeEntity(getId());
    }
}