package com.doggo.app.model.service.implementation;


import com.doggo.app.model.dto.FriendshipRequestDto;
import com.doggo.app.model.entities.FriendshipRelation;
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
        FriendshipRelation friendshipRelation = friendshipRelationRepository
                .findByRequestUserIdAndApproveUserId(requestId, approveId);
        return friendshipRelation;
    }

    @Override
    public List<FriendshipRequestDto> getInfoAboutFriendshipRequest(Long id) {
        List<FriendshipRequestDto> friendshipRelation = userRepository
                .getInfoAboutFriendshipRequestById(id);
        return friendshipRelation;
    }

    @Override
    public List<FriendshipRequestDto> getInfoAboutFriendshipList(Long id) {
        List<FriendshipRequestDto> friendshipRelation = userRepository
                .getInfoAboutFriendshipListById(id);
        return friendshipRelation;
    }

    @Override
    public Long getFriendsId(Long reqId, Long apprId) {
        return friendshipRelationRepository
                .getFriendsId(reqId, apprId);
    }

    @Override
    public void updateTypeAfterApproveFriendsRequest(Long friendsId) {
        friendshipRelationRepository.updateType(friendsId);
    }
}
