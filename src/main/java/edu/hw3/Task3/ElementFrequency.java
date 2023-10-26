package edu.hw3.Task3;

import java.util.HashMap;

public final class ElementFrequency {
    private ElementFrequency() {
    }

    public static HashMap<Object, Integer> freqDict(Object[] array) {
        HashMap<Object, Integer> result = new HashMap<>();

        for (var key : array) {
            if (result.containsKey(key)) {
                result.put(key, result.get(key) + 1);
            } else {
                result.put(key, 1);
            }
        }

        return result;
    }
}
