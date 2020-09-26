package com.doggo.app.messageservice.controllers;

import com.doggo.app.model.entities.User;
import com.doggo.app.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/friendship/")
public class FriendshipManipulationController {

    private final UserService userService;

    @Autowired
    public FriendshipManipulationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "addrequest/{username}/{id}/")
    public void friendshipRequest(@PathVariable(name = "username") String username,
                                  @PathVariable(name = "id") Long id) {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

    }


}
