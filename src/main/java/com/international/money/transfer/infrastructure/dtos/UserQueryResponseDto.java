package com.international.money.transfer.infrastructure.dtos;

import com.international.money.transfer.domain.enums.Status;
import com.international.money.transfer.domain.enums.UserType;

import java.time.LocalDateTime;

public record UserQueryResponseDto(
    Long id,
    String name,
    UserType userType,
    Status status,
    String email,
    String document,
    LocalDateTime createdAt
) {}