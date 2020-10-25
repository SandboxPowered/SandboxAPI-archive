package org.sandboxpowered.api.tags;

import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.entity.Entity.Type;
import org.sandboxpowered.api.fluid.Fluid;
import org.sandboxpowered.api.item.Item;

public interface TagManager {
    TagGroup<Block> getBlocks();

    TagGroup<Item> getItems();

    TagGroup<Fluid> getFluids();

    TagGroup<Type> getEntities();
}
