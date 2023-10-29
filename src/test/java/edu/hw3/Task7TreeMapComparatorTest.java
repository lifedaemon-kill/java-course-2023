package edu.hw3;

import java.util.TreeMap;
import edu.hw3.Task7.NullKeyComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Task7TreeMapComparatorTest {

    @Test
    @DisplayName("null can be key for tree")
    void test1() {
        // Arrange
        TreeMap<String, String> tree = new TreeMap<>(new NullKeyComparator());

        tree.put(null, "test");
        tree.put("aa", "123");
        tree.put("ac", "678");
        tree.put("ab", "345");

        // Act
        boolean result = tree.containsKey(null);
        // Assert
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("null key is the highest in treemap")
    void test2() {
        // Arrange
        TreeMap<String, String> tree = new TreeMap<>(new NullKeyComparator());

        tree.put("aa", "123");
        tree.put("ac", "678");
        tree.put(null, "test");
        tree.put("ab", "345");

        // Act
        String result = tree.toString();

        // Assert
        assertThat(result).isEqualTo("{null=test, aa=123, ab=345, ac=678}");
    }
}
