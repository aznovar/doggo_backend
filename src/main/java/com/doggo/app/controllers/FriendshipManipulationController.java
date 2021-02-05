package com.doggo.app.controllers;


import com.doggo.app.model.dto.AddFriendDto;
import com.doggo.app.model.dto.FriendshipDto;
import com.doggo.app.model.dto.FriendshipRequestDto;
import com.doggo.app.model.entities.FriendshipRelation;
import com.doggo.app.model.entities.User;
import com.doggo.app.model.repository.FriendshipRelationRepository;
import com.doggo.app.model.service.FriendshipRelationService;
import com.doggo.app.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping(value = "addFriend")
    public void friendshipAddRequest(@RequestBody AddFriendDto addFriendDto) {
        String username = addFriendDto.getUsername();
        Long id = addFriendDto.getId();
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
    public ResponseEntity getActiveFriendshipRequests(@PathVariable(name = "id") Long id) {
        List<FriendshipRequestDto> friendshipRelation = friendshipRelationService
                .getInfoAboutFriendshipRequest(id);
        Map<Object, Object> response = new HashMap<>();
        response.put("success", "1");
        response.put("message", "users friend request");
        response.put("friendsRequest", friendshipRelation);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "getFriendshipList/{id}")
    public ResponseEntity getFriendshipList(@PathVariable(name = "id") Long id){
        List<FriendshipRequestDto> friendshipRelation = friendshipRelationService
                .getInfoAboutFriendshipList(id);
        Map<Object, Object> response = new HashMap<>();
        response.put("success", "1");
        response.put("message", "users friend list");
        response.put("friendsList", friendshipRelation);
        return ResponseEntity.ok(response);
    }

    @PostMapping("approveFriendship")
    public void approveFriendshipRequest(@RequestBody FriendshipDto friendshipDto){
        Long requestUserId = friendshipDto.getRequestUserId();
        Long approveUserID = friendshipDto.getApproveUserId();
        Long friendsId = friendshipRelationService.getFriendsId(requestUserId,approveUserID);
        friendshipRelationService.updateTypeAfterApproveFriendsRequest(friendsId);
    }
//
//
//    @PostMapping()
//    public void declineFriendshipRequest(){
//
//    }
}
