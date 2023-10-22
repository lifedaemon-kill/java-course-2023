package edu.hw1;

import java.util.Arrays;

final class Task6Kaprekar {

    private Task6Kaprekar() {
    }

    private static final int BASE_NUMBER = 10;
    private static final int KAPREKAR_VALUE = 6174;
    private static final int LOW_EDGE = 1000;
    private static final int HIGH_EDGE = 9999;
    private static final int FOUR_ONES = 1111;

    public static int getKaprekarSteps(int originalValue) {
        /* recursive function returns the count of itself calls
           returns -1 if value == 1000 or isn't four-digit number or all digits are the same
        */
        int value = originalValue;
        if (value == KAPREKAR_VALUE) {
            return 0;
        }
        if (value < LOW_EDGE || HIGH_EDGE < value || value % FOUR_ONES == 0) {
            return -1;
        }

        int lengthValue = Task2CountDigits.getCountDigits(value);
        //split value to array
        int[] smallerArr = new int[lengthValue];
        for (int i = lengthValue - 1; -1 < i; i--) {
            smallerArr[i] = value % BASE_NUMBER;
            value /= BASE_NUMBER;
        }
        Arrays.sort(smallerArr);

        //reverse of smaller value
        int[] biggerArr = new int[lengthValue];
        for (int i = 0; i < lengthValue; i++) {
            biggerArr[i] = smallerArr[lengthValue - 1 - i];
        }
        //getting values back
        int biggerNumber = 0;
        int smallerNumber = 0;
        for (int i = lengthValue - 1; -1 < i; i--) {
            biggerNumber += smallerArr[i] * (int) Math.pow(BASE_NUMBER, i);
            smallerNumber += biggerArr[i] * (int) Math.pow(BASE_NUMBER, i);
        }

        return getKaprekarSteps(biggerNumber - smallerNumber) + 1;
    }
}
