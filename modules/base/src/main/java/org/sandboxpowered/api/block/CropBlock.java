package org.sandboxpowered.api.block;

import org.jetbrains.annotations.Range;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.state.BlockState;

public interface CropBlock {
    Item getSeed();

    @Range(from = 0, to = Integer.MAX_VALUE)
    int getAge(BlockState state);

    @Range(from = 0, to = Integer.MAX_VALUE)
    int getMaxAge();

    BlockState stateForAge(int age);
}
