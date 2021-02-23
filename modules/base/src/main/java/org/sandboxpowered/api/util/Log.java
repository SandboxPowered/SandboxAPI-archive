package org.sandboxpowered.api.util;

public interface Log {
    void info(String message);

    void error(String message);

    void debug(String message);

    void info(String message, Object... args);

    void error(String message, Object... args);

    void debug(String message, Object... args);

    void error(String message, Throwable e);
}
