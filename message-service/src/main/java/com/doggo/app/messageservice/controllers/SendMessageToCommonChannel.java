package com.doggo.app.messageservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class SendMessageToCommonChannel {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


}
