package org.sandboxpowered.api.ecs.component;

import org.sandboxpowered.api.util.math.Position;

public class BlockEntityPositionComponent implements PooledEntityComponent {
    public int x, y, z;

    public Position asPos() {
        return Position.create(x, y, z);
    }

    public void copyFromPos(Position vec) {
        x = vec.getX();
        y = vec.getY();
        z = vec.getZ();
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