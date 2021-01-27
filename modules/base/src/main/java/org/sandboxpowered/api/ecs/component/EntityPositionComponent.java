package org.sandboxpowered.api.ecs.component;

import org.sandboxpowered.api.util.math.Vec3d;

public class EntityPositionComponent implements PooledComponent {
    private double x;
    private double y;
    private double z;

    public Vec3d asVec3d() {
        return Vec3d.of(x, y, z);
    }

    public void copyFromVec(Vec3d vec) {
        x = vec.getX();
        y = vec.getY();
        z = vec.getZ();
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public boolean ableToApplyOn(Type type) {
        return type == Type.ENTITY;
    }

    @Override
    public void reset() {
        x = y = z = 0;
    }
}