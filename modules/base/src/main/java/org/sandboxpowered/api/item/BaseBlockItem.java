package org.sandboxpowered.api.item;

import org.sandboxpowered.api.block.BaseBlock;

public class BaseBlockItem extends BaseItem implements BlockItem {
    private final BaseBlock block;

    public BaseBlockItem(BaseBlock block, Settings settings) {
        super(settings);
        this.block = block;
    }

    @Override
    public BaseBlock asBlock() {
        return block;
    }
}