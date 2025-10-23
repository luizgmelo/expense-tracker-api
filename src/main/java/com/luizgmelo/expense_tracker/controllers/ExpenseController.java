package com.luizgmelo.expense_tracker.controllers;

import com.luizgmelo.expense_tracker.dto.ExpenseDto;
import com.luizgmelo.expense_tracker.dto.ExpenseResponseDto;
import com.luizgmelo.expense_tracker.services.ExpenseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<Page<ExpenseDto>> listExpenses(Pageable pageable,
                                                         @RequestParam(required = false) LocalDate startDate,
                                                         @RequestParam(required = false) LocalDate endDate) {
        return ResponseEntity.status(HttpStatus.OK).body(expenseService.getExpenses(pageable, startDate, endDate));
    }

    @PostMapping
    public ResponseEntity<ExpenseResponseDto> createExpense(@RequestBody ExpenseDto expenseDto, Principal user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(expenseService.registerExpense(expenseDto, user.getName()));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable UUID id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.noContent().build();
    }
}
