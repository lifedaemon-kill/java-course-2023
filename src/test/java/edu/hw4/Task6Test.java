package edu.hw4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Один тип")
    void test1() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.CAT, Animal.Sex.F, 5, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.CAT, Animal.Sex.F, 3, 10, 5, false));
        animals.add(new Animal("Bobby", Animal.Type.CAT, Animal.Sex.F, 10000, 1500, 700, false));

        Map<Animal.Type, Animal> expected = new HashMap<>();
        expected.put(Animal.Type.CAT, animals.get(3));

        // Act
        Map<Animal.Type, Animal> result = AnimalsData.getMapOfHeaviest(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Несколько типов")
    void test2() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.CAT, Animal.Sex.F, 5, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 3, 10, 5, false));
        animals.add(new Animal("Bobby", Animal.Type.FISH, Animal.Sex.F, 10000, 1500, 700, false));

        Map<Animal.Type, Animal> expected = new HashMap<>();
        expected.put(Animal.Type.CAT, animals.get(1));
        expected.put(Animal.Type.DOG, animals.get(2));
        expected.put(Animal.Type.FISH, animals.get(3));
        // Act
        Map<Animal.Type, Animal> result = AnimalsData.getMapOfHeaviest(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Несколько животных одного веса")
    void test3() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 5, 40, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.CAT, Animal.Sex.F, 5, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 3, 10, 5, false));
        animals.add(new Animal("Bobby", Animal.Type.FISH, Animal.Sex.F, 10000, 1500, 700, false));

        Map<Animal.Type, Animal> expected = new HashMap<>();
        expected.put(Animal.Type.CAT, animals.get(1));
        expected.put(Animal.Type.DOG, animals.get(2));
        expected.put(Animal.Type.FISH, animals.get(3));
        // Act
        Map<Animal.Type, Animal> result = AnimalsData.getMapOfHeaviest(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Пустой массив")
    void test4() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        Map<Animal.Type, Animal> expected = new HashMap<>();
        // Act
        Map<Animal.Type, Animal> result = AnimalsData.getMapOfHeaviest(animals);
        //Assert
        assertThat(result).isEqualTo(expected);
    }
}
