package org.sandboxpowered.api.util.math;

import org.sandboxpowered.internal.InternalService;

public interface Vec3d {
    static Vec3d of(double x, double y, double z) {
        return InternalService.getInstance().createVec3d(x,y,z);
    }

    double getX();

    double getY();

    double getZ();

    Vec3d normalize();

    Vec3d add(double x, double y, double z);
}
