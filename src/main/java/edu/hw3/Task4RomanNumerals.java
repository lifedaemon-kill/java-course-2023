package edu.hw3;

import java.util.HashMap;

final class Task4RomanNumerals {
    private Task4RomanNumerals() {
    }

    //if last base star with "1" it should be 4, if with 5 then require different formula
    private static final int HIGHEST_VALUE_FOR_FINDING_MAX_POSSIBLE = 4;

    public static final int[] BASE_NUMBER = {
        1, 4, 5, 9,
        10, 40, 50, 90,
        100, 400, 500, 900,
        1000, 4000, 5000, 9000,
        10000, 40000, 50000, 90000,
        100000
    };
    @SuppressWarnings("MagicNumber")
    public static final HashMap<Integer, String> MAP_BASE_NUMBER_TO_SYMBOL = new HashMap<>() {{
        put(BASE_NUMBER[0], "I");
        put(BASE_NUMBER[1], "IV");
        put(BASE_NUMBER[2], "V");
        put(BASE_NUMBER[3], "IX");
        put(BASE_NUMBER[4], "X");
        put(BASE_NUMBER[5], "XL");
        put(BASE_NUMBER[6], "L");
        put(BASE_NUMBER[7], "XC");
        put(BASE_NUMBER[8], "C");
        put(BASE_NUMBER[9], "CD");
        put(BASE_NUMBER[10], "D");
        put(BASE_NUMBER[11], "Cↀ");
        put(BASE_NUMBER[12], "ↀ");
        put(BASE_NUMBER[13], "ↀↁ");
        put(BASE_NUMBER[14], "ↁ");
        put(BASE_NUMBER[15], "ↀↂ");
        put(BASE_NUMBER[16], "ↂ");
        put(BASE_NUMBER[17], "ↂↇ");
        put(BASE_NUMBER[18], "ↇ");
        put(BASE_NUMBER[19], "ↂↈ");
        put(BASE_NUMBER[20], "ↈ");
    }};

    public static String convertToRoman(int originValue) throws Exception {
        int value = init(originValue);

        StringBuilder result = new StringBuilder();

        int i = BASE_NUMBER.length - 1;
        while (value > 0) {
            while (value >= BASE_NUMBER[i]) {
                value -= BASE_NUMBER[i];
                result.append(MAP_BASE_NUMBER_TO_SYMBOL.get(BASE_NUMBER[i]));
            }
            i--;
        }

        return result.toString();
    }

    private static int init(int originValue) throws Exception {
        if (originValue <= 0) {
            throw new Exception("Value < 1");
        }
        if (BASE_NUMBER.length != MAP_BASE_NUMBER_TO_SYMBOL.size()) {
            throw new Exception(
                "BASE_NUMBER length != MAP length :" + BASE_NUMBER.length + " != " + MAP_BASE_NUMBER_TO_SYMBOL.size());
        }
        if (originValue > BASE_NUMBER[BASE_NUMBER.length - 1] * HIGHEST_VALUE_FOR_FINDING_MAX_POSSIBLE - 1) {
            throw new Exception("Value is too high for converting");
        }
        return originValue;
    }
}
