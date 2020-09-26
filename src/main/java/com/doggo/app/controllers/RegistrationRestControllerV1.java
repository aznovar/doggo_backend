package com.doggo.app.controllers;

import com.doggo.app.helpers.RegistrationHelper;
import com.doggo.app.model.dto.AuthenticationRequestDto;
import com.doggo.app.model.entities.User;
import com.doggo.app.model.exception.BadPasswordException;
import com.doggo.app.model.exception.BadUsernameException;
import com.doggo.app.model.exception.UserAlreadyExistException;
import com.doggo.app.model.service.UserService;
import com.doggo.app.security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер позволяющий пользователю зарегистрироваться
 */
@RestController
public class RegistrationRestControllerV1 {

    private final JwtTokenProvider jwtTokenProvider;
    private UserService userService;
    private RegistrationHelper registrationHelper;

    @Autowired
    public RegistrationRestControllerV1(UserService service, JwtTokenProvider jwtTokenProvider, RegistrationHelper registrationHelper) {
        this.userService = service;
        this.jwtTokenProvider = jwtTokenProvider;
        this.registrationHelper = registrationHelper;
    }


    @RequestMapping(value = "/api/v1/registration", method = RequestMethod.POST)
    public String userRegistration(@RequestBody AuthenticationRequestDto requestDto) {
        User user = userService.findByUsername(requestDto.getUsername());
        if (user != null) {
            throw new UserAlreadyExistException("Пользователь с именем:" + user.getUsername() +
                    " уже зарегистрирован");
        }

        //TODO carryweight переделай валидаторы, т.к. сейчас они факапят регистрацию
//         if (!registrationHelper.validateUsername(requestDto.getUsername()))
//             throw new BadUsernameException("Имя пользователя должно содержать от 3 до 20 символов латиницей");


//         if (!registrationHelper.validatePassword(requestDto.getPassword()))
//             throw new BadPasswordException("Пароль должен быть не менее 8 символов и содержать в себе, как минимум, 1 цифру, 1 спецсимвол, буквы малой и большой высоты");

        user = requestDto.toUser();
        userService.register(user);
        return "welcome";
    }
}
