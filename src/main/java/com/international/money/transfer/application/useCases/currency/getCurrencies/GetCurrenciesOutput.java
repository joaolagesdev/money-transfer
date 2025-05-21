package com.international.money.transfer.application.useCases.currency.getCurrencies;

import com.international.money.transfer.domain.enums.Status;

import java.util.Date;

public record GetCurrenciesOutput (
    Short id,
    String name,
    String abbreviation,
    Status status,
    Date createdAt
) {}
