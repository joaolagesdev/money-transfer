package com.international.money.transfer.application.services;

import java.math.BigDecimal;

public record Remittance(BigDecimal convertedAmount, BigDecimal purchaseRate) {
}