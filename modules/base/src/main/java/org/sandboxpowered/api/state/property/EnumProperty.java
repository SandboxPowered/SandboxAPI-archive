package org.sandboxpowered.api.state.property;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EnumProperty<E extends Enum<E>> extends AbstractProperty<E> {
    private final ImmutableSet<E> values;
    private final Map<String, E> names = new HashMap<>();

    private EnumProperty(String name, Class<E> type, Collection<E> collection) {
        super(name, type);
        this.values = ImmutableSet.copyOf(collection);
        values.forEach(e -> names.put(getName(e), e));
    }

    public static <T extends Enum<T>> EnumProperty<T> of(String name, Class<T> type) {
        return of(name, type, t -> true);
    }

    public static <T extends Enum<T>> EnumProperty<T> of(String name, Class<T> type, Predicate<T> predicate) {
        return of(name, type, Arrays.stream(type.getEnumConstants()).filter(predicate).collect(Collectors.toList()));
    }

    public static <T extends Enum<T>> EnumProperty<T> of(String name, Class<T> type, T... values) {
        return of(name, type, Lists.newArrayList(values));
    }

    public static <T extends Enum<T>> EnumProperty<T> of(String name, Class<T> type, Collection<T> values) {
        return new EnumProperty<>(name, type, values);
    }

    @Override
    public String getName(E value) {
        return value.name().toLowerCase(Locale.ENGLISH); //TODO: replace with proper name methods
    }

    @Override
    public Collection<E> getValues() {
        return values;
    }

    @Override
    public Optional<E> getValue(String name) {
        return Optional.ofNullable(names.get(name));
    }
}