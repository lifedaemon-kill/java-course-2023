package edu.hw4;

enum Utility {
    NUMBER_OF_PAWS_BIRDS(2),
    NUMBER_OF_PAWS_OF_MAMMALS(4),
    NUMBER_OF_PAWS_ARTHROPODS(8),
    HEIGHT_THRESHOLD(100);

    private final int value;

    Utility(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
