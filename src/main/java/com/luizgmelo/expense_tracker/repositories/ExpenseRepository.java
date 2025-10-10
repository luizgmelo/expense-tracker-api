package com.luizgmelo.expense_tracker.repositories;

import com.luizgmelo.expense_tracker.models.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
    Page<Expense> findByDateBetween(Pageable pageable, LocalDate startDate, LocalDate endDate);
}
