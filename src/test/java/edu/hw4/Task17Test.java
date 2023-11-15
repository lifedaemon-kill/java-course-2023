package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task17Test {
    @Test
    @DisplayName("Кусающих пауков меньше по количеству но больше в процентах 2/3 vs 3/5")
    void test1() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 4, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.M, 3, 120, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 8, 10, 15, true));
        animals.add(new Animal("Bobby", Animal.Type.DOG, Animal.Sex.F, 100, 1500, 3000, false));
        animals.add(new Animal("Bobby B", Animal.Type.DOG, Animal.Sex.F, 100, 1500, 3000, false));
        animals.add(new Animal("Bob", Animal.Type.SPIDER, Animal.Sex.F, 95, 1500, 3000, true));
        animals.add(new Animal("Bobbibski", Animal.Type.SPIDER, Animal.Sex.M, 50, 1500, 30, true));
        animals.add(new Animal("Bobbibbi", Animal.Type.SPIDER, Animal.Sex.M, 1000, 1500, 100000, false));

        // Act
        boolean result = AnimalsData.isSpidersBitesMoreThenDogs(animals);

        //Assert
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Кусающих собак больше")
    void test2() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 4, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.M, 3, 120, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 8, 10, 15, true));
        animals.add(new Animal("Bobby", Animal.Type.DOG, Animal.Sex.F, 100, 1500, 3000, true));
        animals.add(new Animal("Bobby B", Animal.Type.DOG, Animal.Sex.F, 100, 1500, 3000, false));
        animals.add(new Animal("Bob", Animal.Type.SPIDER, Animal.Sex.F, 95, 1500, 3000, true));
        animals.add(new Animal("Bobbibski", Animal.Type.SPIDER, Animal.Sex.M, 50, 1500, 30, true));
        animals.add(new Animal("Bobbibbi", Animal.Type.SPIDER, Animal.Sex.M, 1000, 1500, 100000, false));

        // Act
        boolean result = AnimalsData.isSpidersBitesMoreThenDogs(animals);

        //Assert
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Данных для ответа недостаточно, нет пауков")
    void test3() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 4, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.M, 3, 120, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 8, 10, 15, true));
        animals.add(new Animal("Bobby", Animal.Type.DOG, Animal.Sex.F, 100, 1500, 3000, true));
        animals.add(new Animal("Bobby B", Animal.Type.DOG, Animal.Sex.F, 100, 1500, 3000, false));
        animals.add(new Animal("Bob", Animal.Type.BIRD, Animal.Sex.F, 95, 1500, 3000, true));
        animals.add(new Animal("Bobbibski", Animal.Type.BIRD, Animal.Sex.M, 50, 1500, 30, true));
        animals.add(new Animal("Bobbibbi", Animal.Type.BIRD, Animal.Sex.M, 1000, 1500, 100000, false));

        // Act
        boolean result = AnimalsData.isSpidersBitesMoreThenDogs(animals);

        //Assert
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Данных для ответа недостаточно, нет собак")
    void test4() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.SPIDER, Animal.Sex.F, 4, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.BIRD, Animal.Sex.M, 3, 120, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.CAT, Animal.Sex.F, 8, 10, 15, true));
        animals.add(new Animal("Bobby", Animal.Type.FISH, Animal.Sex.F, 100, 1500, 3000, true));
        animals.add(new Animal("Bobby B", Animal.Type.CAT, Animal.Sex.F, 100, 1500, 3000, false));
        animals.add(new Animal("Bob", Animal.Type.SPIDER, Animal.Sex.F, 95, 1500, 3000, true));
        animals.add(new Animal("Bobbibski", Animal.Type.SPIDER, Animal.Sex.M, 50, 1500, 30, true));
        animals.add(new Animal("Bobbibbi", Animal.Type.SPIDER, Animal.Sex.M, 1000, 1500, 100000, false));

        // Act
        boolean result = AnimalsData.isSpidersBitesMoreThenDogs(animals);

        //Assert
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Данных для ответа недостаточно, нет пауков и собак")
    void test5() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.F, 4, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.BIRD, Animal.Sex.M, 3, 120, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.CAT, Animal.Sex.F, 8, 10, 15, true));
        animals.add(new Animal("Bobby", Animal.Type.FISH, Animal.Sex.F, 100, 1500, 3000, true));
        animals.add(new Animal("Bobby B", Animal.Type.CAT, Animal.Sex.F, 100, 1500, 3000, false));
        animals.add(new Animal("Bob", Animal.Type.FISH, Animal.Sex.F, 95, 1500, 3000, true));
        animals.add(new Animal("Bobbibski", Animal.Type.CAT, Animal.Sex.M, 50, 1500, 30, true));
        animals.add(new Animal("Bobbibbi", Animal.Type.BIRD, Animal.Sex.M, 1000, 1500, 100000, false));

        // Act
        boolean result = AnimalsData.isSpidersBitesMoreThenDogs(animals);

        //Assert
        assertThat(result).isFalse();
    }
}
