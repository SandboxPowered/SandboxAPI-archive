package org.sandboxpowered.api.world;

import org.sandboxpowered.api.ecs.CapabilityManager;
import org.sandboxpowered.api.ecs.ComponentMapper;
import org.sandboxpowered.api.ecs.EntityBlueprint;
import org.sandboxpowered.api.ecs.component.Component;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.state.FluidState;
import org.sandboxpowered.api.tags.TagManager;
import org.sandboxpowered.api.util.math.Position;

public interface WorldReader {
    BlockState getBlockState(Position position);

    int getBlockEntity(Position position);

    FluidState getFluidState(Position position);

    default boolean isValid(Position position) {
        return isHeightValid(position) && position.getX() >= -30000000 && position.getZ() >= -30000000 && position.getX() < 30000000 && position.getZ() < 30000000;
    }

    default boolean isHeightValid(Position position) {
        return isHeightValid(position.getY());
    }

    default boolean isHeightValid(int height) {
        return height >= 0 && height < 256;
    }

    long getWorldTime();

    TagManager getTagManager();

    <T extends Component> ComponentMapper<T> getMapper(Class<T> type);

    int createEntity();

    int createEntity(EntityBlueprint blueprint);

    void removeEntity(int entity);

    CapabilityManager getCapabilityManager();
}