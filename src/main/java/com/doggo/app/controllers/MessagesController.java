package com.doggo.app.controllers;

import com.doggo.app.model.dto.SendMessageDto;
import com.doggo.app.model.entities.chatmysql.Messages;
import com.doggo.app.model.repository.MessageRepository;
import com.doggo.app.model.service.MessageService;
import com.doggo.app.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/messaging/")
public class MessagesController {

    private final UserService userService;
    private final MessageService messageService;
    private final MessageRepository messageRepository;

    @Autowired
    public MessagesController(UserService userService,
                              MessageService messageService,
                              MessageRepository messageRepository){
        this.userService = userService;
        this.messageService = messageService;
        this.messageRepository = messageRepository;
    }

    @PostMapping(value = "sendMessage")
    public void sendMessage(@RequestBody SendMessageDto sendMessageDto){
        Long senderId = sendMessageDto.getSenderId();
        Long receiverId = sendMessageDto.getReceiverId();
        String message = sendMessageDto.getMessage();
        Integer messageType = sendMessageDto.getMessageTypeId();
        Messages messages = new Messages();
        messages.setSenderId(senderId);
        messages.setReceiverId(receiverId);
        messages.setMessage(message);
        messages.setMessageTypeId(messageType);
        messageRepository.save(messages);
    }

}
