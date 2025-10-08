package com.luizgmelo.expense_tracker.controllers;

import com.luizgmelo.expense_tracker.dto.ExpenseDto;
import com.luizgmelo.expense_tracker.dto.ExpenseResponseDto;
import com.luizgmelo.expense_tracker.services.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ResponseEntity<ExpenseResponseDto> createExpense(@RequestBody ExpenseDto expenseDto, Principal user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.registerExpense(expenseDto, user.getName()));
    }


}
