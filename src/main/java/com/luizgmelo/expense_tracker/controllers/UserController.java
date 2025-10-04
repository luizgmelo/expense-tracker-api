package com.luizgmelo.expense_tracker.controllers;

import com.luizgmelo.expense_tracker.dto.LoginDto;
import com.luizgmelo.expense_tracker.dto.RegisterDto;
import com.luizgmelo.expense_tracker.dto.TokenDto;
import com.luizgmelo.expense_tracker.dto.UserDto;
import com.luizgmelo.expense_tracker.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid RegisterDto registerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(registerDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody @Valid LoginDto loginDto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.login(loginDto));
    }
}
