package com.luizgmelo.expense_tracker.dto;

import java.time.LocalDate;

public record ExpenseDto(String description, String category, Double amount, LocalDate date) {
}
