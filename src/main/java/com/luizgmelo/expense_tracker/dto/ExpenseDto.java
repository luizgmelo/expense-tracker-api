package com.luizgmelo.expense_tracker.dto;

import com.luizgmelo.expense_tracker.models.Expense;

import java.time.LocalDate;
import java.util.UUID;

public record ExpenseDto(UUID id, String description, String category, Double amount, LocalDate date) {
    public static ExpenseDto fromExpense(Expense expense) {
        return new ExpenseDto(expense.getId(), expense.getDescription(), expense.getCategory(), expense.getAmount(), expense.getDate());
    }
}
