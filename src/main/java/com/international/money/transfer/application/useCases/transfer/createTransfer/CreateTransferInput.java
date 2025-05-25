package com.international.money.transfer.application.useCases.transfer.createTransfer;

import java.math.BigDecimal;

public record CreateTransferInput(
    Long sourceWalletId,
    Long targetWalletId,
    BigDecimal transferAmount
) {}

