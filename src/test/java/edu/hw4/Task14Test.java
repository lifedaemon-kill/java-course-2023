package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Task14Test {
    @Test
    @DisplayName("Корректные значения")
    void test1() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 4, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 3, 120, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 8, 10, 15, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 3000, false));

        // Act
        boolean result = AnimalsData.isAnyDogHigherK(animals, 100);

        //Assert
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Подходящих значений нет")
    void test2() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 4, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 3, 120, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 8, 10, 15, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 3000, false));

        // Act
        boolean result = AnimalsData.isAnyDogHigherK(animals, 121);

        //Assert
        assertThat(result).isFalse();
    }
}
