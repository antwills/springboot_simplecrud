package com.crud.simplecrud.shared.domain;

import java.time.LocalDateTime;

public record PostDTO(
        Long id,
        String content,
        LocalDateTime createAt,
        Long userId
) {
}
