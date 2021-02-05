package com.doggo.app.model.repository;

import com.doggo.app.model.dto.FriendshipRequestDto;
import com.doggo.app.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);

    @Query(value = "select new com.doggo.app.model.dto.FriendshipRequestDto(us.username, us.id,fr.type) FROM User us,FriendshipRelation fr WHERE us.id <> :id " +
            "AND fr.approveUserId = :id AND us.id = fr.requestUserId AND fr.type = 0")
    List<FriendshipRequestDto> getInfoAboutFriendshipRequestById(@Param("id") Long id);

    @Query(value = "select new com.doggo.app.model.dto.FriendshipRequestDto(us.username, us.id,fr.type) FROM User us,FriendshipRelation fr WHERE us.id <> :id " +
            "AND fr.approveUserId = :id AND us.id = fr.requestUserId AND fr.type = 1")
    List<FriendshipRequestDto> getInfoAboutFriendshipListById(@Param ("id") Long id);
}
