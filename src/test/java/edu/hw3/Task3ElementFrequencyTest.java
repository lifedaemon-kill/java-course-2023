package edu.hw3;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task3.ElementFrequency.freqDict;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3ElementFrequencyTest {
    @Test
    @DisplayName("Дважды повторяющиеся элементы")
    void test1() {
        // Arrange
        Object[] request = {"a", "bb", "a", "bb"};
        HashMap<Object, Integer> expected = new HashMap<>() {{
            put("bb", 2);
            put("a", 2);
        }};
        // Act
        HashMap<Object, Integer> answerArray = freqDict(request);
        // Assert
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("Один элемент повторяется два раза")
    void test2() {
        // Arrange
        Object[] request = {"this", "and", "that", "and"};
        HashMap<Object, Integer> expected = new HashMap<>() {{
            put("that", 1);
            put("and", 2);
            put("this", 1);
        }};
        // Act
        HashMap<Object, Integer> answerArray = freqDict(request);
        // Assert
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("Трижды повторяющийся элемент")
    void test3() {
        // Arrange
        Object[] request = {"код", "код", "код", "bug"};
        HashMap<Object, Integer> expected = new HashMap<>() {{
            put("код", 3);
            put("bug", 1);
        }};
        // Act
        HashMap<Object, Integer> answerArray = freqDict(request);
        // Assert
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("Два элемента повторяются два раза")
    void test4() {
        // Arrange
        Object[] request = {1, 1, 2, 2};
        HashMap<Object, Integer> expected = new HashMap<>() {{
            put(1, 2);
            put(2, 2);
        }};
        // Act
        HashMap<Object, Integer> answerArray = freqDict(request);
        // Assert
        assertThat(answerArray).isEqualTo(expected);
    }
    @Test
    @DisplayName("Отправляется пустой массив")
    void test5() {
        // Arrange
        Object[] request = {};
        HashMap<Object, Integer> expected = new HashMap<>();
        // Act
        HashMap<Object, Integer> answerArray = freqDict(request);
        // Assert
        assertThat(answerArray).isEqualTo(expected);
    }
}
