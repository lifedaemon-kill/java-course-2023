package edu.hw1;

final class Task2CountDigits {
    private Task2CountDigits() {
    }

    private static final int BASE_NUMBER = 10;

    public static int getCountDigits(int value) {
        if (value == 0) {
            return 1;
        }

        var result = 0;
        var countingValue = value;

        while (countingValue != 0) {
            countingValue /= BASE_NUMBER;
            result++;
        }
        return result;
    }
}
