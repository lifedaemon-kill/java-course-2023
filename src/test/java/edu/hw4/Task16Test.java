package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task16Test {
    @Test
    @DisplayName("Корректные значения")
    void test1() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.F, 4, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 3, 120, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.CAT, Animal.Sex.F, 8, 10, 15, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 100, 1500, 3000, false));
        animals.add(new Animal("Bob", Animal.Type.BIRD, Animal.Sex.F, 95, 1500, 3000, false));
        animals.add(new Animal("Bobbibski", Animal.Type.DOG, Animal.Sex.M, 50, 1500, 30, false));
        animals.add(new Animal("Bobbibbi", Animal.Type.DOG, Animal.Sex.M, 1000, 1500, 100000, false));

        List<Animal> expected = new ArrayList<>();
        expected.add(animals.get(1));
        expected.add(animals.get(2));
        expected.add(animals.get(0));
        expected.add(animals.get(6));
        expected.add(animals.get(5));
        expected.add(animals.get(4));
        expected.add(animals.get(3));

        // Act
        List<Animal> result = AnimalsData.getSortedTypeSexNameABS(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Пустой массив")
    void test2() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        // Act
        List<Animal> result = AnimalsData.getSortedTypeSexNameABS(animals);
        //Assert
        assertThat(result).isEmpty();
    }
}
