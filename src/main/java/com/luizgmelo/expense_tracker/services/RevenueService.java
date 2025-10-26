package com.luizgmelo.expense_tracker.services;

import com.luizgmelo.expense_tracker.dto.RevenueRequestDto;
import com.luizgmelo.expense_tracker.dto.RevenueResponseDto;
import com.luizgmelo.expense_tracker.exceptions.RevenueNotFoundException;
import com.luizgmelo.expense_tracker.models.Revenue;
import com.luizgmelo.expense_tracker.models.User;
import com.luizgmelo.expense_tracker.repositories.RevenueRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class RevenueService {

    private final RevenueRepository revenueRepository;
    private final UserService userService;

    public RevenueService(RevenueRepository revenueRepository, UserService userService) {
        this.revenueRepository = revenueRepository;
        this.userService = userService;
    }

    public Page<RevenueResponseDto> listRevenues(Pageable pageable, String email) {
        User user = userService.findUserByEmail(email);

        Page<Revenue> pageRevenue = revenueRepository.findAllByUser(pageable, user);

        return pageRevenue.map(revenue -> new RevenueResponseDto(revenue.getId(), revenue.getDescription(),
                revenue.getAmount(), revenue.getDate(), user.getId()));
    }

    public RevenueResponseDto registerRevenue(RevenueRequestDto revenueRequestDto, String email) {

        User user = userService.findUserByEmail(email);

        Revenue revenue = new Revenue();
        BeanUtils.copyProperties(revenueRequestDto, revenue);
        revenue.setUser(user);

        revenueRepository.save(revenue);

        return new RevenueResponseDto(revenue.getId(), revenue.getDescription(),
                revenue.getAmount(), revenue.getDate(), user.getId());
    }

    public void deleteRevenue(UUID id, String email) {
        User user = userService.findUserByEmail(email);
        Revenue revenue = revenueRepository.findByIdAndUser(id, user).orElseThrow(RevenueNotFoundException::new);
        revenueRepository.delete(revenue);
    }
}
