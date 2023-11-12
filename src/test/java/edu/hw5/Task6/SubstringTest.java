package edu.hw5.Task6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task6.Substring.isSubstring;
import static org.assertj.core.api.Assertions.assertThat;

public class SubstringTest {
    @Test
    @DisplayName("Является подстрокой")
    void test1() {
        boolean result = isSubstring("abc", "achfdbaabgabcaabg");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Не является подстрокой")
    void test2() {
        boolean result = isSubstring("abc", "acbc");
        assertThat(result).isFalse();
    }
}
