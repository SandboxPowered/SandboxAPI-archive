package org.sandboxpowered.api.events;

import org.sandboxpowered.api.ecs.Entity;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.Hand;
import org.sandboxpowered.api.util.InteractionResult;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.eventhandler.Cancellable;
import org.sandboxpowered.eventhandler.EventHandler;

public final class BlockEvents {
    public static final EventHandler<BreakEvent> BREAK = EventHandlerFactory.createEventHandler();
    public static final EventHandler<PlaceEvent> PLACE = EventHandlerFactory.createEventHandler();
    public static final EventHandler<InteractEvent> INTERACT = EventHandlerFactory.createEventHandler();

    public interface BreakEvent {
        void onEvent(World world, Position position, BlockState state, Entity player, ItemStack tool, Cancellable cancellable);
    }

    public interface PlaceEvent {
        BlockState onEvent(World world, Position position, BlockState state, Entity player, ItemStack stack, Cancellable cancellable);
    }

    public interface InteractEvent {
        InteractionResult onEvent(World world, Position position, BlockState state, Entity player, Hand hand, ItemStack stack, InteractionResult result);
    }
}