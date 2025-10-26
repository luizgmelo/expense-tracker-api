package com.luizgmelo.expense_tracker.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        Map<String, String> body = new HashMap<>();
        exception.getBindingResult().getFieldErrors()
                .forEach(error -> body.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<Map<String, String>> handleInvalidCredentialsException(InvalidCredentialsException exception) {
        Map<String, String> body = new HashMap<>();
        body.put("error", exception.getMessage());

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({ExpenseNotFoundException.class, RevenueNotFoundException.class})
    public ResponseEntity<Map<String, String>> handleExpenseNotFoundException(Exception exception) {
        Map<String, String> body = new HashMap<>();
        body.put("error", exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
