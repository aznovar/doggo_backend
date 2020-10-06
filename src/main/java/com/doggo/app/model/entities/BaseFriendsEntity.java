package com.doggo.app.model.entities;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseFriendsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long friends_id;


}
