package edu.hw4;

import static edu.hw4.Utility.NUMBER_OF_PAWS_ARTHROPODS;
import static edu.hw4.Utility.NUMBER_OF_PAWS_BIRDS;
import static edu.hw4.Utility.NUMBER_OF_PAWS_OF_MAMMALS;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> NUMBER_OF_PAWS_OF_MAMMALS;
            case BIRD -> NUMBER_OF_PAWS_BIRDS;
            case FISH -> 0;
            case SPIDER -> NUMBER_OF_PAWS_ARTHROPODS;
        };
    }
}
