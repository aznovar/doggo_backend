package com.doggo.app.model.repository;

import com.doggo.app.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);

    @Query(value = "SELECT * FROM users us,friends_relation fr WHERE us.id != :id " +
            "AND fr.approve_user_id = :id AND us.id = fr.request_user_id AND type = 0",
            nativeQuery = true)
    List<User> getInfoById(@Param("id") Long id);
}
