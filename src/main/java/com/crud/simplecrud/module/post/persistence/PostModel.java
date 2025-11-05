package com.crud.simplecrud.module.post.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "tb_posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createAt;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    public PostModel(String content, Long userId) {
        this.id = null;
        this.content = content;
        this.userId = userId;
        this.createAt = LocalDateTime.now();
    }
}
