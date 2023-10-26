package edu.hw3.Task7;

import java.util.Comparator;

public class NullKeyComparator implements Comparator<String> {

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
