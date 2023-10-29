package edu.hw4;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw4.Animal.Sex;
import static edu.hw4.Animal.Type;

public class Task1Test {
    @Test
    @DisplayName("Сортировка животных по росту")
    void test1() {
        List<Animal> list = new ArrayList<>();
        list.add(new Animal("Мистер кот", Type.CAT, Sex.M, 5, 24, 3, true));
        list.add(new Animal("Мистер паук", Type.SPIDER, Sex.M, 1, 1, 0, true));
        list.add(new Animal("Джон", Type.DOG, Sex.M, 5, 40, 15, true));
        list.add(new Animal("Королева рыб", Type.FISH, Sex.F, 3, 10, 5, false));
        list.add(new Animal("Птица феникс", Type.BIRD, Sex.F, 10000, 1500, 700, false));

        List<Animal> expected = new ArrayList<>();
        list.add(new Animal("Мистер паук", Type.SPIDER, Sex.M, 1, 1, 0, true));
        list.add(new Animal("Королева рыб", Type.FISH, Sex.F, 3, 10, 5, false));
        list.add(new Animal("Мистер кот", Type.CAT, Sex.M, 5, 24, 3, true));
        list.add(new Animal("Джон", Type.DOG, Sex.M, 5, 40, 15, true));
        list.add(new Animal("Птица феникс", Type.BIRD, Sex.F, 10000, 1500, 700, false));

        //Assertions.assertArrayEquals(expected, AnimalsData.getSortedAnimalsByHeight(list));
    }

    @Test
    @DisplayName("Пустой массив")
    void test2() {

    }
}
