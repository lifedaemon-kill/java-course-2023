package edu.hw5.Task4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidPassword {
    public static boolean isPasswordHaveSpecSymbol(String password) {
        //~ ! @ # $ % ^ & * | хотя бы один из этих символов должен быть
        Pattern pattern = Pattern.compile("[~!@#$%^&*|]");
        Matcher matcher = pattern.matcher(password);

        return matcher.find();
    }
}
