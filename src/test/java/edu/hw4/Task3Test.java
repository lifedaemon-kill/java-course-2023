package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Один тип животного повторяется два раза")
    void test1() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Мистер кот", Animal.Type.CAT,     Animal.Sex.M, 5,     24,   3, true));
        animals.add(new Animal("Джон", Animal.Type.DOG,           Animal.Sex.M, 5,     40,   15, true));
        animals.add(new Animal("Королева рыб", Animal.Type.DOG,  Animal.Sex.F, 3,     10,   5, false));
        animals.add(new Animal("Птица феникс", Animal.Type.BIRD,  Animal.Sex.F, 10000, 1500, 700, false));

        Map<Animal.Type, Integer> expected = new HashMap<>();
        expected.put(Animal.Type.CAT, 1);
        expected.put(Animal.Type.DOG, 2);
        expected.put(Animal.Type.BIRD, 1);

        // Act
        Map<Animal.Type, Integer> result = AnimalsData.getAnimalTypeMap(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }
    @Test
    @DisplayName("Ни один тип не повторяется")
    void test2() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Мистер кот", Animal.Type.CAT,     Animal.Sex.M, 5,     24,   3, true));
        animals.add(new Animal("Джон", Animal.Type.DOG,           Animal.Sex.M, 5,     40,   15, true));
        animals.add(new Animal("Королева рыб", Animal.Type.FISH,  Animal.Sex.F, 3,     10,   5, false));
        animals.add(new Animal("Птица феникс", Animal.Type.BIRD,  Animal.Sex.F, 10000, 1500, 700, false));

        Map<Animal.Type, Integer> expected = new HashMap<>();
        expected.put(Animal.Type.CAT, 1);
        expected.put(Animal.Type.DOG, 1);
        expected.put(Animal.Type.BIRD, 1);
        expected.put(Animal.Type.FISH, 1);
        // Act
        Map<Animal.Type, Integer> result = AnimalsData.getAnimalTypeMap(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }
    @Test
    @DisplayName("Несколько типов повторяется несколько раз")
    void test3() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Мистер кот", Animal.Type.CAT,     Animal.Sex.M, 5,     24,   3, true));
        animals.add(new Animal("Джон", Animal.Type.DOG,           Animal.Sex.M, 5,     40,   15, true));
        animals.add(new Animal("Королева рыб", Animal.Type.DOG,  Animal.Sex.F, 3,     10,   5, false));
        animals.add(new Animal("Птица феникс", Animal.Type.CAT,  Animal.Sex.F, 10000, 1500, 700, false));

        Map<Animal.Type, Integer> expected = new HashMap<>();
        expected.put(Animal.Type.CAT, 2);
        expected.put(Animal.Type.DOG, 2);
        // Act
        Map<Animal.Type, Integer> result = AnimalsData.getAnimalTypeMap(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }
    @Test
    @DisplayName("Пустой массив")
    void test4() {
        // Arrange
        List<Animal> animals = new ArrayList<>();

        Map<Animal.Type, Integer> expected = new HashMap<>();

        // Act
        Map<Animal.Type, Integer> result = AnimalsData.getAnimalTypeMap(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }
}
