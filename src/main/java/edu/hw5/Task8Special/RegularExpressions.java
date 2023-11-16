package edu.hw5.Task8Special;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressions {
    private RegularExpressions() {
    }
    //для строк из алфавита {0, 1}:

    //нечетной длины
    public static boolean isOddLength(String number) {
        Pattern pattern = Pattern.compile("^[01]([01][01])*$");
        Matcher matcher = pattern.matcher(number);

        return matcher.find();
    }

    //начинается с 0 и имеет нечетную длину(НЕ делится на два)
    //начинается с 1 и имеет четную длину(делится на два)
    public static boolean isFirstDigitMatchesParity(String number) {
        Pattern pattern = Pattern.compile("^(0([01][01])*)$|^(1[01]([01][01])*)$");
        Matcher matcher = pattern.matcher(number);

        return matcher.find();
    }

    //любая строка, кроме 11 или 111
    public static boolean isExcept11And111(String number) {
        Pattern pattern = Pattern.compile("^(?!11$|111$)[01]*");
        Matcher matcher = pattern.matcher(number);

        return matcher.find();
    }

    //каждый нечетный(НЕ делится на два) символ равен 1
    public static boolean isEveryOddEqual1(String number) {
        Pattern pattern = Pattern.compile("^([01])$|^(([01]1)+)$");
        Matcher matcher = pattern.matcher(number);

        return matcher.find();
    }

    //нет последовательных 1
    public static boolean isNotConsecutiveOnes(String number) {
        Pattern pattern = Pattern.compile("^(0)$|^(1)$|^((0*1)*)$|^((10*)*)$");
        Matcher matcher = pattern.matcher(number);

        return matcher.find();
    }

    //количество 0 кратно 3
    public static boolean isCountOfZerosIsMultipleOfThree(String number) {
        Pattern pattern = Pattern.compile("^(1*01*01*01*)+$");
        Matcher matcher = pattern.matcher(number);

        return matcher.find();
    }

    //содержит не менее двух 0 и не более одной 1
    public static boolean isContainsAtLeastTwoZerosAndAtMostOneOnes(String number) {
        Pattern pattern = Pattern.compile("^(0+1?0+)$|^(1?0+0+)$|^(0+0+1?)$");
        Matcher matcher = pattern.matcher(number);

        return matcher.find();
    }
}
