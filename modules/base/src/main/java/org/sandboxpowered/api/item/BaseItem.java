package org.sandboxpowered.api.item;

import org.sandboxpowered.api.util.Identity;

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
}
