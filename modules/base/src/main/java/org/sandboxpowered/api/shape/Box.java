package org.sandboxpowered.api.shape;

import org.sandboxpowered.api.inject.Sandbox;
import org.sandboxpowered.api.util.math.Position;

public interface Box {
    static Box cube(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        return of(minX / 16d, minY / 16d, minZ / 16d, maxX / 16d, maxY / 16d, maxZ / 16d);
    }

    static Box of(Position pos1, Position pos2) {
        return of(pos1.getX(), pos1.getY(), pos1.getZ(), pos2.getX(), pos2.getY(), pos2.getZ());
    }

    static Box of(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return Sandbox.getFactoryProvider().get(Factory.class).create(minX, minY, minZ, maxX, maxY, maxZ);
    }

    interface Factory {
        Box create(int minX, int minY, int minZ, int maxX, int maxY, int maxZ);

        Box create(double minX, double minY, double minZ, double maxX, double maxY, double maxZ);
    }
}