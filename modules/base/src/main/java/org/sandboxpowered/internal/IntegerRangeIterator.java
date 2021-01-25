package org.sandboxpowered.internal;

import org.sandboxpowered.api.util.annotation.Internal;

import java.util.Iterator;
import java.util.NoSuchElementException;

@Internal
public class IntegerRangeIterator implements Iterator<Integer> {
    private final int end;
    private int current;

    public IntegerRangeIterator(int end) {
        this(0, end);
    }

    public IntegerRangeIterator(int start, int end) {
        this.current = start;
        this.end = end;
    }

    @Override
    public boolean hasNext() {
        return current < end;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if(!hasNext())
            throw new NoSuchElementException();
        return current++;
    }
}
