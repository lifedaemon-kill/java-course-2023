package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw4.Animal.Sex;
import static edu.hw4.Animal.Type;
import static org.assertj.core.api.Assertions.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Сортировка животных по росту")
    void test1() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Мистер кот", Type.CAT, Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Мистер паук", Type.SPIDER, Sex.M, 1, 1, 0, true));
        animals.add(new Animal("Джон", Type.DOG, Sex.M, 5, 40, 15, true));
        animals.add(new Animal("Королева рыб", Type.FISH, Sex.F, 3, 10, 5, false));
        animals.add(new Animal("Птица феникс", Type.BIRD, Sex.F, 10000, 1500, 700, false));

        List<Animal> expected = new ArrayList<>();
        expected.add(animals.get(1));
        expected.add(animals.get(3));
        expected.add(animals.get(0));
        expected.add(animals.get(2));
        expected.add(animals.get(4));

        // Act
        List<Animal> result = AnimalsData.getSortedAnimalsByHeight(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Пустой массив")
    void test2() {
        //Arrange
        List<Animal> animals = new ArrayList<>();
        List<Animal> expected = new ArrayList<>();

        //Act
        List<Animal> result = AnimalsData.getSortedAnimalsByHeight(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }
}
