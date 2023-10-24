package edu.hw3;

import java.util.Collection;
import java.util.Iterator;

final class Task8BackwardIterator {
    private Task8BackwardIterator() {
    }

    static class BackwardIterator<T> implements Iterator<T> {
        Collection<T> collection;
        private int currentIndex;

        BackwardIterator(Collection<T> collection) {
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
}
