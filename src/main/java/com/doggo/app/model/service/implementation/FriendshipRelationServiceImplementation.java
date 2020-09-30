package com.doggo.app.model.service.implementation;


import com.doggo.app.model.entities.FriendshipRelation;
import com.doggo.app.model.entities.User;
import com.doggo.app.model.repository.FriendshipRelationRepository;
import com.doggo.app.model.repository.UserRepository;
import com.doggo.app.model.service.FriendshipRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FriendshipRelationServiceImplementation implements FriendshipRelationService {

    private final FriendshipRelationRepository friendshipRelationRepository;
    private final UserRepository userRepository;

    @Autowired
    public FriendshipRelationServiceImplementation(FriendshipRelationRepository friendshipRelationRepository,
                                                   UserRepository userRepository) {
        this.friendshipRelationRepository = friendshipRelationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public FriendshipRelation findAllByRequestAndApproveId(Long requestId, Long approveId) {
        FriendshipRelation friendshipRelation = friendshipRelationRepository.
                findByRequestUserIdAndApproveUserId(requestId, approveId);
        return friendshipRelation;
    }

    @Override
    public List<User> getInfoAboutFriendshipRequest(Long id) {
        List<User> friendshipRelation = userRepository.
                getInfoById(id);


        return friendshipRelation;
    }
}
