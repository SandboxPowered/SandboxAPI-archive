package org.sandboxpowered.api.resources;

import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.item.ItemStack;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.regex.Pattern;

public final class ResourceType<C extends Content<C>> {
    private static final Pattern VALID_NAME = Pattern.compile("[^a-z_]");
    private static final Map<String, ResourceType<?>> TYPES = new TreeMap<>();
    private final String id;
    private final Function<ResourceMaterial, C> defaultCreator;
    private final Function<C, ItemStack> stackFunction;

    public ResourceType(@NotNull String id, Function<ResourceMaterial, C> defaultCreator, Function<C, ItemStack> stackFunction) {
        this.id = Objects.requireNonNull(id);
        this.defaultCreator = defaultCreator;
        this.stackFunction = stackFunction;
    }

    public static <C extends Content<C>> ResourceType<C> of(String id, Function<ResourceMaterial, C> defaultCreator, Function<C, ItemStack> stackFunction) {
        if (VALID_NAME.matcher(id).matches()) {
            throw new IllegalArgumentException(String.format("Type id must be lowercase got '%s'", id));
        }
        return (ResourceType<C>) TYPES.computeIfAbsent(id, s -> new ResourceType<>(s, defaultCreator, stackFunction));
    }

    public static <X extends Content<X>> ResourceType<X> find(String id) {
        return (ResourceType<X>) TYPES.get(id);
    }

    @Override
    public String toString() {
        return id;
    }

    public C createContent(ResourceMaterial material) {
        return defaultCreator.apply(material);
    }

    public ItemStack createItemStack(C c) {
        return stackFunction.apply(c);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof ResourceType && id.equals(((ResourceType<?>) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
