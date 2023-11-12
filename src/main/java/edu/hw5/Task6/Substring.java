package edu.hw5.Task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Substring {
    private Substring() {
    }

    public static boolean isSubstring(String sub, String main) {
        Pattern pattern = Pattern.compile(sub);
        Matcher matcher = pattern.matcher(main);

        return matcher.find();
    }
}
