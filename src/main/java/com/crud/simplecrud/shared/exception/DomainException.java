package com.crud.simplecrud.shared.exception;

public class DomainException extends RuntimeException{
    DomainException(String message){
        super(message);
    }
}
