package com.doggo.app.model.dto;

import lombok.Data;

@Data
public class MessageDto {

    private Long senderId;

    private Long receiverId;

    private String message;

    private Long messageDate;

    private Integer messageTypeId;

    private UserDto contact;
}
