package com.doggo.app.helpers;

import com.doggo.app.model.dto.AuthenticationRequestDto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationHelper {

    private Pattern pattern;
    private Matcher matcher;

    public boolean validateUsername(AuthenticationRequestDto requestDto) {
        String usernamePattern = "^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
        String username = requestDto.getUsername();
        pattern = Pattern.compile(usernamePattern);
        matcher = pattern.matcher(username);
        return matcher.matches();


    }

    public boolean validatePassword(AuthenticationRequestDto requestDto) {
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*])(?=.{8,})";
        String password = requestDto.getPassword();
        pattern = Pattern.compile(passwordPattern);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }


}

