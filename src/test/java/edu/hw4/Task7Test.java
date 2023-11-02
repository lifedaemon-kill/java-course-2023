package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Корректные значения")
    void test1() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 4, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.CAT, Animal.Sex.F, 3, 10, 5, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 7, false));

        Animal expected = animals.get(0);

        // Act
        Animal result = AnimalsData.getOldestAnimalWithPosition(animals, 2);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Несколько с одинаковым возрастом")
    void test2() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 5, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.CAT, Animal.Sex.F, 5, 10, 5, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 700, false));

        Animal expected = animals.get(2);

        // Act
        Animal result = AnimalsData.getOldestAnimalWithPosition(animals, 2);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("пустой")
    void test3() {
        // Arrange
        List<Animal> animals = new ArrayList<>();

        // Act
        Animal result = AnimalsData.getOldestAnimalWithPosition(animals, 0);

        //Assert
        assertThat(result).isNull();
    }

    @Test
    @DisplayName("К выходит за границы массива")
    void test4() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 5, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.CAT, Animal.Sex.F, 5, 10, 5, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 700, false));

        // Act
        Animal result = AnimalsData.getOldestAnimalWithPosition(animals, 10);

        //Assert
        assertThat(result).isNull();
    }
}
