package com.doggo.app.model.service;


import com.doggo.app.model.entities.FriendshipRelation;
import com.doggo.app.model.entities.User;

import java.util.List;

public interface FriendshipRelationService {

    FriendshipRelation findAllByRequestAndApproveId(Long requestId, Long approveId);

    List<User> getInfoAboutFriendshipRequest(Long id);
}
