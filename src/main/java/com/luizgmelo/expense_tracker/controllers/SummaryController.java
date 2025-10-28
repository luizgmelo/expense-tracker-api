package com.luizgmelo.expense_tracker.controllers;

import com.luizgmelo.expense_tracker.dto.MonthSummary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/summary")
public class SummaryController {

    @GetMapping("{year}/{month}")
    public ResponseEntity<MonthSummary> getMonthSummary(@PathVariable int year,
                                                        @PathVariable int month,
                                                        Principal principal) {
        return ResponseEntity.status(HttpStatus.OK).body();
    }
}
