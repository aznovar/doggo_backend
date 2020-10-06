package com.doggo.app.messageservice.controllers;

import com.doggo.app.messageservice.model.Message;
import com.doggo.app.messageservice.model.OutputMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.doggo.app.messageservice.consts.NameOfEndpointsForBrokerPath.CHAT_WITH_SPECIFIC_USER;
import static com.doggo.app.messageservice.consts.NameOfEndpointsForBrokerPath.SECURED_CHAT_ROOM;

public class SendMessageToSpecificUser {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping(SECURED_CHAT_ROOM)
    public void sendSpecific(@Payload Message msg, Principal user, @Header("simpSessionId") String sessionId) throws Exception {
        OutputMessage out = new OutputMessage(msg.getSender(), msg.getContent(), new SimpleDateFormat("HH:mm").format(new Date()));
        simpMessagingTemplate.convertAndSendToUser(msg.getRecipient(), CHAT_WITH_SPECIFIC_USER, out);
    }
}
