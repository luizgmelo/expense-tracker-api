package com.luizgmelo.expense_tracker.dto;

import java.time.LocalDate;

public record ExpenseRequestDto(String description, String category, Double amount, LocalDate date) {
}
