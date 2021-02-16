package com.doggo.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetChatByUserDto {

    private Long senderId;

    private Long receiverId;

    private String message;

    private Long messageDate;

    private Integer messageTypeId;

}
