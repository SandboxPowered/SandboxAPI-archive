package org.sandboxpowered.api.client.rendering.entity;

import org.sandboxpowered.api.client.rendering.VertexConsumer;
import org.sandboxpowered.api.ecs.EntityBag;
import org.sandboxpowered.api.ecs.Subscription;
import org.sandboxpowered.api.util.math.MatrixStack;
import org.sandboxpowered.api.world.World;

public abstract class EntityRenderingSystem {
    private final World world;
    private final Subscription subscription;

    public EntityRenderingSystem(World world, Subscription subscription) {
        this.world = world;
        this.subscription = subscription;
    }

    protected abstract void render(int entity, MatrixStack stack, VertexConsumer.Provider provider);

    public final void process(MatrixStack stack, VertexConsumer.Provider provider) {
        EntityBag entities = subscription.getEntities();
        int entityCount = entities.size();
        if (entityCount == 0) {
            return;
        }

        int[] ids = entities.getData();
        for (int i = 0; entityCount > i; i++) {
            stack.push();
            render(ids[i], stack, provider);
            stack.pop();
        }
    }
}
