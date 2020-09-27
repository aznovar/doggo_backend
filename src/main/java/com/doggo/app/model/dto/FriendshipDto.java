package com.doggo.app.model.dto;

import lombok.Data;

@Data
public class FriendshipDto {

    private String sender;
    private String receiver;
    private String dateOfSend;
    private String status;
}
