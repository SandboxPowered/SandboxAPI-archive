package org.sandboxpowered.api.item;

import org.sandboxpowered.api.item.tool.ToolType;
import org.sandboxpowered.api.util.Identity;

import java.util.Set;

public class BaseItem implements Item {
    private final Settings settings;
    private Identity identity;

    public BaseItem(Settings settings) {
        this.settings = settings;
    }

    @Override
    public Settings getSettings() {
        return settings;
    }

    @Override
    public Identity getIdentity() {
        return identity;
    }

    @Override
    public Item setIdentity(Identity identity) {
        if (this.identity != null)
            throw new UnsupportedOperationException("Cannot set identity on content with existing identity");
        this.identity = identity;
        return this;
    }

    @Override
    public Set<ToolType> getToolTypes(ItemStack stack) {
        return getSettings().getToolTypes();
    }
}
