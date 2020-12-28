package org.sandboxpowered.api.block;

import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.state.BlockState;

public interface CropBlock {
    Item getSeed();

    int getAge(BlockState state);

    int getMaxAge();

    BlockState stateForAge(int age);
}
