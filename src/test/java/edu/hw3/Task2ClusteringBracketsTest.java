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
    @DisplayName("Paired brackets")
    void test1() {
        // Arrange
        String request = "()()()";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("()", "()", "()"));
        // Act
        var answerArray = clusterize(request);
        // Assert
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("Two times nested pairs of brackets")
    void test2() {
        // Arrange
        String request = "((()))";
        ArrayList<String> expected = new ArrayList<>(List.of("((()))"));
        // Act
        var answerArray = clusterize(request);
        // Assert
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("Several in a row of nested brackets")
    void test3() {
        // Arrange
        String request = "((()))(())()()(()())";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("((()))", "(())", "()", "()", "(()())"));
        // Act
        var answerArray = clusterize(request);
        // Assert
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("Pair of nested parentheses in one nesting")
    void test4() {
        // Arrange
        String request = "((())())(()(()()))";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("((())())", "(()(()()))"));
        // Act
        var answerArray = clusterize(request);
        // Assert
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("Скобки без пар")
    void test5() {
        // Arrange
        String request = ")()()(";
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("()", "()"));
        // Act
        var answerArray = clusterize(request);
        // Assert
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("Только открытые скобки")
    void test6() {
        // Arrange
        String request = "(((()";
        ArrayList<String> expected = new ArrayList<>(List.of());
        // Act
        var answerArray = clusterize(request);
        // Assert
        assertThat(answerArray).isEqualTo(expected);
    }

    @Test
    @DisplayName("Лишние символы в строке")
    void test7() {
        // Arrange
        String request = "((Tinkoff)(Course)(2023))";
        ArrayList<String> expected = new ArrayList<>(List.of("(()()())"));
        // Act
        var answerArray = clusterize(request);
        // Assert
        assertThat(answerArray).isEqualTo(expected);
    }
}

