package com.doggo.app.model.entities.chatmysql;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "messages")
@Data
public class Messages {

    @Id
    @Column(name = "message_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @Column(name = "sender_id")
    private Long senderId;

    @Column(name = "receiver_id")
    private Long receiverId;

    @Column(name = "message")
    private String message;

    @Column(name = "message_type_id")
    private Integer messageTypeId;

    @Column(name = "message_date")
    private Long messageDate;
}
