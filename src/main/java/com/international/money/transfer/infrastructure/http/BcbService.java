package com.international.money.transfer.infrastructure.http;

import java.math.BigDecimal;

public interface BcbService {
  BigDecimal getDollarQuotationByDate(String date);
}
