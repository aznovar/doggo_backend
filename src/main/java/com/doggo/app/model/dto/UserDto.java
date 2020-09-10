package com.doggo.app.model.dto;

import com.doggo.app.model.entities.Status;
import com.doggo.app.model.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

/**
 * DTO class for user requests by ROLE_USER
 *
 * @version 1.0
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private Long id;
    private String username;
    private String token;
    private Date registrationDate;
    private Status status;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }

    public static UserDto fromUser(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setStatus(user.getStatus());
        userDto.setRegistrationDate(user.getCreated());
        return userDto;
    }
}
