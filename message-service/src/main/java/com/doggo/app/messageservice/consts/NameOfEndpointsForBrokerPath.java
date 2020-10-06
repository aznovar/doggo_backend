package com.doggo.app.messageservice.consts;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NameOfEndpointsForBrokerPath {

    public final static String CHAT_WITH_SPECIFIC_USER = "/chat/user/queue/specific_user";

    public final static String CHAT_IN_COMMON_CHANNEL = "/chat/topic/common";

    public static final String SECURED_CHAT = "/secured/chat";

    public static final String SECURED_CHAT_ROOM = "/secured/room";

}
