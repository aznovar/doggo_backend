package com.doggo.app.model.repository;

import com.doggo.app.model.entities.chatmysql.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Messages, Long> {


}
