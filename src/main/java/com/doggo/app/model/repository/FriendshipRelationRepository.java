package com.doggo.app.model.repository;

import com.doggo.app.model.entities.FriendshipRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface FriendshipRelationRepository extends JpaRepository<FriendshipRelation, Long> {

    FriendshipRelation findByRequestUserIdAndApproveUserId(Long request_user_id, Long approve_user_id);

    @Query(value = "SELECT friends_id FROM friends_relation fr WHERE fr.request_user_id = :requestId " +
            "AND fr.approve_user_id = :approveId AND type = 0",
            nativeQuery = true)
    Long getFriendsId(@Param("requestId") Long requestId, @Param("approveId") Long approveId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE friends_relation fr SET fr.type = 1 WHERE fr.friends_id = :friendsId ", nativeQuery = true)
    void updateType(@Param("friendsId") Long friendsId);
}
