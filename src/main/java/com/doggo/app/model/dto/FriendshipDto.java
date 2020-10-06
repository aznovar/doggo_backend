package com.doggo.app.model.dto;

import lombok.Data;

@Data
public class FriendshipDto {

    private Long requestUserId;
    private Long approveUserId;

}
