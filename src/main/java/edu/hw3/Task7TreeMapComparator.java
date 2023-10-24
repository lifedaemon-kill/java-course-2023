package edu.hw3;

import java.util.Comparator;

public class Task7TreeMapComparator {
    private Task7TreeMapComparator() {
    }

    static class NullKeyComparator implements Comparator<String> {
        @Override
        public int compare(String key1, String key2) {
            if (key1 == null && key2 == null) {
                return 0;
            } else if (key1 == null) {
                return -1;
            } else if (key2 == null) {
                return 1;
            } else {
                return key1.compareTo(key2);
            }
        }
    }
}
