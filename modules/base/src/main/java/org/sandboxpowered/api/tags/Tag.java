package org.sandboxpowered.api.tags;

import org.sandboxpowered.api.content.Content;

import java.util.Random;
import java.util.stream.Stream;

public interface Tag<C extends Content<C>> {
    boolean contains(C content);

    Stream<C> values();

    C getRandom(Random random);
}
