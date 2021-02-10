package com.doggo.app.model.repository;

import com.doggo.app.model.entities.chatmongodb.ChatMessage;
import com.doggo.app.model.entities.chatmongodb.MessageStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, String> {

    Long countBySenderIdAndRecipientIdAndStatus(
            String senderId, String recipientId, MessageStatus status);

    List<ChatMessage> findByChatId(String chatId);

}