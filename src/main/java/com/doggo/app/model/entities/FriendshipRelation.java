package com.doggo.app.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "friends_relation")
@Data
public class FriendshipRelation extends BaseFriendsEntity implements Serializable {

    @Column(name = "request_user_id")
    private Long requestUserId;

    @Column(name = "approve_user_id")
    private Long approveUserId;

    @Column(name = "type")
    private int type;

}
