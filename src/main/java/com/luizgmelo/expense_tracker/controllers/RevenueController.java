package com.luizgmelo.expense_tracker.controllers;

import com.luizgmelo.expense_tracker.dto.RevenueRequestDto;
import com.luizgmelo.expense_tracker.dto.RevenueResponseDto;
import com.luizgmelo.expense_tracker.services.RevenueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/revenues")
public class RevenueController {

    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }

    @PostMapping
    public ResponseEntity<RevenueResponseDto> registerRevenue(@RequestBody RevenueRequestDto revenueRequestDto, Principal principal) {
        return ResponseEntity.status(HttpStatus.OK).body(revenueService.registerRevenue(revenueRequestDto, principal.getName()));
    }

}
