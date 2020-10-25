package org.sandboxpowered.api.resources;

import org.sandboxpowered.api.content.Content;

import java.util.Set;
import java.util.function.Supplier;

public interface Resource<C extends Content<C>> extends Supplier<C> {
    Set<C> getVariants();

    ResourceMaterial getMaterial();

    ResourceType<C> getForm();
}