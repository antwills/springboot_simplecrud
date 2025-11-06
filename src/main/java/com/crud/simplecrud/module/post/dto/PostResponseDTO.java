package com.crud.simplecrud.module.post.dto;

import com.crud.simplecrud.module.post.domain.Post;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record PostResponseDTO(
        Long id,
        String content,
        @JsonProperty("created_at") LocalDateTime createAt,
        @JsonProperty("user_id") Long userId
) {
    public PostResponseDTO(Post post){
        this(post.getId(), post.getContent(), post.getCreatedAt(), post.getUserId());
    }
}
