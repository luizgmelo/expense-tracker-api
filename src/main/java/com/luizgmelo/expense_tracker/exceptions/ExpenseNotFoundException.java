package com.luizgmelo.expense_tracker.exceptions;

public class ExpenseNotFoundException extends RuntimeException {
    public ExpenseNotFoundException() {
        super("Despesa não encontrada!");
    }
    public ExpenseNotFoundException(String message) {
        super(message);
    }
}
