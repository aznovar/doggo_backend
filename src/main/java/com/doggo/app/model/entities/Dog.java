package com.doggo.app.model.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dogs")
@Data

public class Dog extends BaseEntity {

    @Column(name = "dog_name")
    private String dogName;

    @Column(name = "dog_birthday")
    private String dog_birthday;

    @Column(name = "dog_sex")
    private String dogSex;

    @Column(name = "dog_breed")
    private String dogBreed;

    @ManyToMany(mappedBy = "dogs", fetch = FetchType.LAZY)
    private List<User> user;


}