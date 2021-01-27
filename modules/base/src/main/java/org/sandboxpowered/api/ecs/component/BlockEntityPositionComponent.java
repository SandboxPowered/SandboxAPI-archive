package org.sandboxpowered.api.ecs.component;

import org.sandboxpowered.api.util.math.Position;

public class BlockEntityPositionComponent implements PooledComponent {
    private int x;
    private int y;
    private int z;

    public Position asPos() {
        return Position.create(x, y, z);
    }

    public void copyFromPos(Position vec) {
        x = vec.getX();
        y = vec.getY();
        z = vec.getZ();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public boolean ableToApplyOn(Type type) {
        return type == Type.BLOCK_ENTITY;
    }

    @Override
    public void reset() {
        x = y = z = 0;
    }
}