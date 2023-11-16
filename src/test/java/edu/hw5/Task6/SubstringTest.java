package edu.hw5.Task6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task6.Substring.isSubstring;
import static org.assertj.core.api.Assertions.assertThat;

public class SubstringTest {
    @Test
    @DisplayName("Является подстрокой")
    void test1() {
        String sub = "abc";
        String main = "achfdbaabgabcaabg";

        boolean result = isSubstring(sub, main);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Не является подстрокой")
    void test2() {
        String sub = "abc";
        String main = "acbc";

        boolean result = isSubstring(sub, main);

        assertThat(result).isFalse();
    }
}
