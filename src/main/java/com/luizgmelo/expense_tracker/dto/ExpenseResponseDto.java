package com.luizgmelo.expense_tracker.dto;

import java.time.LocalDate;
import java.util.UUID;

public record ExpenseResponseDto(UUID id, String description, String category, Double amount, LocalDate date, UUID userId) {
}
