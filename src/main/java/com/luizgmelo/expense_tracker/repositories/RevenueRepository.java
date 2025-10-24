package com.luizgmelo.expense_tracker.repositories;

import com.luizgmelo.expense_tracker.models.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RevenueRepository extends JpaRepository<Revenue, UUID> {
}
