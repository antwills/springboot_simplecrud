package com.crud.simplecrud.module.post.domain;

import java.time.LocalDateTime;

public class Post {
    private  Long id;
    private  String content;
    private LocalDateTime createAt;
    private Long userId;

//    public Post(Long id, String content, UserDTO user){
//        this.id = id;
//        this.content = content;
//        this.createAt = LocalDateTime.now();
//        this.user = user;
//    }

    public Post(Long id, String content, LocalDateTime createAt, Long userId){
        this.id = id;
        this.content = content;
        this.createAt = createAt;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public Long getUserId() {
        return userId;
    }
}
