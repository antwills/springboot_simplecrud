package com.crud.simplecrud.module.post.domain;

import java.time.LocalDateTime;

public class Post {
    private  Long id;
    private  String content;
    private LocalDateTime createdAt;
    private Long userId;

//    public Post(Long id, String content, UserDTO user){
//        this.id = id;
//        this.content = content;
//        this.createAt = LocalDateTime.now();
//        this.user = user;
//    }

    public Post(Long id, String content, LocalDateTime createdAt, Long userId){
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getUserId() {
        return userId;
    }
}
