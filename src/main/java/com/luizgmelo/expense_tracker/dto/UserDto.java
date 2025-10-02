package com.luizgmelo.expense_tracker.dto;

import java.util.UUID;

public record UserDto(UUID id, String name, String email) {}
