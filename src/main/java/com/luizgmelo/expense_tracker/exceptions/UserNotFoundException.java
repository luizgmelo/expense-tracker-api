package com.luizgmelo.expense_tracker.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("Usuário não encontrado!");
    }
    public UserNotFoundException(String message) {
        super(message);
    }
}
