package com.doggo.app.controllers;

import com.doggo.app.model.dto.GetChatByUserDto;
import com.doggo.app.model.dto.MessageDto;
import com.doggo.app.model.dto.SendMessageDto;
import com.doggo.app.model.dto.UserDto;
import com.doggo.app.model.entities.User;
import com.doggo.app.model.entities.chatmysql.Messages;
import com.doggo.app.model.repository.MessageRepository;
import com.doggo.app.model.service.MessageService;
import com.doggo.app.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
                              MessageRepository messageRepository) {
        this.userService = userService;
        this.messageService = messageService;
        this.messageRepository = messageRepository;
    }

    @PostMapping(value = "sendMessage")
    public void sendMessage(@RequestBody SendMessageDto sendMessageDto) {
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
    public ResponseEntity getChatsByUser(@PathVariable(name = "userId") Long userId) {
        MessageDto messageDto = new MessageDto();
        List<GetChatByUserDto> getChatsByUser = messageService.getChatsByUser(userId);
        List<MessageDto> getChatsByUserChanged = setContactForResponseEntity(messageDto, getChatsByUser, userId);
        Map<Object, Object> response = new HashMap<>();
        response.put("success", "1");
        response.put("message", "user list of chats");
        response.put("listOfChats", getChatsByUserChanged);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "getMessagesWithContact/{contactId}/{userId}")
    public ResponseEntity getMessagesWithContact(@PathVariable(name = "contactId") Long contactId,
                                                 @PathVariable(name = "userId") Long userId) {
        List<GetChatByUserDto> getMessagesWithContact = messageService.getMessagesWithContact(contactId, userId);
        Map<Object, Object> response = new HashMap<>();
        response.put("success", "1");
        response.put("message", "user list of messages");
        response.put("listOfMessages", getMessagesWithContact);
        return ResponseEntity.ok(response);
    }

    private List<MessageDto> setContactForResponseEntity(MessageDto messageDto,
                                                         List<GetChatByUserDto> getChatByUserDto,
                                                         Long id) {
        List<MessageDto> lstMessageDto = new ArrayList<>();
        for (GetChatByUserDto loopGet : getChatByUserDto) {
            User user;
            if (id != loopGet.getSenderId()) {
                user = userService.findById(loopGet.getSenderId());
                UserDto userDto = UserDto.fromUser(user);
                messageDto.setContact(userDto);
            } else {
                user = userService.findById(loopGet.getReceiverId());
                UserDto userDto = UserDto.fromUser(user);
                messageDto.setContact(userDto);
            }
            messageDto.setSenderId(loopGet.getSenderId());
            messageDto.setReceiverId(loopGet.getReceiverId());
            messageDto.setMessage(loopGet.getMessage());
            messageDto.setMessageDate(loopGet.getMessageDate());
            messageDto.setMessageTypeId(loopGet.getMessageTypeId());
            lstMessageDto.add(messageDto);
        }
        return lstMessageDto;
    }

}
