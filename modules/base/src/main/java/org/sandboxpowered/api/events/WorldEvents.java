package org.sandboxpowered.api.events;

import org.sandboxpowered.api.shape.Shape;
import org.sandboxpowered.api.util.math.Vec3d;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.api.world.WorldReader;
import org.sandboxpowered.eventhandler.EventHandler;

import java.util.List;

public final class WorldEvents {
    public static final EventHandler<LightningStrikeEvent> LIGHTNING_STRIKE = EventHandlerFactory.createEventHandler();
    public static final EventHandler<AddCollisionBoxes> ADD_COLLISION_BOXES = EventHandlerFactory.createEventHandler();

    public interface LightningStrikeEvent {
        void onEvent(World world, Vec3d position, List<Integer> hitEntities);
    }

    public interface AddCollisionBoxes {
        List<Shape> getShapes(WorldReader reader, int collidingEntity, List<Shape> shapes);
    }
}