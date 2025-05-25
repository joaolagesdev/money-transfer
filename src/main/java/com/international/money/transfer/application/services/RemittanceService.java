package com.international.money.transfer.application.services;

import java.math.BigDecimal;

public interface RemittanceService {
  Remittance create(BigDecimal transferAmount);
}
