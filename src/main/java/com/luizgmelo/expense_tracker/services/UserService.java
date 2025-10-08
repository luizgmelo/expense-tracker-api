package com.luizgmelo.expense_tracker.services;

import com.luizgmelo.expense_tracker.dto.LoginDto;
import com.luizgmelo.expense_tracker.dto.RegisterDto;
import com.luizgmelo.expense_tracker.dto.TokenDto;
import com.luizgmelo.expense_tracker.exceptions.InvalidCredentialsException;
import com.luizgmelo.expense_tracker.exceptions.UserNotFoundException;
import com.luizgmelo.expense_tracker.models.User;
import com.luizgmelo.expense_tracker.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public User findUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }

    public void register(RegisterDto registerDto) {
        String passwordHashed = passwordEncoder.encode(registerDto.password());

        if (userRepository.findByEmail(registerDto.email()) != null) {
            return;
        }

        User user = new User();
        user.setName(registerDto.name());
        user.setEmail(registerDto.email());
        user.setPassword(passwordHashed);

        userRepository.save(user);
    }

    public TokenDto login(LoginDto loginDto) {
        User user = userRepository.findByEmail(loginDto.email());

        if (user == null || !passwordEncoder.matches(loginDto.password(), user.getPassword())) {
            throw new InvalidCredentialsException("Credenciais inválidas");
        }

        return new TokenDto(tokenService.generateToken(user));
    }
}
