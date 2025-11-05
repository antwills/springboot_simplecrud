package com.crud.simplecrud.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);  // Construtor com mensagem personalizada
    }

    public NotFoundException(String message, Throwable causa) {
        super(message, causa);  // Para wrap de outras exceções
    }
}

