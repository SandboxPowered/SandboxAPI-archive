package org.sandboxpowered.api.util.math;

import org.sandboxpowered.api.inject.Sandbox;

public interface Vec2i {
    static Vec2i create(int x, int y) {
        return Sandbox.getFactoryProvider().get(Factory.class).create(x, y);
    }

    int getX();

    int getY();

    interface Factory {
        Vec2i create(int x, int y);
    }
}