package com.doggo.app.model.dto;

import com.doggo.app.model.entities.User;
import lombok.Data;

/**
 * DTO class for authentication (login) request.
 *
 * @version 1.0
 */

@Data
public class AuthenticationRequestDto {
    private String username;
    private String password;


    public User toUser(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
