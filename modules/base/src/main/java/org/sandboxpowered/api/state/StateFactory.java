package org.sandboxpowered.api.state;

import org.sandboxpowered.api.state.property.Property;
import org.sandboxpowered.api.state.property.PropertyContainer;

import java.util.Collection;

public interface StateFactory<T, S extends PropertyContainer<S>> {
    S getBaseState();

    T getBaseObject();

    Collection<S> getValidStates();

    interface Builder<T, S extends PropertyContainer<S>> {
        StateFactory.Builder<T, S> add(Property<?>... properties);
    }
}