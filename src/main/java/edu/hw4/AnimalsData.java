package edu.hw4;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import static edu.hw4.Animal.Sex.M;

public class AnimalsData {
    private AnimalsData() {
    }

    //Задача 1 отсортировать животных по росту от самого маленького к самому большому -> List<Animal>
    public static List<Animal> getSortedAnimalsByHeight(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    //Задача 2 Отсортировать животных по весу от самого тяжелого к самому легкому, выбрать k первых -> List<Animal>
    public static List<Animal> getSortedAnimalsByWeightDesc(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .collect(Collectors.toList());
    }

    //Задача 3 Сколько животных каждого вида -> Map<Animal.Type, Integer>
    public static Map<Animal.Type, Integer> getAnimalTypeMap(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(animal -> 1)));
    }

    //Задача 4 У какого животного самое длинное имя -> Animal
    public static Animal getAnimalWithLongestName(List<Animal> animals) {
        // в случае если длина у нескольких элементов одинаковая, возвращает самое первое из таких
        return animals.stream()
            .max(Comparator.comparingInt(o -> o.name().length()))
            .orElse(null);
    }

    // Задача 5 Каких животных больше: самцов или самок -> Sex
    public static Animal.Sex getMostCommonSex(List<Animal> animals) {
        //Возвращает null, если количество совпало
        Map<Animal.Sex, Long> sexMap = animals.stream()
            .collect(Collectors.groupingBy(Animal::sex, Collectors.counting()));
        if (sexMap.isEmpty() || Objects.equals(sexMap.get(M), sexMap.get(Animal.Sex.F))) {
            return null;
        } else {
            return sexMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        }
    }

    // Задание 6 Самое тяжелое животное каждого вида -> Map<Animal.Type, Animal>
    public static Map<Animal.Type, Animal> getMapOfHeaviest(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingDouble(Animal::weight))
            ));
    }

    // Задание 7 K-е самое старое животное -> Animal
    public static Animal getOldestAnimalWithPosition(List<Animal> animals, int k) {
        //если несколько с одинаковым возрастом, то сортировка по их изначальной очередности в массиве
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age))
            .skip(k)
            .findFirst()
            .orElse(null);
    }

    // Задание 8 Самое тяжелое животное среди животных ниже k см -> Optional<Animal>
    public static Optional<Animal> getHeaviestBelowKCm(List<Animal> animals, int height) {
        //если фильтр выдаст пустой массив, то вернет optional в целом животное с максимальным весов
        return animals.stream()
            .filter(a -> a.height() < height)
            .max(Comparator.comparingInt(Animal::weight));
    }

    // Задание 9 Сколько в сумме лап у животных в списке -> Integer
    public static Integer getNumberOfPaws(List<Animal> animals) {
        return animals.stream()
            .map(Animal::paws)
            .mapToInt(a -> a)
            .sum();
    }

    //Задание 10 Список животных, возраст у которых не совпадает с количеством лап -> List<Animal>
    public static List<Animal> getAnimalsWhereAgeNotEqualsToNumberOfPaws(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.paws() != a.age())
            .collect(Collectors.toList());
    }

    //Задание 11 Список животных, которые могут укусить (bites == true) и рост которых превышает 100 см -> List<Animal>
    public static List<Animal> getAnimalsCanBitesAndHigherThen100(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.bites() && a.height() > 100)
            .collect(Collectors.toList());
    }

    //Задание 12 Сколько в списке животных, вес которых превышает рост -> Integer
    public static Integer getCountWeightGreaterHeight(List<Animal> animals) {
        return Math.toIntExact(animals.stream()
            .filter(a -> a.weight() > a.height())
            .count());
    }

    //Задание 13 Список животных, имена которых состоят из более чем двух слов -> List<Animal>
    public static List<Animal> getAnimalsWhereNameMoreThenTwoWords(List<Animal> animals) {
        return animals.stream()
            .filter(a -> a.name().split(" ").length > 2)
            .collect(Collectors.toList());
    }

    //Задание 14 Есть ли в списке собака ростом более k см -> Boolean
    public static boolean isAnyDogHigherK(List<Animal> animals, int height) {
        return animals.stream()
            .anyMatch(a -> a.type() == Animal.Type.DOG && a.height() > height);
    }

    //Задание 15 Найти суммарный вес животных каждого вида, которым от k до l лет -> Map<Animal.Type, Integer>
    public static Map<Animal.Type, Integer> getMapTypesAndWeightWithCertainAge(
        List<Animal> animals,
        Integer startAge,
        Integer endAge
    ) {
        return animals.stream()
            .filter(a -> startAge < a.age() && a.age() < endAge)
            .collect(Collectors
                .groupingBy(
                    Animal::type,
                    Collectors.summingInt(Animal::weight)
                ));
    }

    //Задание 16 Список животных, отсортированный по виду, затем по полу, затем по имени -> List<Animal>
    public static List<Animal> getSortedTypeSexNameABS(List<Animal> animals) {
        return animals.stream()
            .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .collect(Collectors.toList());
    }

    //Задание 17 Правда ли, что пауки кусаются чаще, чем собаки
    //-> Boolean (если данных для ответа недостаточно, вернуть false)
    public static boolean isSpidersBitesMoreThenDogs(List<Animal> animals) {
        var spidersCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER)
            .count();
        var dogsCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .count();
        if (spidersCount * dogsCount == 0) {
            return false;
        } else {
            return animals.stream()
                       .filter(animal -> animal.type() == Animal.Type.SPIDER)
                       .mapToInt(animal -> animal.bites() ? 1 : 0)
                       .average()
                       .orElse(0)
                   >
                   animals.stream()
                       .filter(animal -> animal.type() == Animal.Type.DOG)
                       .mapToInt(animal -> animal.bites() ? 1 : 0)
                       .average()
                       .orElse(0);
        }
    }

    //Задание 18 Найти самую тяжелую рыбку в 2-х или более списках -> Animal
    @SafeVarargs
    public static Animal findHeaviestFish(List<Animal>... animalsList) {
        for (int i = 1; i < animalsList.length; i++) {
            animalsList[0].addAll(animalsList[i]);
        }
        return animalsList[0].stream()
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    //Задание 19 Животные, в записях о которых есть ошибки:
    // вернуть имя и список ошибок -> Map<String, Set<ValidationError>>
    public static Map<String, Set<ValidationError>> getMapValidationErrors(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name() == null || animal.name().isEmpty()
                              || animal.age() <= 0 || animal.height() <= 0 || animal.weight() <= 0
                              || animal.type() == null || animal.sex() == null)
            .collect(Collectors.toMap(
                Animal::name,
                animal -> {
                    Set<ValidationError> errors = new HashSet<>();

                    if (animal.name() == null || animal.name().isEmpty()) {
                        errors.add(ValidationError.NAME_EMPTY);
                    }
                    if (animal.type() == null) {
                        errors.add(ValidationError.INVALID_TYPE);
                    }
                    if (animal.sex() == null) {
                        errors.add(ValidationError.INVALID_SEX);
                    }
                    if (animal.age() <= 0) {
                        errors.add(ValidationError.INVALID_AGE);
                    }
                    if (animal.height() <= 0) {
                        errors.add(ValidationError.INVALID_HEIGHT);
                    }
                    if (animal.weight() <= 0) {
                        errors.add(ValidationError.INVALID_WEIGHT);
                    }

                    return errors;
                }
            ));
    }

    // Задание 20 Сделать результат предыдущего задания более читабельным:
    // вернуть имя и названия полей с ошибками, объединенные в строку -> Map<String, String>
    public static Map<String, String> getMapValidationErrorsString(List<Animal> animals){
        return animals.stream()
            .filter(animal -> animal.name() == null || animal.name().isEmpty()
                              || animal.age() <= 0 || animal.height() <= 0 || animal.weight() <= 0
                              || animal.type() == null || animal.sex() == null)
            .collect(Collectors.toMap(
                Animal::name,
                animal -> {
                    StringBuilder errors = new StringBuilder();

                    if (animal.name() == null || animal.name().isEmpty()) {
                        errors.append(ValidationError.NAME_EMPTY);
                        errors.append("__");
                    }
                    if (animal.type() == null) {
                        errors.append(ValidationError.INVALID_TYPE);
                        errors.append("__");
                    }
                    if (animal.sex() == null) {
                        errors.append(ValidationError.INVALID_SEX);
                        errors.append("__");
                    }
                    if (animal.age() <= 0) {
                        errors.append(ValidationError.INVALID_AGE);
                        errors.append("__");
                    }
                    if (animal.height() <= 0) {
                        errors.append(ValidationError.INVALID_HEIGHT);
                        errors.append("__");
                    }
                    if (animal.weight() <= 0) {
                        errors.append(ValidationError.INVALID_WEIGHT);
                        errors.append("__");
                    }

                    errors.deleteCharAt(errors.length() - 1);
                    errors.deleteCharAt(errors.length() - 1);

                    return errors.toString();
                }
            ));
    }
}
