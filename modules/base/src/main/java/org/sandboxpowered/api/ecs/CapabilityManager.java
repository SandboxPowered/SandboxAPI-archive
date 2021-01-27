package org.sandboxpowered.api.ecs;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.capability.Capability;
import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.Mono;

public interface CapabilityManager {
    <X> Mono<X> getEntityCapability(int entity, Capability<X> capability);

    <X> Mono<X> getBlockEntityCapability(int entity, Capability<X> capability, @Nullable Direction direction);
}
