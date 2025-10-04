package com.luizgmelo.expense_tracker.repositories;

import com.luizgmelo.expense_tracker.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
