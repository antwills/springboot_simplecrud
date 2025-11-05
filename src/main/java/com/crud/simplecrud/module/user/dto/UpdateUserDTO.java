package com.crud.simplecrud.module.user.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.Optional;


public record UpdateUserDTO(
        @NotNull(message = "ID is required.")
        @Positive(message = "ID cannot be negative.")
        Long id,
        Optional<String> name,
        Optional<String> email) {

//    @JsonCreator
//    public UpdateUserDTO(
//            @JsonProperty("id") Long id,
//            @JsonProperty("name") String name,
//            @JsonProperty("email") String email) {
//        this.id = id;
//        this.name = name == null ? Optional.empty() : Optional.of(name);
//        this.email = email == null ? Optional.empty() : Optional.of(email);
//    }
}
