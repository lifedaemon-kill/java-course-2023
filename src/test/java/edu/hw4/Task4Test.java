package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Самое длинное имя в середине")
    void test1() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.M, 5, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 3, 10, 5, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 700, false));

        Animal expected = animals.get(2);

        // Act
        Animal result = AnimalsData.getAnimalWithLongestName(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Несколько животных с самым длинным именем")
    void test2() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("aad", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("aac", Animal.Type.DOG, Animal.Sex.M, 5, 40, 15, true));
        animals.add(new Animal("aaa", Animal.Type.DOG, Animal.Sex.F, 3, 10, 5, false));
        animals.add(new Animal("aab", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 700, false));

        Animal expected = animals.get(0);

        // Act
        Animal result = AnimalsData.getAnimalWithLongestName(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Несколько животных с самым длинным именем")
    void test3() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("aad", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("aac", Animal.Type.DOG, Animal.Sex.M, 5, 40, 15, true));
        animals.add(new Animal("aaa", Animal.Type.DOG, Animal.Sex.F, 3, 10, 5, false));
        animals.add(new Animal("aab", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 700, false));

        Animal expected = animals.get(0);

        // Act
        Animal result = AnimalsData.getAnimalWithLongestName(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }
}
