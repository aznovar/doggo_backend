package com.doggo.app.model.dto;

import lombok.Data;

@Data
public class SendMessageDto {

    private Long senderId;
    private Long receiverId;
    private String message;
    private Integer messageTypeId;
}
