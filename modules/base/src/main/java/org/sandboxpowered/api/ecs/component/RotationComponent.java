package org.sandboxpowered.api.ecs.component;

public class RotationComponent implements PooledComponent {
    private float yaw;
    private float pitch;

    public float getYaw() {
        return yaw;
    }

    public void setYaw(float yaw) {
        this.yaw = yaw;
    }

    public float getPitch() {
        return pitch;
    }

    public void setPitch(float pitch) {
        this.pitch = pitch;
    }

    @Override
    public void reset() {
        yaw = 0;
        pitch = 0;
    }
}
