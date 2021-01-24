package org.sandboxpowered.api.block;

public interface Material {

    PistonInteraction getPistonInteraction();

    boolean doesBlockMovement();

    boolean isBurnable();

    boolean isBreakByHand();

    boolean isLiquid();

    boolean doesBlockLight();

    boolean isReplaceable();

    boolean isSolid();

    enum PistonInteraction {
        NORMAL,
        DESTROY,
        BLOCK,
        IGNORE,
        PUSH_ONLY
    }
}