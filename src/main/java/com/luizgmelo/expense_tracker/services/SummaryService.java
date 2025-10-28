package com.luizgmelo.expense_tracker.services;

import com.luizgmelo.expense_tracker.dto.MonthSummary;
import com.luizgmelo.expense_tracker.models.User;
import com.luizgmelo.expense_tracker.repositories.RevenueRepository;
import org.springframework.stereotype.Service;

@Service
public class SummaryService {

    private final UserService userService;
    private final RevenueRepository revenueRepository;

    public SummaryService(UserService userService, RevenueRepository revenueRepository) {
        this.userService = userService;
        this.revenueRepository = revenueRepository;
    }

    public MonthSummary getSummaryMonth(int year, int month, String email) {
        User user = userService.findUserByEmail(email);
    }

}
