package org.sandboxpowered.api.util.math;

import org.sandboxpowered.api.inject.Sandbox;

public interface Vec2f {
    static Vec2f create(float x, float y) {
        return Sandbox.getFactoryProvider().get(Factory.class).create(x, y);
    }

    float getX();

    float getY();

    Vec2f normalize();

    Vec2f add(float x, float y);

    interface Factory {
        Vec2f create(float x, float y);
    }
}
