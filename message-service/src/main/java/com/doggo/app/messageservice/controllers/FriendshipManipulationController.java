package com.doggo.app.messageservice.controllers;

import com.doggo.app.messageservice.model.dto.FriendshipDto;
import com.doggo.app.model.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/friendship/")
public class FriendshipManipulationController {

    @GetMapping(value = "addrequest/{username}/{id}/")
    public void friendshipRequest(@PathVariable(name = "username") String username,
                                  @PathVariable(name = "id") Long id) {

    }


}
