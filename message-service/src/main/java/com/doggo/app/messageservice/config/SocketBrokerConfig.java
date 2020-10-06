package com.doggo.app.messageservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import static com.doggo.app.messageservice.consts.NameOfEndpointsForBrokerPath.*;

@Configuration
@EnableWebSocketMessageBroker
public class SocketBrokerConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/spring-mvc-socket");
        registry.setUserDestinationPrefix("/secured/user");
        //registry.enableStompBrokerRelay(CHAT_WITH_SPECIFIC_USER, CHAT_IN_COMMON_CHANNEL);
        registry.enableStompBrokerRelay(CHAT_WITH_SPECIFIC_USER, CHAT_IN_COMMON_CHANNEL)
                .setRelayHost("localhost")
                .setRelayPort(61613)
                .setClientLogin("guest")
                .setClientPasscode("guest");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint(SECURED_CHAT)
                .setAllowedOrigins()
                .withSockJS();
        registry.addEndpoint(SECURED_CHAT_ROOM)
                .setAllowedOrigins()
                .withSockJS();
    }
}
