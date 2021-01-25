package org.sandboxpowered.api.util.math;

import org.sandboxpowered.api.inject.Sandbox;

public interface Vec3f {
    static Vec3f create(float x, float y, float z) {
        return Sandbox.getFactoryProvider().get(Factory.class).create(x, y, z);
    }

    float getX();

    float getY();

    float getZ();

    Vec3f normalize();

    Vec3f add(float x, float y, float z);

    interface Factory {
        Vec3f create(float x, float y, float z);
    }
}
