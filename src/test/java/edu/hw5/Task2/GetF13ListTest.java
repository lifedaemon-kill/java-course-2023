package edu.hw5.Task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task2.Friday13.getF13List;
import static org.assertj.core.api.Assertions.assertThat;

public class GetF13ListTest {
    @Test
    @DisplayName("Функция находит все даты для 1925 года")
    void test1() {
        //Arrange
        int year = 1925;
        List<LocalDate> expected = new ArrayList<>();
        expected.add(LocalDate.parse("1925-02-13"));
        expected.add(LocalDate.parse("1925-03-13"));
        expected.add(LocalDate.parse("1925-11-13"));

        //Act
        List<LocalDate> dates;
        dates = getF13List(year);

        //Assert
        assertThat(dates).isEqualTo(expected);
    }

    @Test
    @DisplayName("Функция находит все даты для 2024 года")
    void test2() {
        //Arrange
        int year = 2024;

        List<LocalDate> expected = new ArrayList<>();
        expected.add(LocalDate.parse("2024-09-13"));
        expected.add(LocalDate.parse("2024-12-13"));

        //Act
        List<LocalDate> dates;
        dates = getF13List(year);

        //Assert
        assertThat(dates).isEqualTo(expected);
    }

    @Test
    @DisplayName("Нет года в котором нет пятницы 13")
    void test3() {
        //Arrange
        List<LocalDate> dates;
        List<Integer> empties = new ArrayList<>();
        //Act
        for (int year = 0; year < 1000000; year++) {
            dates = getF13List(year);
            if (dates.isEmpty()) {
                empties.add(year);
                System.out.println(year);
            }
        }
        //Assert
        assertThat(empties).isEmpty();
    }
}
