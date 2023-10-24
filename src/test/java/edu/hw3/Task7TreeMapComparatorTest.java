package edu.hw3;

import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task7TreeMapComparator.NullKeyComparator;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7TreeMapComparatorTest {

    @Test
    @DisplayName("1 Тест с курса")
    void test1() {
        TreeMap<String, String> tree = new TreeMap<>(new NullKeyComparator());

        tree.put(null, "test");
        tree.put("aa", "123");
        tree.put("ac", "678");
        tree.put("ab", "345");

        assertThat(tree.containsKey(null)).isTrue();
    }

    @Test
    @DisplayName("null key is the highest")
    void test2() {
        TreeMap<String, String> tree = new TreeMap<>(new NullKeyComparator());

        tree.put("aa", "123");
        tree.put("ac", "678");
        tree.put(null, "test");
        tree.put("ab", "345");

        assertThat(tree.toString()).isEqualTo("{null=test, aa=123, ab=345, ac=678}");
    }
}
