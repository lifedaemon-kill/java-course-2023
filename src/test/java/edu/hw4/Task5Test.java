package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Самок больше самцов F > M")
    void test1() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 5, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 3, 10, 5, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 700, false));

        Animal.Sex expected = Animal.Sex.F;

        // Act
        Animal.Sex result = AnimalsData.getMostCommonSex(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Самцов больше самок M > F")
    void test2() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.M, 5, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.M, 3, 10, 5, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 700, false));

        Animal.Sex expected = Animal.Sex.M;

        // Act
        Animal.Sex result = AnimalsData.getMostCommonSex(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Самцов столько же сколько самок, MMFF")
    void test3() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 5, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.M, 5, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 3, 10, 5, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 700, false));

        Animal.Sex expected = null;

        // Act
        Animal.Sex result = AnimalsData.getMostCommonSex(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("В множестве только самки")
    void test4() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.F, 5, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 5, 40, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 3, 10, 5, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 10000, 1500, 700, false));

        Animal.Sex expected = Animal.Sex.F;

        // Act
        Animal.Sex result = AnimalsData.getMostCommonSex(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Пустое множество")
    void test5() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        Animal.Sex expected = null;

        // Act
        Animal.Sex result = AnimalsData.getMostCommonSex(animals);

        //Assert
        assertThat(result).isEqualTo(expected);
    }
}
