package com.luizgmelo.expense_tracker.dto;

import com.luizgmelo.expense_tracker.models.Revenue;

import java.time.LocalDate;
import java.util.UUID;

public record RevenueDto(UUID id, String description, Double amount, LocalDate date) {
    public static RevenueDto fromRevenue(Revenue revenue) {
        return new RevenueDto(revenue.getId(), revenue.getDescription(), revenue.getAmount(), revenue.getDate());
    }
}
