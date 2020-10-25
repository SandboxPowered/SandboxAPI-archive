package org.sandboxpowered.api.state.property;

public abstract class AbstractProperty<T extends Comparable<T>> implements Property<T> {
    private final Class<T> type;
    private final String name;

    public AbstractProperty(String name, Class<T> type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Class<T> getValueType() {
        return type;
    }

    @Override
    public int hashCode() {
        return 31 * this.type.hashCode() + this.name.hashCode();
    }
}
