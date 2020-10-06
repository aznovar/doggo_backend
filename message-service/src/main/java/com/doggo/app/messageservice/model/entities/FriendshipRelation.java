package com.doggo.app.messageservice.model.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigInteger;

@Entity
@Table(name = "friends_relation")
@Data
public class FriendshipRelation extends BaseEntity {

    @Column(name = "request_user_id")
    private BigInteger request_user_id;

    @Column(name = "approve_user_id")
    private BigInteger approve_user_id;

    @Column(name = "type")
    private int type;

}
