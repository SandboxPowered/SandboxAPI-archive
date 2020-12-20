package org.sandboxpowered.api.content;

import org.sandboxpowered.api.item.BlockItem;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.tags.Tag;
import org.sandboxpowered.api.util.Identity;

public interface Content<T extends Content<T>> {
    Class<T> getContentType();

    @SuppressWarnings("unchecked")
    default T asContentType() {
        return (T) this;
    }

    default Identity getRegistryIdentity() {
        return Registry.getRegistryFromType(getContentType()).getIdentity();
    }

    Identity getIdentity();

    T setIdentity(Identity identity);

    default boolean isIn(Tag<T> tag) {
        return tag.contains(asContentType());
    }
}
