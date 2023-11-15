package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task18Test {
    @Test
    @DisplayName("3 Массива")
    void test1() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();
        List<Animal> animals2 = new ArrayList<>();
        List<Animal> animals3 = new ArrayList<>();

        animals1.add(new Animal("Cat Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 4, 24, 30000000, true));
        animals1.add(new Animal("Bobby Fisher", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));

        animals2.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 8, 10, 15, true));
        animals2.add(new Animal("Bobby", Animal.Type.DOG, Animal.Sex.F, 100, 1500, 3000, false));
        animals2.add(new Animal("Bobby B", Animal.Type.DOG, Animal.Sex.F, 100, 1500, 3000, false));

        animals3.add(new Animal("Bob", Animal.Type.FISH, Animal.Sex.F, 95, 1500, 15, true));
        animals3.add(new Animal("Bobbibski", Animal.Type.SPIDER, Animal.Sex.M, 50, 1500, 30, true));
        animals3.add(new Animal("Bobbibbi", Animal.Type.FISH, Animal.Sex.M, 1000, 20, 100000, false));

        // Act
        Animal result = AnimalsData.findHeaviestFish(animals1, animals2, animals3);

        //Assert
        assertThat(result).isEqualTo(animals3.get(2));
    }

    @Test
    @DisplayName("6 Массивов")
    void test2() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();
        List<Animal> animals2 = new ArrayList<>();
        List<Animal> animals3 = new ArrayList<>();
        List<Animal> animals4 = new ArrayList<>();
        List<Animal> animals5 = new ArrayList<>();
        List<Animal> animals6 = new ArrayList<>();

        animals1.add(new Animal("Cat Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 4, 24, 3, true));
        animals1.add(new Animal("Bobby Fisher", Animal.Type.FISH, Animal.Sex.M, 3, 120, 15, true));

        animals2.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 8, 10, 15, true));
        animals2.add(new Animal("Bobby", Animal.Type.DOG, Animal.Sex.F, 100, 1500, 3, false));
        animals2.add(new Animal("Bobby B", Animal.Type.DOG, Animal.Sex.F, 100, 1500, 30, false));

        animals3.add(new Animal("Bob", Animal.Type.FISH, Animal.Sex.F, 95, 1500, 15, true));
        animals3.add(new Animal("Bobbibski", Animal.Type.SPIDER, Animal.Sex.M, 50, 1500, 30, true));
        animals3.add(new Animal("Bobbibbi", Animal.Type.FISH, Animal.Sex.M, 1000, 20, 10, false));

        animals4.add(new Animal("Bob", Animal.Type.FISH, Animal.Sex.F, 95, 1500, 15, true));
        animals4.add(new Animal("Bobbibski", Animal.Type.SPIDER, Animal.Sex.M, 50, 1500, 30000000, true));
        animals4.add(new Animal("Bobbibbi", Animal.Type.FISH, Animal.Sex.M, 1000, 20, 0, false));

        animals5.add(new Animal("Bob", Animal.Type.FISH, Animal.Sex.F, 95, 1500, 15, true));
        animals5.add(new Animal("Bobbibski", Animal.Type.SPIDER, Animal.Sex.M, 50, 1500, 30, true));
        animals5.add(new Animal("Bobbibbi", Animal.Type.FISH, Animal.Sex.M, 1000, 20, 100, false));

        animals6.add(new Animal("Bob", Animal.Type.FISH, Animal.Sex.F, 95, 1500, 15, true));
        animals6.add(new Animal("Bobbibski", Animal.Type.SPIDER, Animal.Sex.M, 50, 1500, 30, true));
        animals6.add(new Animal("Bobbibbi", Animal.Type.FISH, Animal.Sex.M, 1000, 20, 10, false));

        // Act
        Animal result = AnimalsData.findHeaviestFish(animals1, animals2, animals3, animals4, animals5, animals6);

        //Assert
        assertThat(result).isEqualTo(animals5.get(2));
    }

    @Test
    @DisplayName("Нет рыб")
    void test4() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();
        List<Animal> animals2 = new ArrayList<>();
        List<Animal> animals3 = new ArrayList<>();
        List<Animal> animals4 = new ArrayList<>();
        List<Animal> animals5 = new ArrayList<>();
        List<Animal> animals6 = new ArrayList<>();

        animals1.add(new Animal("Cat Bobby Fisher", Animal.Type.DOG, Animal.Sex.F, 4, 24, 3000000, true));
        animals1.add(new Animal("Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 3, 120, 15, true));

        animals2.add(new Animal("Bobby Fisher Smiled", Animal.Type.DOG, Animal.Sex.F, 8, 10, 15, true));
        animals2.add(new Animal("Bobby", Animal.Type.DOG, Animal.Sex.F, 100, 1500, 3, false));
        animals2.add(new Animal("Bobby B", Animal.Type.DOG, Animal.Sex.F, 100, 1500, 30, false));

        animals3.add(new Animal("Bob", Animal.Type.SPIDER, Animal.Sex.F, 95, 1500, 15, true));
        animals3.add(new Animal("Bobbibski", Animal.Type.SPIDER, Animal.Sex.M, 50, 1500, 30, true));
        animals3.add(new Animal("Bobbibbi", Animal.Type.BIRD, Animal.Sex.M, 1000, 20, 10, false));

        animals4.add(new Animal("Bob", Animal.Type.DOG, Animal.Sex.F, 95, 1500, 15, true));
        animals4.add(new Animal("Bobbibski", Animal.Type.SPIDER, Animal.Sex.M, 50, 1500, 30, true));
        animals4.add(new Animal("Bobbibbi", Animal.Type.BIRD, Animal.Sex.M, 1000, 20, 0, false));

        animals5.add(new Animal("Bob", Animal.Type.CAT, Animal.Sex.F, 95, 1500, 15, true));
        animals5.add(new Animal("Bobbibski", Animal.Type.BIRD, Animal.Sex.M, 50, 1500, 30, true));
        animals5.add(new Animal("Bobbibbi", Animal.Type.SPIDER, Animal.Sex.M, 1000, 20, 100, false));

        animals6.add(new Animal("Bob", Animal.Type.DOG, Animal.Sex.F, 95, 1500, 15, true));
        animals6.add(new Animal("Bobbibski", Animal.Type.SPIDER, Animal.Sex.M, 50, 1500, 30, true));
        animals6.add(new Animal("Bobbibbi", Animal.Type.BIRD, Animal.Sex.M, 1000, 20, 10, false));

        // Act
        Animal result = AnimalsData.findHeaviestFish(animals1, animals2, animals3, animals4, animals5, animals6);

        //Assert
        assertThat(result).isNull();
    }

    @Test
    @DisplayName("Пустой массив")
    void test3() {
        // Arrange
        List<Animal> animals1 = new ArrayList<>();
        List<Animal> animals2 = new ArrayList<>();
        List<Animal> animals3 = new ArrayList<>();

        // Act
        Animal result = AnimalsData.findHeaviestFish(animals1, animals2, animals3);

        //Assert
        assertThat(result).isNull();
    }
}
