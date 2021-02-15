package com.doggo.app.model.repository;

import com.doggo.app.model.dto.GetChatByUserDto;
import com.doggo.app.model.entities.chatmysql.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageRepository extends JpaRepository<Messages, Long> {

    @Query(value = "select new com.doggo.app.model.dto.GetChatByUserDto(m1.senderId, m1.receiverId, m1.message," +
            "m1.messageDate,m1.messageTypeId) from Messages m1 left join Messages as m2 on m1.senderId = m2.senderId" +
            " and m1.receiverId = m2.receiverId or m1.senderId = m2.receiverId and m1.receiverId = m2.receiverId" +
            " and  m1.messageId < m2.messageId where  m1.senderId = :userId or m1.receiverId = :userId" +
            " and m2.messageId is null order by m1.messageDate desc ")
    List<GetChatByUserDto> getChatsByUser(@Param("userId") Long userId);
}
