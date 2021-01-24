package org.sandboxpowered.api.events;

import org.sandboxpowered.api.ecs.Entity;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.eventhandler.EventHandler;

import java.util.List;

public final class EntityEvents {
    public static final EventHandler<SpawnEvent> SPAWN = EventHandlerFactory.createEventHandler();
    public static final EventHandler<AnvilFallEvent> ANVIL_FALL = EventHandlerFactory.createEventHandler();

    public interface AnvilFallEvent {
        void onEvent(World world, Position pos, BlockState fallingState, BlockState hitState, Entity entity, List<Integer> hitEntities);
    }

    interface SpawnEvent {
        boolean onEvent(Entity entity);
    }
}