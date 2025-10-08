package com.luizgmelo.expense_tracker.services;

import com.luizgmelo.expense_tracker.dto.ExpenseDto;
import com.luizgmelo.expense_tracker.dto.ExpenseResponseDto;
import com.luizgmelo.expense_tracker.models.Expense;
import com.luizgmelo.expense_tracker.models.User;
import com.luizgmelo.expense_tracker.repositories.ExpenseRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserService userService;

    public ExpenseService(ExpenseRepository expenseRepository, UserService userService) {
        this.expenseRepository = expenseRepository;
        this.userService = userService;
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
}
