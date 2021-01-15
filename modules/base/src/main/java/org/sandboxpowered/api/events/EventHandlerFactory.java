package org.sandboxpowered.api.events;

import org.sandboxpowered.api.inject.Sandbox;
import org.sandboxpowered.eventhandler.EventHandler;

public interface EventHandlerFactory {
    static <X> EventHandler<X> createEventHandler() {
        return Sandbox.getFactoryProvider().get(EventHandlerFactory.class).create();
    }

    <X> EventHandler<X> create();
}