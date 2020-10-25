package org.sandboxpowered.api.resources;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public final class ResourceType {
    private static final Map<String, ResourceType> TYPES = new TreeMap<>();
    private final String id;

    public ResourceType(@NotNull String id) {
        this.id = Objects.requireNonNull(id);
    }

    public static ResourceType of(String id) {
        if (!id.toLowerCase().equals(id)) {
            throw new IllegalArgumentException(String.format("Type id must be lowercase got '%s'", id));
        }
        return TYPES.computeIfAbsent(id, ResourceType::new);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ResourceType && id.equals(((ResourceType) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}