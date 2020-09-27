package com.doggo.app.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "friends_relation")
@Data
public class FriendshipRelation extends BaseFriendsEntity {

    @Column(name = "request_user_id")
    private Long requestUserId;

    @Column(name = "approve_user_id")
    private Long approveUserId;

    @Column(name = "type")
    private int type;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "users",
    joinColumns = {@JoinColumn(name = "id", referencedColumnName = "request_user_id")})
    private User user;
}
