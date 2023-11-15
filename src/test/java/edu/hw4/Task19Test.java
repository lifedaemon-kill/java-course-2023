package edu.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task19Test {
    @Test
    @DisplayName("Некорректное имя")
    void test1() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();

        animals1.add(new Animal(null, Animal.Type.DOG, Animal.Sex.F, 4, 24, 30000000, true));
        animals1.add(new Animal("", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));
        animals1.add(new Animal("Bob", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));

        Map<String, Set<ValidationError>> expected = new HashMap<>();

        Set<ValidationError> errors = new HashSet<>();
        errors.add(ValidationError.NAME_EMPTY);
        expected.put(null, errors);

        errors = new HashSet<>();
        errors.add(ValidationError.NAME_EMPTY);
        expected.put("", errors);

        // Act
        Map<String, Set<ValidationError>> result = AnimalsData.getMapValidationErrors(animals1);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Некорректный тип")
    void test2() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();

        animals1.add(new Animal("Bobby Fisher Smiled", null, Animal.Sex.F, 8, 10, 15, true));
        animals1.add(new Animal("Bob", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));

        Map<String, Set<ValidationError>> expected = new HashMap<>();

        Set<ValidationError> errors = new HashSet<>();
        errors.add(ValidationError.INVALID_TYPE);
        expected.put("Bobby Fisher Smiled", errors);

        // Act
        Map<String, Set<ValidationError>> result = AnimalsData.getMapValidationErrors(animals1);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Некорректный пол")
    void test3() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();

        animals1.add(new Animal("Bobby", Animal.Type.DOG, null, 100, 1500, 3000, false));
        animals1.add(new Animal("Bob", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));

        Map<String, Set<ValidationError>> expected = new HashMap<>();

        Set<ValidationError> errors = new HashSet<>();
        errors.add(ValidationError.INVALID_SEX);
        expected.put("Bobby", errors);

        // Act
        Map<String, Set<ValidationError>> result = AnimalsData.getMapValidationErrors(animals1);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Некорректный возраст")
    void test4() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();

        animals1.add(new Animal("Bobby B", Animal.Type.DOG, Animal.Sex.F, -1, 1500, 3000, false));
        animals1.add(new Animal("Bob", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));

        Map<String, Set<ValidationError>> expected = new HashMap<>();

        Set<ValidationError> errors = new HashSet<>();
        errors.add(ValidationError.INVALID_AGE);
        expected.put("Bobby B", errors);

        // Act
        Map<String, Set<ValidationError>> result = AnimalsData.getMapValidationErrors(animals1);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Некорректный рост")
    void test5() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();

        animals1.add(new Animal("Bob", Animal.Type.FISH, Animal.Sex.F, 95, 0, 15, true));
        animals1.add(new Animal("Bobi", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));

        Map<String, Set<ValidationError>> expected = new HashMap<>();

        Set<ValidationError> errors = new HashSet<>();
        errors.add(ValidationError.INVALID_HEIGHT);
        expected.put("Bob", errors);

        // Act
        Map<String, Set<ValidationError>> result = AnimalsData.getMapValidationErrors(animals1);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Некорректный вес")
    void test6() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();

        animals1.add(new Animal("Bobbibski", Animal.Type.SPIDER, Animal.Sex.M, 50, 1500, -20, true));
        animals1.add(new Animal("Bobi", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));

        Map<String, Set<ValidationError>> expected = new HashMap<>();

        Set<ValidationError> errors = new HashSet<>();
        errors.add(ValidationError.INVALID_WEIGHT);
        expected.put("Bobbibski", errors);

        // Act
        Map<String, Set<ValidationError>> result = AnimalsData.getMapValidationErrors(animals1);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Все поля с ошибками")
    void test7() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();

        animals1.add(new Animal("Bobbibbi The Broken", null, null, 0, -1231, -1000, true));
        animals1.add(new Animal("Bobi", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));

        Map<String, Set<ValidationError>> expected = new HashMap<>();

        Set<ValidationError> errors = new HashSet<>();
        errors.add(ValidationError.INVALID_TYPE);
        errors.add(ValidationError.INVALID_SEX);
        errors.add(ValidationError.INVALID_AGE);
        errors.add(ValidationError.INVALID_HEIGHT);
        errors.add(ValidationError.INVALID_WEIGHT);
        expected.put("Bobbibbi The Broken", errors);

        // Act
        Map<String, Set<ValidationError>> result = AnimalsData.getMapValidationErrors(animals1);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Ошибок нет")
    void test8() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();
        animals1.add(new Animal("Bobi", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));
        // Act
        Map<String, Set<ValidationError>> result = AnimalsData.getMapValidationErrors(animals1);
        //Assert
        assertThat(result).isEmpty();
    }
}
