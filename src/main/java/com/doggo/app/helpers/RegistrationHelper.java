package com.doggo.app.helpers;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class RegistrationHelper {

    private Pattern pattern;
    private Matcher matcher;

    public boolean validateUsername(String userName) {
        String usernamePattern = "^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
        pattern = Pattern.compile(usernamePattern);
        matcher = pattern.matcher(userName);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        pattern = Pattern.compile(passwordPattern);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }


}