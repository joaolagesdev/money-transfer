package com.international.money.transfer.application.useCases.currency.createCurrency;

import com.international.money.transfer.domain.enums.Status;

public record CreateCurrencyInput(
    String name,
    String code,
    Status status
) { }
