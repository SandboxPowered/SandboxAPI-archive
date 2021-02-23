package org.sandboxpowered.api.events;

import org.sandboxpowered.api.ecs.Entity;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.eventhandler.EventHandler;

public final class ItemEvents {
    public static final EventHandler<ArrowTypeEvent> GET_ARROW_TYPE = EventHandlerFactory.createEventHandler();
    public static final EventHandler<DamageEvent> DAMAGE = EventHandlerFactory.createEventHandler();
    public static final EventHandler<MiningSpeedEvent> MINING_SPEED = EventHandlerFactory.createEventHandler();

    public static final EventHandler<ShowDurabilityBarEvent> SHOW_DURABILITY_BAR = EventHandlerFactory.createEventHandler();
    public static final EventHandler<DurabilityDisplayEvent> GET_DURABILITY_VALUE = EventHandlerFactory.createEventHandler();
    public static final EventHandler<DurabilityColorEvent> GET_DURABILITY_COLOR = EventHandlerFactory.createEventHandler();

    public static final EventHandler<DrawStackCount> DRAW_STACK_COUNT = EventHandlerFactory.createEventHandler();

    public interface MiningSpeedEvent {
        float onEvent(World world, Entity player, ItemStack stack, BlockState state, float speed);
    }

    public interface DamageEvent {
        int onEvent(World world, Entity player, ItemStack stack, int damage);
    }

    public interface ArrowTypeEvent {
        ItemStack onEvent(World world, Entity entity, ItemStack bow, ItemStack arrow);
    }

    public interface ShowDurabilityBarEvent {
        boolean onEvent(ItemStack stack, boolean previous);
    }

    public interface DurabilityDisplayEvent {
        float onEvent(ItemStack stack, float previous);
    }

    public interface DurabilityColorEvent {
        int onEvent(ItemStack stack, int previous);
    }

    public interface DrawStackCount {
        boolean onEvent(ItemStack stack, boolean previous);
    }
}