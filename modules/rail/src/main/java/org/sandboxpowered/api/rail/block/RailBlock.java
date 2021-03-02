package org.sandboxpowered.api.rail.block;

import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.ecs.Entity;
import org.sandboxpowered.api.rail.RailDirection;
import org.sandboxpowered.api.state.BlockState;

public interface RailBlock extends Block {
    RailDirection getRailDirection(BlockState state, Entity minecart);
}
