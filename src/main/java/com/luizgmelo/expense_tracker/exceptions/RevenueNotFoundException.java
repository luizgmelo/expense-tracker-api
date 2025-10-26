package com.luizgmelo.expense_tracker.exceptions;

public class RevenueNotFoundException extends RuntimeException {
    public RevenueNotFoundException() {
        super("Receita não encontrada!");
    }
    public RevenueNotFoundException(String message) {
        super(message);
    }
}
