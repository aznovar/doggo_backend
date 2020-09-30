package com.doggo.app.controllers;


import com.doggo.app.model.entities.FriendshipRelation;
import com.doggo.app.model.entities.User;
import com.doggo.app.model.repository.FriendshipRelationRepository;
import com.doggo.app.model.service.FriendshipRelationService;
import com.doggo.app.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/friendship/")
public class FriendshipManipulationController {

    private final UserService userService;
    private final FriendshipRelationService friendshipRelationService;
    private final FriendshipRelationRepository friendshipRelationRepository;

    @Autowired
    public FriendshipManipulationController(UserService userService,
                                            FriendshipRelationService friendshipRelationService,
                                            FriendshipRelationRepository friendshipRelationRepository) {
        this.userService = userService;
        this.friendshipRelationService = friendshipRelationService;
        this.friendshipRelationRepository = friendshipRelationRepository;
    }

    @GetMapping(value = "add/{username}/{id}")
    public void friendshipAddRequest(@PathVariable(name = "username") String username,
                                     @PathVariable(name = "id") Long id) {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }
        FriendshipRelation friendshipRelation = friendshipRelationService
                .findAllByRequestAndApproveId(id, user.getId());
        if (friendshipRelation != null) {
            System.out.println("временно");
        } else {
            friendshipRelation = new FriendshipRelation();
            friendshipRelation.setRequestUserId(id);
            friendshipRelation.setApproveUserId(user.getId());
            friendshipRelationRepository.save(friendshipRelation);
        }
    }

    @GetMapping(value = "getRequests/{id}")
    public void getActiveFriendshipRequests(@PathVariable(name = "id") Long id) {
        List<User> friendshipRelation = friendshipRelationService
                .getInfoAboutFriendshipRequest(id);
    }

//    @PostMapping()
//    public void approveFriendshipRequest(){
//
//    }
//
//
//    @PostMapping()
//    public void declineFriendshipRequest(){
//
//    }
}
