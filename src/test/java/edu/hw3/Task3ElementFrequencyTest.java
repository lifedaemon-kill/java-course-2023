package edu.hw3;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task3ElementFrequency.freqDict;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3ElementFrequencyTest {
    @Test
    @DisplayName("1 Тест с курса")
    void test1() {
        Object[] request = {"a", "bb", "a", "bb"};

        HashMap<Object, Integer> expected = new HashMap<>() {{
            put("bb", 2);
            put("a", 2);
        }};
        HashMap<Object, Integer> answerArray = freqDict(request);

        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("2 Тест с курса")
    void test2() {
        Object[] request = {"this", "and", "that", "and"};

        HashMap<Object, Integer> expected = new HashMap<>() {{
                put("that", 1);
                put("and", 2);
                put("this", 1);
        }};

        HashMap<Object, Integer> answerArray = freqDict(request);

        assertThat(answerArray).isEqualTo(expected);
    }
    @Test
    @DisplayName("3 Тест с курса")
    void test3() {
        Object[] request = {"код", "код", "код", "bug"};

        HashMap<Object, Integer> expected = new HashMap<>() {{
            put("код", 3);
            put("bug", 1);
        }};

        HashMap<Object, Integer> answerArray = freqDict(request);

        assertThat(answerArray).isEqualTo(expected);
    }
    @Test
    @DisplayName("4 Тест с курса")
    void test4() {
        Object[] request = {1, 1, 2, 2};

        HashMap<Object, Integer> expected = new HashMap<>() {{
            put(1, 2);
            put(2, 2);
        }};

        HashMap<Object, Integer> answerArray = freqDict(request);

        assertThat(answerArray).isEqualTo(expected);
    }
}
