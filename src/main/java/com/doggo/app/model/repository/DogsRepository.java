package com.doggo.app.model.repository;

import com.doggo.app.model.entities.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogsRepository extends JpaRepository<Dog, Long> {
//    Dog finByDogName(String dogName);
}
