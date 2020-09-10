package com.doggo.app.messageservice.models;

import lombok.Data;

@Data
public class Message {
    private String type;
    private String sender;
    private String recipient;
    private String content;

}
