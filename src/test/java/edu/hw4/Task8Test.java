package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Корректные значения")
    void test1() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 4, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.CAT, Animal.Sex.F, 3, 10, 10, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 7, false));

        Optional<Animal> expected = Optional.ofNullable(animals.get(2));

        // Act
        Optional<Animal> result = AnimalsData.getHeaviestBelowKCm(animals, 25);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Несколько одного веса")
    void test2() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 4, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.CAT, Animal.Sex.F, 3, 10, 10, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 10, false));

        Optional<Animal> expected = Optional.ofNullable(animals.get(2));

        // Act
        Optional<Animal> result = AnimalsData.getHeaviestBelowKCm(animals, 25);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Такое животное не найдется")
    void test3() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 4, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.CAT, Animal.Sex.F, 3, 10, 10, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 10000, 150, 10, false));

        Optional<Animal> expected = Optional.ofNullable(animals.get(1));

        // Act
        Optional<Animal> result = AnimalsData.getHeaviestBelowKCm(animals, 1000);

        //Assert
        assertThat(result).isEqualTo(expected);
    }
}
