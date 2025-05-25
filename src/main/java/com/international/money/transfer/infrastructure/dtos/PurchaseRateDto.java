package com.international.money.transfer.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PurchaseRateDto(
    @JsonProperty("cotacaoCompra")
    BigDecimal purchaseRate,
    @JsonProperty("dataHoraCotacao")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    LocalDateTime currencyQuoteDate
) { }
