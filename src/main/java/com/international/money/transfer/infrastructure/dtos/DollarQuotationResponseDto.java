package com.international.money.transfer.infrastructure.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DollarQuotationResponseDto(
    @JsonProperty("value")
    List<PurchaseRateDto> purchaseRates) {
}
