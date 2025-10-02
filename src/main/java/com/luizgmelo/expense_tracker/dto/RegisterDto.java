package com.luizgmelo.expense_tracker.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record RegisterDto(@Size(min = 4, message = "O nome deve ter no mínimo 4 caracteres") String name,
                          @Email(message = "O e-mail é inválido") String email,
                          @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres") String password) {
}
