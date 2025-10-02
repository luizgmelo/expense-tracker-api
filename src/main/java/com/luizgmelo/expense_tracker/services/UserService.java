package com.luizgmelo.expense_tracker.services;

import com.luizgmelo.expense_tracker.dto.RegisterDto;
import com.luizgmelo.expense_tracker.dto.UserDto;
import com.luizgmelo.expense_tracker.models.User;
import com.luizgmelo.expense_tracker.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto register(RegisterDto registerDto) {
        String passwordHashed = passwordEncoder.encode(registerDto.password());

        User user = new User();
        user.setName(registerDto.name());
        user.setEmail(registerDto.email());
        user.setPassword(passwordHashed);

        User userSaved = userRepository.save(user);
        return new UserDto(userSaved.getId(), userSaved.getName(), user.getEmail());
    }
}
