package com.luizgmelo.expense_tracker.repositories;

import com.luizgmelo.expense_tracker.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {
}
