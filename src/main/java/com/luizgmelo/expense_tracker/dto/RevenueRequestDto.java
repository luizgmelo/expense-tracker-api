package com.luizgmelo.expense_tracker.dto;

import java.time.LocalDate;
import java.util.UUID;

public record RevenueRequestDto(String description, Double amount, LocalDate date) {
}
