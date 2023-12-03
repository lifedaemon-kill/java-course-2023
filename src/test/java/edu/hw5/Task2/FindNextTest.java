package edu.hw5.Task2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static edu.hw5.Task2.Friday13.findNextF13;
import static org.assertj.core.api.Assertions.assertThat;

public class FindNextTest {
    @Test
    @DisplayName("На вход дается пятница 13")
    void test1() {
        //Arrange
        LocalDate expected = LocalDate.parse("1925-11-13");
        //Act
        LocalDate answer = findNextF13(LocalDate.parse("1925-03-13"));
        //Assert
        assertThat(answer).isEqualTo(expected);
    }
    @Test
    @DisplayName("Пятница 13 через несколько месяцев")
    void test2() {
        //Arrange
        LocalDate expected = LocalDate.parse("1925-11-13");
        //Act
        LocalDate answer = findNextF13(LocalDate.parse("1925-05-01"));
        //Assert
        assertThat(answer).isEqualTo(expected);
    }
}
