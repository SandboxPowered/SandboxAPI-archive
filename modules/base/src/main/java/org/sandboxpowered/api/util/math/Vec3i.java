package org.sandboxpowered.api.util.math;

import org.sandboxpowered.internal.InternalService;

public interface Vec3i {
    static Vec3i create(int x, int y, int z) {
        return InternalService.getInstance().createVec3i(x, y, z);
    }

    int getX();

    int getY();

    int getZ();

    Vec3i add(int x, int y, int z);

    Vec3i sub(int x, int y, int z);

    default Vec3i add(Vec3i vec) {
        return add(vec.getX(), vec.getY(), vec.getZ());
    }

    default Vec3i sub(Vec3i vec) {
        return sub(vec.getX(), vec.getY(), vec.getZ());
    }
}