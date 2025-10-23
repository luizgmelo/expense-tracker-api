package com.luizgmelo.expense_tracker.repositories;

import com.luizgmelo.expense_tracker.models.Expense;
import com.luizgmelo.expense_tracker.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
    Optional<Expense> findByIdAndUser(UUID id, User user);
    Page<Expense> findByUserAndDateBetween(Pageable pageable, LocalDate startDate, LocalDate endDate, User user);
    Page<Expense> findAllByUser(Pageable pageable, User user);
}

