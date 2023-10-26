package edu.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw3.Task2.ClusteringBrackets.clusterize;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2ClusteringBracketsTest {

    @Test
    @DisplayName("1 Тест с курса")
    void test1() {
        String request = "()()()";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("()", "()", "()"));

        var answerArray = clusterize(request);
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("2 Тест с курса")
    void test2() {
        String request = "((()))";
        ArrayList<String> expected = new ArrayList<>(List.of("((()))"));

        var answerArray = clusterize(request);
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("3 Тест с курса")
    void test3() {
        String request = "((()))(())()()(()())";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("((()))", "(())", "()", "()", "(()())"));

        var answerArray = clusterize(request);
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("4 Тест с курса")
    void test4() {
        String request = "((())())(()(()()))";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("((())())", "(()(()()))"));

        var answerArray = clusterize(request);
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("Скобки без пар")
    void test5() {
        String request = ")()()(";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("()", "()"));

        var answerArray = clusterize(request);
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("Только открытые скобки")
    void test6() {
        String request = "(((()";
        ArrayList<String> expected = new ArrayList<>(List.of());

        var answerArray = clusterize(request);
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("Лишние символы в строке")
    void test7() {
        String request = "((Tinkoff)(Course)(2023))";
        ArrayList<String> expected = new ArrayList<>(List.of("(()()())"));

        var answerArray = clusterize(request);
        assertThat(answerArray).isEqualTo(expected);
    }
}

