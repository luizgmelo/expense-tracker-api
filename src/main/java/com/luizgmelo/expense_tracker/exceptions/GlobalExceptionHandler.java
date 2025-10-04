package com.luizgmelo.expense_tracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Map<String, String>> handleInvalidCredentialsException(InvalidCredentialsException exception) {
        Map<String, String> body = new HashMap<>();
        body.put("error", exception.getMessage());

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

}
