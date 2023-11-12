package edu.hw5.Task7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Magic {
    private Magic() {
    }

    public static boolean isGreaterThen3DigitsAnd3ndIs0(String number) {
        Pattern pattern = Pattern.compile("^[0,1]{2}0[0,1]*$");
        Matcher matcher = pattern.matcher(number);

        return matcher.find();
    }

    public static boolean isBeginAndEndIsTheSameSymbol(String number) {
        Pattern pattern = Pattern.compile("^0[0,1]*0$");
        Matcher matcher = pattern.matcher(number);
        if (matcher.find()) {
            return true;
        } else {
            pattern = Pattern.compile("^1[0,1]*1$");
            matcher = pattern.matcher(number);

            return matcher.find();
        }
    }

    public static boolean isLengthBetween1And3(String number) {
        Pattern pattern = Pattern.compile("^[0,1]{1,3}$");
        Matcher matcher = pattern.matcher(number);

        return matcher.find();
    }
}
