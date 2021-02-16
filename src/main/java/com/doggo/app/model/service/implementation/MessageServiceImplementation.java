package com.doggo.app.model.service.implementation;

import com.doggo.app.model.dto.GetChatByUserDto;
import com.doggo.app.model.repository.MessageRepository;
import com.doggo.app.model.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImplementation implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImplementation(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    @Override
    public List<GetChatByUserDto> getChatsByUser(Long userId) {
       return messageRepository.getChatsByUser(userId);
    }

    @Override
    public List<GetChatByUserDto> getMessagesWithContact(Long contactId, Long userId) {
        return messageRepository.getMessagesWithContact(contactId, userId);
    }
}
