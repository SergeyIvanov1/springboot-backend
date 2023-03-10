package com.ivanov_sergey.springbootbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TestEntityGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<TestEntityIncorrectData> handleException(NoSuchTestEntityException exception){
        TestEntityIncorrectData data = new TestEntityIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<TestEntityIncorrectData> handleException(Exception exception){
        TestEntityIncorrectData data = new TestEntityIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
