package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task2Test {
    @Test
    @DisplayName("Сортировка животных по весу, К = длине массива")
    void test1() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Мистер кот", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Мистер паук", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 0, true));
        animals.add(new Animal("Джон", Animal.Type.DOG, Animal.Sex.M, 5, 40, 15, true));
        animals.add(new Animal("Королева рыб", Animal.Type.FISH, Animal.Sex.F, 3, 10, 5, false));
        animals.add(new Animal("Птица феникс", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 700, false));

        List<Animal> expected = new ArrayList<>();
        expected.add(animals.get(4));
        expected.add(animals.get(2));
        expected.add(animals.get(3));
        expected.add(animals.get(0));
        expected.add(animals.get(1));

        // Act
        List<Animal> result = AnimalsData.getSortedAnimalsByWeightDesc(animals, animals.size());

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Сортировка животных по весу, К = половине длине массива")
    void test3() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Мистер кот", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Мистер паук", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 0, true));
        animals.add(new Animal("Джон", Animal.Type.DOG, Animal.Sex.M, 5, 40, 15, true));
        animals.add(new Animal("Королева рыб", Animal.Type.FISH, Animal.Sex.F, 3, 10, 5, false));
        animals.add(new Animal("Птица феникс", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 700, false));

        List<Animal> expected = new ArrayList<>();
        expected.add(animals.get(4));
        expected.add(animals.get(2));

        // Act
        List<Animal> result = AnimalsData.getSortedAnimalsByWeightDesc(animals, animals.size() / 2);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Сортировка животных по весу, К = 0")
    void test4() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Мистер кот", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Мистер паук", Animal.Type.SPIDER, Animal.Sex.M, 1, 1, 0, true));
        animals.add(new Animal("Джон", Animal.Type.DOG, Animal.Sex.M, 5, 40, 15, true));
        animals.add(new Animal("Королева рыб", Animal.Type.FISH, Animal.Sex.F, 3, 10, 5, false));
        animals.add(new Animal("Птица феникс", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 700, false));

        List<Animal> expected = new ArrayList<>();

        // Act
        List<Animal> result = AnimalsData.getSortedAnimalsByWeightDesc(animals, 0);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Пустой массив")
    void test2() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        List<Animal> expected = new ArrayList<>();
        // Act
        List<Animal> result = AnimalsData.getSortedAnimalsByWeightDesc(animals, 0);
        //Assert
        assertThat(result).isEqualTo(expected);
    }
}
