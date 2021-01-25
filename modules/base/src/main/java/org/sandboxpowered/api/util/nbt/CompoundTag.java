package org.sandboxpowered.api.util.nbt;

import org.sandboxpowered.api.inject.Sandbox;

public interface CompoundTag extends Tag, ReadableCompoundTag, WritableCompoundTag {
    static CompoundTag create() {
        return Sandbox.getFactoryProvider().get(Factory.class).create();
    }

    interface Factory {
        CompoundTag create();
    }
}