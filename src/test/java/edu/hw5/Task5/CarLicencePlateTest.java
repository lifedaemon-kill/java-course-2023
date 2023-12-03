package edu.hw5.Task5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarLicencePlateTest {
    @Test
    @DisplayName("Корректный номер 1")
    void test1() {
        String plate = "А123ВЕ777";

        boolean result = LicensePlates.isValidDefaultCar(plate);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Корректный номер 2")
    void test2() {
        String plate = "О777ОО77";

        boolean result = LicensePlates.isValidDefaultCar(plate);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Некорректный номер - Чисел в первой половине больше чем нужно")
    void test3() {
        String plate = "123АВЕ777";

        boolean result = LicensePlates.isValidDefaultCar(plate);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Некорректный номер - Буква без латинского аналога")
    void test4() {
        String plate = "А123ВГ77";

        boolean result = LicensePlates.isValidDefaultCar(plate);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Код региона больше чем нужно")
    void test5() {
        String plate = "А123ВЕ7777";

        boolean result = LicensePlates.isValidDefaultCar(plate);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Код региона меньше чем нужно")
    void test6() {
        String plate = "А123ВЕ7";

        boolean result = LicensePlates.isValidDefaultCar(plate);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Лишняя цифра")
    void test7() {
        String plate = "А1234ВЕ77";

        boolean result = LicensePlates.isValidDefaultCar(plate);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Лишняя буква во второй половине")
    void test8() {
        String plate = "А124ВЕВ77";

        boolean result = LicensePlates.isValidDefaultCar(plate);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Отсутствующая буква во второй половине")
    void test9() {
        String plate = "А124В77";

        boolean result = LicensePlates.isValidDefaultCar(plate);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Отсутствует буква в начале")
    void test10() {
        String plate = "124ВА77";

        boolean result = LicensePlates.isValidDefaultCar(plate);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Посторонние символы")
    void test11() {
        String plate = "А А124ВА77 234А88";

        boolean result = LicensePlates.isValidDefaultCar(plate);

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Номера с тремя нулями не может существовать")
    void test12() {
        String plate = "А000АА777";

        boolean result = LicensePlates.isValidDefaultCar(plate);

        assertThat(result).isFalse();
    }
}
