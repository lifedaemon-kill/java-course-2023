package edu.hw5.Task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LicensePlates {
    private LicensePlates() {
    }

    public static boolean isValidDefaultCar(String number) {

        Pattern pattern = Pattern.compile("^[АВЕКМНОРСТУХ]\\d{2}[1-9][АВЕКМНОРСТУХ]{2}\\d{2,3}$");
        Matcher matcher = pattern.matcher(number);

        return matcher.find();
    }
}
