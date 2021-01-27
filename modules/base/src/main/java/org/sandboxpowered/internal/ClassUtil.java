package org.sandboxpowered.internal;

import org.sandboxpowered.api.util.annotation.Internal;

import java.lang.annotation.Annotation;
import java.util.*;

/**
 * Internal class
 */
@Internal
public final class ClassUtil {
    private static final Map<Class<?>, Map<Class<? extends Annotation>, Boolean>> annotationCache = new LinkedHashMap<>();
    private static final Map<Class<?>, List<Class<?>>> superCache = new HashMap<>();
    private ClassUtil() {
    }

    public static boolean isAnnotationPresent(Class<?> aClass, Class<? extends Annotation> annotation) {
        return annotationCache.computeIfAbsent(aClass, a -> new LinkedHashMap<>()).computeIfAbsent(annotation, annotationClass -> {
            List<Class<?>> classes = lookupAllSuper(aClass);
            for (Class<?> c : classes)
                if (c.isAnnotationPresent(annotationClass))
                    return true;
            return false;
        });
    }


    public static List<Class<?>> lookupAllSuper(Class<?> eventClass) {
        synchronized (superCache) {
            return superCache.computeIfAbsent(eventClass, ec -> {
                List<Class<?>> types = new ArrayList<>();
                while (ec != null) {
                    types.add(ec);
                    ec = ec.getSuperclass();
                    if (ec == Object.class)
                        ec = null;
                }
                return types;
            });
        }
    }
}