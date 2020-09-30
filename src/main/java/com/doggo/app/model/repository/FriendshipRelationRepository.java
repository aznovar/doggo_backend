package com.doggo.app.model.repository;


import com.doggo.app.model.entities.FriendshipRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendshipRelationRepository extends JpaRepository<FriendshipRelation, Long> {

    FriendshipRelation findByRequestUserIdAndApproveUserId(Long request_user_id, Long approve_user_id);


}
