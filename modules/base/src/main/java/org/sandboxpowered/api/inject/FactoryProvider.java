package org.sandboxpowered.api.inject;

public interface FactoryProvider {
    <T> T get(Class<T> factoryClass) throws FactoryNotFoundException;

    class FactoryNotFoundException extends RuntimeException {
        public FactoryNotFoundException(String message) {
            super(message);
        }

        public FactoryNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }

        public FactoryNotFoundException(Throwable cause) {
            super(cause);
        }
    }
}
