package edu.hw4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class Task15Test {
    @Test
    @DisplayName("Корректные значения")
    void test1() {
        // Arrange
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Cat Bobby Fisher", Animal.Type.CAT, Animal.Sex.M, 4, 24, 3, true));
        animals.add(new Animal("Bobby Fisher", Animal.Type.CAT, Animal.Sex.F, 3, 120, 15, true));
        animals.add(new Animal("Bobby Fisher Smiled", Animal.Type.CAT, Animal.Sex.F, 8, 10, 15, false));
        animals.add(new Animal("Bobby", Animal.Type.BIRD, Animal.Sex.F, 100, 1500, 3000, false));
        animals.add(new Animal("Bob", Animal.Type.BIRD, Animal.Sex.F, 95, 1500, 3000, false));
        animals.add(new Animal("Bobbibski", Animal.Type.DOG, Animal.Sex.M, 50, 1500, 30, false));
        animals.add(new Animal("Bobbibbi", Animal.Type.DOG, Animal.Sex.M, 1000, 1500, 100000, false));

        Map<Animal.Type, Integer> expected = new HashMap<>();
        expected.put(Animal.Type.CAT, 18);
        expected.put(Animal.Type.BIRD, 6000);
        expected.put(Animal.Type.DOG, 30);

        // Act
        Map<Animal.Type, Integer> result = AnimalsData.getMapTypesAndWeightWithCertainAge(animals, 3, 101);

        //Assert
        assertThat(result).isEqualTo(expected);
    }
}
