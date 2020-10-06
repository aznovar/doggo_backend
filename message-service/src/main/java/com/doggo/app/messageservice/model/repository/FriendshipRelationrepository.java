package com.doggo.app.messageservice.model.repository;

import com.doggo.app.messageservice.model.entities.FriendshipRelation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface FriendshipRelationrepository extends JpaRepository<FriendshipRelation, BigInteger> {
    FriendshipRelation findAllById();
}
