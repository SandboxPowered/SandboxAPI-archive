package org.sandboxpowered.api.ecs.component;

import org.sandboxpowered.api.util.math.Vec3d;

public class PositionComponent implements PooledEntityComponent {
    public double x, y, z;

    public Vec3d asVec3d() {
        return Vec3d.of(x, y, z);
    }

    public void copyFromVec(Vec3d vec) {
        x = vec.getX();
        y = vec.getY();
        z = vec.getZ();
    }

    @Override
    public void reset() {
        x = y = z = 0;
    }
}