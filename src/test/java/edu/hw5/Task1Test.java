package edu.hw5;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw5.Task1.AverageTime.averageTime;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Две пары дат")
    void test1() {
        //Arrange
        List<String> dates = new ArrayList<>();
        dates.add("2022-03-12, 20:20 - 2022-03-12, 23:50");
        dates.add("2022-04-01, 21:30 - 2022-04-02, 01:20");
        //Act
        String answer = averageTime(dates);
        //Assert
        assertThat(answer).isEqualTo("3ч 40м");
    }

    @Test
    @DisplayName("Часы равны 0")
    void test2() {
        //Arrange
        List<String> dates = new ArrayList<>();
        dates.add("2022-03-12, 21:20 - 2022-03-12, 21:30");
        dates.add("2022-04-01, 21:30 - 2022-04-01, 21:30");
        //Act
        String answer = averageTime(dates);
        //Assert
        assertThat(answer).isEqualTo("0ч 5м");
    }

    @Test
    @DisplayName("Часов больше чем 24")
    void test3() {
        //Arrange
        List<String> dates = new ArrayList<>();
        dates.add("2022-03-12, 21:20 - 2022-03-14, 21:20");
        dates.add("2022-04-01, 21:30 - 2022-04-08, 21:30");
        //Act
        String answer = averageTime(dates);
        //Assert
        assertThat(answer).isEqualTo("108ч 0м");
    }

    @Test
    @DisplayName("Строка не валидна(нет разделителя)")
    void test4() {
        //Arrange
        List<String> dates = new ArrayList<>();
        dates.add("2022-03-12, 21:20-2022-03-14, 21:20");
        dates.add("2022-04-01, 21:30 - 2022-04-01, 21:50");
        //Act
        String answer = averageTime(dates);
        //Assert
        assertThat(answer).isEqualTo("0ч 20м");
    }

    @Test
    @DisplayName("Строка не валидна(нет нет разделителя в дате)")
    void test5() {
        //Arrange
        List<String> dates = new ArrayList<>();
        dates.add("2022 03 12, 21:20 - 2022-03-14, 21:20");
        dates.add("2022-04-01, 21:30 - 2022-04-01, 21:50");
        //Act
        String answer = averageTime(dates);
        //Assert
        assertThat(answer).isEqualTo("0ч 20м");
    }

    @Test
    @DisplayName("Строка не валидна(дата разделена пробелами)")
    void test6() {
        //Arrange
        List<String> dates = new ArrayList<>();
        dates.add("2022 03 12, 21:20 - 2022 03 14, 21:20");
        dates.add("2022-04-01, 21:30 - 2022-04-01, 21:50");
        //Act
        String answer = averageTime(dates);
        //Assert
        assertThat(answer).isEqualTo("0ч 20м");
    }

    @Test
    @DisplayName("Строка не валидна(несколько разделителей)")
    void test7() {
        //Arrange
        List<String> dates = new ArrayList<>();
        dates.add("2022-03-12, 21:20 - 2022-03-14, 21:20 - 2022-03-16, 21:20");
        dates.add("2022-04-01, 21:30 - 2022-04-01, 21:50");
        //Act
        String answer = averageTime(dates);
        //Assert
        assertThat(answer).isEqualTo("0ч 20м");
    }

    @Test
    @DisplayName("Пустой массив")
    void testEmpty() {
        //Arrange
        List<String> dates = new ArrayList<>();
        //Act
        String answer = averageTime(dates);
        //Assert
        assertThat(answer).isEqualTo("0ч 0м");
    }
}
