package com.doggo.app.model.dto;

import lombok.Data;

@Data
public class FriendshipRequestDto {
    private String username;
    private Long id;
    private int type;

    public FriendshipRequestDto(String username, Long id, int type){
        this.username = username;
        this.id = id;
        this.type = type;
    }
}
