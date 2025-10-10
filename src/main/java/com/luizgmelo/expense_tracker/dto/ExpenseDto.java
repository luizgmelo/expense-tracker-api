package com.luizgmelo.expense_tracker.dto;

import com.luizgmelo.expense_tracker.models.Expense;
import lombok.Setter;

import java.time.LocalDate;

public record ExpenseDto(String description, String category, Double amount, LocalDate date) {
    public static ExpenseDto fromExpense(Expense expense) {
        return new ExpenseDto(expense.getDescription(), expense.getCategory(), expense.getAmount(), expense.getDate());
    }
}
