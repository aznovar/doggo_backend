package com.doggo.app.messageservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Deprecated
public class OutputMessage extends Message {

    private String time;

    public OutputMessage(final String sender, final String content, final String time) {
        setSender(sender);
        setContent(content);
        this.time = time;
    }
}
