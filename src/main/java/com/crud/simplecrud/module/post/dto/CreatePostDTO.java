package com.crud.simplecrud.module.post.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreatePostDTO(
        @NotBlank(message = "Content is required.") String content,
        @NotNull(message = "UserId is required.")
        @JsonProperty("user_id")
        Long userId
) {
}
