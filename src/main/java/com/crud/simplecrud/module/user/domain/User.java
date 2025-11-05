package com.crud.simplecrud.module.user.domain;

import lombok.Getter;

import java.util.Optional;

@Getter
public class User {
    private Long id;
    private String name;
    private String email;

    public User(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void updateName(String name){
        this.name = name;
    }

    public void updateEmail(String email){

        this.email = email;
    }
}
