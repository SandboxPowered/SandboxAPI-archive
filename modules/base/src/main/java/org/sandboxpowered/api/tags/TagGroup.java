package org.sandboxpowered.api.tags;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.util.Identity;

public interface TagGroup<C extends Content<C>> {
    @Nullable
    Tag<C> getTag(Identity id);

    Tag<C> getTagOrEmpty(Identity id);

    Identity getTagId(Tag<C> tag);
}
