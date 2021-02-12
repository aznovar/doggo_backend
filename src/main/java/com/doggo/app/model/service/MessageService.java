package com.doggo.app.model.service;

import com.doggo.app.model.dto.GetChatByUserDto;

import java.util.List;


public interface MessageService {

    List<GetChatByUserDto> getChatsByUser(Long userId);
}
