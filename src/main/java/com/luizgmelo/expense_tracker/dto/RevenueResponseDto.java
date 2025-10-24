package com.luizgmelo.expense_tracker.dto;

import java.time.LocalDate;
import java.util.UUID;

public record RevenueResponseDto(UUID id, String description, Double amount, LocalDate date, UUID userId) {
}
