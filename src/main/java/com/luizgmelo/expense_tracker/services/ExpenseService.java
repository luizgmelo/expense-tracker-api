package com.luizgmelo.expense_tracker.services;

import com.luizgmelo.expense_tracker.dto.ExpenseDto;
import com.luizgmelo.expense_tracker.dto.ExpenseRequestDto;
import com.luizgmelo.expense_tracker.dto.ExpenseResponseDto;
import com.luizgmelo.expense_tracker.exceptions.ExpenseNotFoundException;
import com.luizgmelo.expense_tracker.models.Expense;
import com.luizgmelo.expense_tracker.models.User;
import com.luizgmelo.expense_tracker.repositories.ExpenseRepository;
import org.springframework.beans.BeanUtils;
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

    public Page<ExpenseDto> getExpenses(Pageable pageable, LocalDate startDate, LocalDate endDate, String email) {

        User user = userService.findUserByEmail(email);

        Page<Expense> expensePage;
        if (startDate != null && endDate != null) {
            expensePage = expenseRepository.findByUserAndDateBetween(pageable, startDate, endDate, user);
        } else {
            expensePage = expenseRepository.findAllByUser(pageable, user);
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
        expense.setUser(user);

        Expense newExpense = expenseRepository.save(expense);

        return new ExpenseResponseDto(newExpense.getId(), newExpense.getDescription(), newExpense.getCategory(),
                newExpense.getAmount(), newExpense.getDate(), user.getId());
    }

    public ExpenseResponseDto updateExpense(UUID id, ExpenseRequestDto expenseUpdateDto, String email) {
        User user =  userService.findUserByEmail(email);
        Expense expense = expenseRepository.findByIdAndUser(id, user).orElseThrow(ExpenseNotFoundException::new);

        BeanUtils.copyProperties(expenseUpdateDto, expense);

        expenseRepository.save(expense);

        return new ExpenseResponseDto(expense.getId(), expense.getDescription(), expense.getCategory(),
                expense.getAmount(), expense.getDate(), user.getId());
    }

    public void deleteExpense(UUID id, String email) {
        User user =  userService.findUserByEmail(email);
        expenseRepository.findByIdAndUser(id, user).orElseThrow(ExpenseNotFoundException::new);
        expenseRepository.deleteById(id);
    }
}
