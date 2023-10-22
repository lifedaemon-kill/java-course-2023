package edu.hw3;

import java.util.HashMap;

final class Task4RomanNumerals {
    private Task4RomanNumerals() {
    }

    private static final int LOWEST_BASE_MINUS_SUB_BASE = 4;

    //if last base star with "1" it should be 4, if with 5 then require different formula
    private static final int HIGHEST_VALUE_FOR_FINDING_MAX_POSSIBLE = 4;

    public static final int[] BASE_NUMBER = {
        1,
        5,
        10,
        50,
        100,
        500,
        1000,
        5000,
        10000,
        50000,
        100000
    };
    @SuppressWarnings("MagicNumber")
    public static final HashMap<Integer, String> MAP_BASE_NUMBER_TO_SYMBOL = new HashMap<>() {{
        put(BASE_NUMBER[0], "Ⅰ");
        put(BASE_NUMBER[1], "Ⅴ");
        put(BASE_NUMBER[2], "Ⅹ");
        put(BASE_NUMBER[3], "Ⅼ");
        put(BASE_NUMBER[4], "Ⅽ");
        put(BASE_NUMBER[5], "Ⅾ");
        put(BASE_NUMBER[6], "ↀ");
        put(BASE_NUMBER[7], "ↁ");
        put(BASE_NUMBER[8], "ↂ");
        put(BASE_NUMBER[9], "ↇ");
        put(BASE_NUMBER[10], "ↈ");
    }};

    public static String convertToRoman(int originValue) throws Exception {
        int value = init(originValue);

        StringBuilder result = new StringBuilder();

        for (int i = BASE_NUMBER.length - 1; i >= 0; i--) {
            if (value == 0) {
                break;
            }

            int base = BASE_NUMBER[i];
            int subBase = 0;

            if (value >= LOWEST_BASE_MINUS_SUB_BASE) {
                subBase = (i % 2 == 0) ? BASE_NUMBER[i - 2] : BASE_NUMBER[i - 1];
            }

            if (value < base && value < base - subBase) {
                continue;
            }

            // base 1 5 10 50 100 500 1000 etc
            while (value >= base) {
                value -= base;
                result.append(MAP_BASE_NUMBER_TO_SYMBOL.get(base));
            }
            //base 4 9 40 90 etc
            if (value >= base - subBase) {
                value -= (base - subBase);
                result.append(MAP_BASE_NUMBER_TO_SYMBOL.get(subBase));
                result.append(MAP_BASE_NUMBER_TO_SYMBOL.get(base));
            }
        }
        return result.toString();
    }

    private static int init(int originValue) throws Exception {
        if (originValue <= 0) {
            throw new Exception("Value < 1");
        }
        if (BASE_NUMBER.length != MAP_BASE_NUMBER_TO_SYMBOL.size()) {
            throw new Exception("BASE_NUMBER length != MAP length");
        }
        if (!String.valueOf(originValue).equals("1")) {
            throw new Exception("LAST VALUE IN BASE_NUMBER AND MAP MUST START WITH 1");
        }
        if (originValue > BASE_NUMBER[BASE_NUMBER.length - 1] * HIGHEST_VALUE_FOR_FINDING_MAX_POSSIBLE - 1) {
            throw new Exception("Value is too high for converting");
        }
        return originValue;
    }
}
