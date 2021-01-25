package org.sandboxpowered.api.client.rendering.events;

import org.sandboxpowered.api.client.rendering.VertexConsumer;
import org.sandboxpowered.api.events.EventHandlerFactory;
import org.sandboxpowered.api.util.math.MatrixStack;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.eventhandler.EventHandler;

public final class RenderEvents {
    public static final EventHandler<RenderInWorld> RENDER_IN_WORLD = EventHandlerFactory.createEventHandler();

    public interface RenderInWorld {
        void onEvent(World world, MatrixStack stack, VertexConsumer.Provider provider);
    }
}
