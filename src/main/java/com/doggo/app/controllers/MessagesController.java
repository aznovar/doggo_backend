package com.doggo.app.controllers;

import com.doggo.app.model.dto.GetChatByUserDto;
import com.doggo.app.model.dto.SendMessageDto;
import com.doggo.app.model.entities.chatmysql.Messages;
import com.doggo.app.model.repository.MessageRepository;
import com.doggo.app.model.service.MessageService;
import com.doggo.app.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        Long messageDate = sendMessageDto.getMessageDate();
        Integer messageType = sendMessageDto.getMessageTypeId();
        Messages messages = new Messages();
        messages.setSenderId(senderId);
        messages.setReceiverId(receiverId);
        messages.setMessage(message);
        messages.setMessageDate(messageDate);
        messages.setMessageTypeId(messageType);
        messageRepository.save(messages);
    }

    @GetMapping(value = "getChatsByUser/{userId}")
    public ResponseEntity getChatsByUser(@PathVariable(name = "userId") Long userId){
        List<GetChatByUserDto> getChatsByUser = messageService.getChatsByUser(userId);
        Map<Object, Object> response = new HashMap<>();
        response.put("success", "1");
        response.put("message", "user list of chats");
        response.put("listOfChats", getChatsByUser);
        return ResponseEntity.ok(response);
    }

}
