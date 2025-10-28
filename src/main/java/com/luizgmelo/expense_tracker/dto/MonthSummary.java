package com.luizgmelo.expense_tracker.dto;

import java.math.BigDecimal;

public record MonthSummary(BigDecimal totalRevenue, BigDecimal totalExpense, BigDecimal totalFinal) {
}
