package com.doggo.app.messageservice.model;

import lombok.Data;

@Deprecated
@Data
public class Message {
    private String type;
    private String sender;
    private String recipient;
    private String content;

}
