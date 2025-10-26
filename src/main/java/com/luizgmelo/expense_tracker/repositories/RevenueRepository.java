package com.luizgmelo.expense_tracker.repositories;

import com.luizgmelo.expense_tracker.models.Revenue;
import com.luizgmelo.expense_tracker.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RevenueRepository extends JpaRepository<Revenue, UUID> {
    Page<Revenue> findAllByUser(Pageable pageable, User user);
}
