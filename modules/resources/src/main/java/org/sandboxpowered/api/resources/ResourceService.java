package org.sandboxpowered.api.resources;

import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.registry.Registrar;

import java.util.function.Supplier;

public interface ResourceService extends Registrar.Service {
    void add(ResourceMaterial material, ResourceType<?>... types);

    <C extends Content<C>> void add(ResourceMaterial material, ResourceType<C> type);

    <C extends Content<C>> void add(ResourceMaterial material, ResourceType<C> type, Supplier<C> supplier);

    <C extends Content<C>> void add(ResourceMaterial material, ResourceType<C> type, C content);

    <C extends Content<C>> boolean contains(ResourceMaterial material, ResourceType<C> type);
}
