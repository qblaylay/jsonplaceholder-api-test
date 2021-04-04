package com.jsonplaceholder.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Email validation permitted by RFC 5322
public class EmailUtil {

    private static final String REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";


    private static Pattern pattern = Pattern.compile(REGEX);


    public static Boolean isValidEmail(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
