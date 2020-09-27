package com.doggo.app.model.service;


import com.doggo.app.model.entities.FriendshipRelation;

import java.math.BigInteger;
import java.util.List;

public interface FriendshipRelationService {

    FriendshipRelation findAllByRequestAndApproveId(Long requestId, Long approveId);
}
