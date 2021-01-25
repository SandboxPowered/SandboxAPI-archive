package org.sandboxpowered.api.resources;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public final class ResourceMaterial {
    private static final Map<String, ResourceMaterial> MATERIALS = new TreeMap<>();
    private final String id;

    private ResourceMaterial(@NotNull String id) {
        this.id = Objects.requireNonNull(id);
    }

    public static ResourceMaterial of(String id) {
        if (!id.equalsIgnoreCase(id)) {
            throw new IllegalArgumentException(String.format("Material id must be lowercase got '%s'", id));
        }
        return MATERIALS.computeIfAbsent(id, ResourceMaterial::new);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ResourceMaterial && id.equals(((ResourceMaterial) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
