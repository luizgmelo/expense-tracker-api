package com.luizgmelo.expense_tracker.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto(
        @NotBlank(message = "O campo e-mail não pode estar em branco")
        @Email(message = "O formato do e-mail é inválido")
        String email,

        @NotBlank(message = "O campo senha não pode estar em branco")
        @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
        String password) {
}
