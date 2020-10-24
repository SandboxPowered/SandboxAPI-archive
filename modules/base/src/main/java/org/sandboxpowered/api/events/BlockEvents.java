package org.sandboxpowered.api.events;

import org.sandboxpowered.api.entity.player.Hand;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.InteractionResult;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.eventhandler.Cancellable;
import org.sandboxpowered.eventhandler.EventHandler;
import org.sandboxpowered.eventhandler.Returnable;
import org.sandboxpowered.internal.InternalService;

public final class BlockEvents {
    public static final EventHandler<BreakEvent> BREAK = InternalService.getInstance().createEventHandler();
    public static final EventHandler<PlaceEvent> PLACE = InternalService.getInstance().createEventHandler();
    public static final EventHandler<InteractEvent> INTERACT = InternalService.getInstance().createEventHandler();

    public interface BreakEvent {
        void onEvent(World world, Position position, BlockState state, PlayerEntity player, ItemStack tool, Cancellable cancellable);
    }

    public interface PlaceEvent {
        BlockState onEvent(World world, Position position, BlockState state, PlayerEntity player, ItemStack stack, Cancellable cancellable);
    }

    public interface InteractEvent {
        InteractionResult onEvent(World world, Position position, BlockState state, PlayerEntity player, Hand hand, ItemStack stack, InteractionResult result);
    }
}