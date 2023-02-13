package com.ivanov_sergey.springbootbackend.exception;

public class NoSuchTestEntityException extends RuntimeException{

    public NoSuchTestEntityException(String message) {
        super(message);
    }
}
