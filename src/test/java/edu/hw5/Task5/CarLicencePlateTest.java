package edu.hw5.Task5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarLicencePlateTest {
    @Test
    @DisplayName("Корректный номер 1")
    void test1() {
        boolean result = LicensePlates.isValidDefaultCar("А123ВЕ777");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Корректный номер 2")
    void test2() {
        boolean result = LicensePlates.isValidDefaultCar("О777ОО77");
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Некорректный номер - Чисел в первой половине больше чем нужно")
    void test3() {
        boolean result = LicensePlates.isValidDefaultCar("123АВЕ777");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Некорректный номер - Буква без латинского аналога")
    void test4() {
        boolean result = LicensePlates.isValidDefaultCar("А123ВГ77");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Код региона больше чем нужно")
    void test5() {
        boolean result = LicensePlates.isValidDefaultCar("А123ВЕ7777");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Код региона меньше чем нужно")
    void test6() {
        boolean result = LicensePlates.isValidDefaultCar("А123ВЕ7");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Лишняя цифра")
    void test7() {
        boolean result = LicensePlates.isValidDefaultCar("А1234ВЕ77");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Лишняя буква во второй половине")
    void test8() {
        boolean result = LicensePlates.isValidDefaultCar("А124ВЕВ77");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Отсутствующая буква во второй половине")
    void test9() {
        boolean result = LicensePlates.isValidDefaultCar("А124В77");
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Отсутствует буква в начале")
    void test10() {
        boolean result = LicensePlates.isValidDefaultCar("124ВА77");
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("Посторонние символы")
    void test11() {
        boolean result = LicensePlates.isValidDefaultCar("А А124ВА77 234А88");
        assertThat(result).isFalse();
    }
    @Test
    @DisplayName("Номера с тремя нулями не может существовать")
    void test12() {
        boolean result = LicensePlates.isValidDefaultCar("А000АА777");
        assertThat(result).isFalse();
    }
}
