package com.doggo.app.model.service.implementation;

import com.doggo.app.model.repository.MessageRepository;
import com.doggo.app.model.repository.UserRepository;
import com.doggo.app.model.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageServiceImpl  implements MessageService {

    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository,
                              UserRepository userRepository){
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
    }


}
