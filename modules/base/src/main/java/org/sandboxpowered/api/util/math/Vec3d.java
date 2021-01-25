package org.sandboxpowered.api.util.math;

import org.sandboxpowered.api.inject.Sandbox;

public interface Vec3d {
    static Vec3d of(double x, double y, double z) {
        return Sandbox.getFactoryProvider().get(Factory.class).create(x, y, z);
    }

    double getX();

    double getY();

    double getZ();

    Vec3d normalize();

    Vec3d add(double x, double y, double z);

    interface Factory {
        Vec3d create(double x, double y, double z);
    }
}
