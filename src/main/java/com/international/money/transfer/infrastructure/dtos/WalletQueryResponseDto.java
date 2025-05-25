package com.international.money.transfer.infrastructure.dtos;

import com.international.money.transfer.domain.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record WalletQueryResponseDto(
    Long id,
    Status status,
    BigDecimal balance,
    LocalDateTime createdAt,
    Short currencyId,
    Long userId
) {
}
