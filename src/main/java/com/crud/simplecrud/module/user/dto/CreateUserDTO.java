package com.crud.simplecrud.module.user.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

public record CreateUserDTO(
        @NotBlank(message = "Name is required.") String name,
        @NotBlank(message = "Name email required.") String email
) {
}
