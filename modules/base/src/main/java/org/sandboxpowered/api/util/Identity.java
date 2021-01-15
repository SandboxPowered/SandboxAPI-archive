package org.sandboxpowered.api.util;

import org.sandboxpowered.api.inject.Sandbox;
import org.sandboxpowered.internal.InternalService;

public interface Identity {
    static Identity of(String namespace, String path) {
        return Sandbox.getFactoryProvider().get(Factory.class).create(namespace, path);
    }

    static Identity of(String identity) {
        return Sandbox.getFactoryProvider().get(Factory.class).create(identity);
    }

    String getNamespace();

    String getPath();

    interface Factory {
        Identity create(String namespace, String path);

        Identity create(String id);
    }

    interface Variant extends Identity {
        static Variant of(Identity identity, String variant) {
            return InternalService.getInstance().createVariantIdentity(identity, variant);
        }

        static Variant of(String identity, String variant) {
            return InternalService.getInstance().createVariantIdentity(Identity.of(identity), variant);
        }

        static Variant of(String namespace, String path, String variant) {
            return InternalService.getInstance().createVariantIdentity(Identity.of(namespace, path), variant);
        }

        String getVariant();
    }
}