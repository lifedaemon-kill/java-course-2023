package edu.hw3.Task8;

import java.util.Collection;
import java.util.Iterator;

public class BackwardIterator<T> implements Iterator<T> {
    Collection<T> collection;
    private int currentIndex;

    public BackwardIterator(Collection<T> collection) {
        this.collection = collection;
        this.currentIndex = collection.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public T next() {
        return (T) collection.toArray()[currentIndex--];
    }
}