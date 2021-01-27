package org.sandboxpowered.api.capability;

public class Capability<T> {
    private final Class<T> tClass;

    public Capability(Class<T> tClass) {
        this.tClass = tClass;
    }
}