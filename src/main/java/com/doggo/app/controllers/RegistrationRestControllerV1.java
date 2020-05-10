package com.doggo.app.controllers;


import com.doggo.app.model.dto.AuthenticationRequestDto;
import com.doggo.app.model.dto.UserDto;
import com.doggo.app.model.entities.User;
import com.doggo.app.model.exception.UserAlreadyExistException;
import com.doggo.app.model.service.UserService;
import com.doggo.app.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Контроллер позволяющий пользователю зарегистрироваться
 */
@RestController
public class RegistrationRestControllerV1 {

    private UserService userService;

    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    public RegistrationRestControllerV1(UserService service, JwtTokenProvider jwtTokenProvider) {
        this.userService = service;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    //TODO Временное решение. Надо будет привести к нормальному виду
    @RequestMapping(value = "/api/v1/registration", method = RequestMethod.POST)
    public String userRegistration(@RequestBody AuthenticationRequestDto requestDto) {
        User user = userService.findByUsername(requestDto.getUsername());
        if (user != null) {
            throw new UserAlreadyExistException("Пользователь с именем:" + user.getUsername() +
                    " уже зарегистрирован");
        }
        user = requestDto.toUser();
        userService.register(user);
        return "welcome";
    }
}
