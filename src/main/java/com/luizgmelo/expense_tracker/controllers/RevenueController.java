package com.luizgmelo.expense_tracker.controllers;

import com.luizgmelo.expense_tracker.dto.RevenueRequestDto;
import com.luizgmelo.expense_tracker.dto.RevenueResponseDto;
import com.luizgmelo.expense_tracker.services.RevenueService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/revenues")
public class RevenueController {

    private final RevenueService revenueService;

    public RevenueController(RevenueService revenueService) {
        this.revenueService = revenueService;
    }
    // TODO updateRevenue

    @GetMapping
    public ResponseEntity<Page<RevenueResponseDto>> listRevenues(Pageable pageable, Principal principal) {
        return ResponseEntity.status(HttpStatus.OK).body(revenueService.listRevenues(pageable, principal.getName()));
    }

    @PostMapping
    public ResponseEntity<RevenueResponseDto> registerRevenue(@RequestBody RevenueRequestDto revenueRequestDto, Principal principal) {
        return ResponseEntity.status(HttpStatus.CREATED).body(revenueService.registerRevenue(revenueRequestDto, principal.getName()));
    }

    @PutMapping("{id}")
    public ResponseEntity<RevenueResponseDto> updateRevenue(@PathVariable UUID id, @RequestBody RevenueRequestDto revenueRequestDto, Principal principal) {
        return ResponseEntity.status(HttpStatus.OK).body(revenueService.updateRevenue(id, revenueRequestDto, principal.getName()));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteRevenue(@PathVariable UUID id, Principal principal) {
        revenueService.deleteRevenue(id, principal.getName());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
