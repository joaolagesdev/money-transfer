package com.international.money.transfer.application.useCases.wallet.createWallet;

import com.international.money.transfer.domain.enums.Status;

import java.math.BigDecimal;

public record CreateWalletInput(
    Long userId,
    Short currencyId,
    Status status,
    BigDecimal balance
) {}
