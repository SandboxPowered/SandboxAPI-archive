package org.sandboxpowered.api.registry;

import org.sandboxpowered.api.addon.AddonInfo;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.util.Identity;

import java.util.Optional;
import java.util.function.Consumer;

public interface Registrar {
    AddonInfo getSourceAddon();

    <T extends Content<T>> Registry.Entry<T> getEntry(Identity identity, Class<T> tClass);

    <T extends Content<T>> Registry.Entry<T> getEntry(Identity identity, Registry<T> registry);

    <T extends Content<T>> Registry.Entry<T> register(T content);

    default <T extends Content<T>> Registry.Entry<T> register(String name, T content) {
        if (content.getIdentity() != null)
            throw new IllegalArgumentException("Cannot register content with existing identity to new identity");
        return register(content.setIdentity(Identity.of(getSourceAddon().getId(), name)));
    }

    <T extends Service> Optional<T> getRegistrarService(Class<T> tClass);

    default <T extends Service> void useRegistrarService(Class<T> tClass, Consumer<T> tConsumer) {
        getRegistrarService(tClass).ifPresent(tConsumer);
    }

    default <T extends Service> void useRegistrarService(Class<T> tClass, Consumer<T> tConsumer, Runnable runnable) {
        Optional<T> serviceOptional = getRegistrarService(tClass);
        if (serviceOptional.isPresent()) {
            tConsumer.accept(serviceOptional.get());
        } else {
            runnable.run();
        }
    }

    interface Service {
    }
}