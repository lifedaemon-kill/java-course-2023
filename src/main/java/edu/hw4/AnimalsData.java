package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AnimalsData {
    private AnimalsData (){}

    //Задача 1 отсортировать животных по росту от самого маленького к самому большому -> List<Animal>
    public static List<Animal> getSortedAnimalsByHeight(List<Animal> animals){
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

}
