package org.sandboxpowered.api.resources;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public interface ResourceManager<C> {
    void add(ResourceMaterial material, ResourceType... types);

    void add(ResourceMaterial material, ResourceType[] types, Function<ResourceType, C> function);

    void add(ResourceMaterial material, ResourceType[] types, BiFunction<ResourceMaterial, ResourceType, C> biFunction);

    void add(ResourceMaterial material, ResourceType type);

    void add(ResourceMaterial material, ResourceType type, Supplier<C> supplier);

    void add(ResourceMaterial material, ResourceType type, C content);

    boolean contains(ResourceMaterial material, ResourceType type);
}