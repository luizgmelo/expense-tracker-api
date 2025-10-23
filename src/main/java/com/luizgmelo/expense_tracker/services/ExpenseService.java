package com.luizgmelo.expense_tracker.services;

import com.luizgmelo.expense_tracker.dto.ExpenseDto;
import com.luizgmelo.expense_tracker.dto.ExpenseResponseDto;
import com.luizgmelo.expense_tracker.models.Expense;
import com.luizgmelo.expense_tracker.models.User;
import com.luizgmelo.expense_tracker.repositories.ExpenseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserService userService;

    public ExpenseService(ExpenseRepository expenseRepository, UserService userService) {
        this.expenseRepository = expenseRepository;
        this.userService = userService;
    }

    public Page<ExpenseDto> getExpenses(Pageable pageable, LocalDate startDate, LocalDate endDate) {
        Page<Expense> expensePage;
        if (startDate != null && endDate != null) {
            expensePage = expenseRepository.findByDateBetween(pageable, startDate, endDate);
        } else {
            expensePage = expenseRepository.findAll(pageable);
        }
        return expensePage.map(ExpenseDto::fromExpense);
    }

    public ExpenseResponseDto registerExpense(ExpenseDto expenseDto, String email) {

        User user =  userService.findUserByEmail(email);

        Expense expense = new Expense();
        expense.setDescription(expenseDto.description());
        expense.setCategory(expenseDto.category());
        expense.setAmount(expenseDto.amount());
        expense.setDate(expenseDto.date());

        Expense newExpense = expenseRepository.save(expense);

        return new ExpenseResponseDto(newExpense.getId(), newExpense.getDescription(), newExpense.getCategory(),
                newExpense.getAmount(), newExpense.getDate(), user.getId());
    }

    public void deleteExpense(UUID id) {
        expenseRepository.deleteById(id);
    }
}
