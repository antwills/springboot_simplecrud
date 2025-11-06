package com.crud.simplecrud.module.post.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Table(name = "tb_posts")
@Entity(name = "PostModel")
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
    private LocalDateTime createdAt;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    public PostModel(String content, Long userId) {
        this.id = null;
        this.content = content;
        this.userId = userId;
        this.createdAt = LocalDateTime.now();
    }
}
