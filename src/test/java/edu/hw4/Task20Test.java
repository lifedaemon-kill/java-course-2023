package edu.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task20Test {
    @Test
    @DisplayName("Все поля с ошибками")
    void test1() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();

        animals1.add(new Animal("Bobbibbi The Broken", null, null, 0, -1231, -1000, true));
        animals1.add(new Animal("Bobi", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));

        Map<String, String> expected = new HashMap<>();

        String errors = ValidationError.INVALID_TYPE +
                        "__" +
                        ValidationError.INVALID_SEX +
                        "__" +
                        ValidationError.INVALID_AGE +
                        "__" +
                        ValidationError.INVALID_HEIGHT +
                        "__" +
                        ValidationError.INVALID_WEIGHT;

        expected.put("Bobbibbi The Broken", errors);

        // Act
        Map<String, String> result = AnimalsData.getMapValidationErrorsString(animals1);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Одно поле с ошибкой (Рост)")
    void test3() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();

        animals1.add(new Animal("Bob", Animal.Type.FISH, Animal.Sex.F, 95, 0, 15, true));
        animals1.add(new Animal("Bobi", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));

        Map<String, String> expected = new HashMap<>();

        String errors = ValidationError.INVALID_HEIGHT.name();

        expected.put("Bob", errors);

        // Act
        Map<String, String> result = AnimalsData.getMapValidationErrorsString(animals1);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Ошибок нет")
    void test2() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();
        animals1.add(new Animal("Bobi", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));
        // Act
        Map<String, String> result = AnimalsData.getMapValidationErrorsString(animals1);
        //Assert
        assertThat(result).isEmpty();
    }
}
