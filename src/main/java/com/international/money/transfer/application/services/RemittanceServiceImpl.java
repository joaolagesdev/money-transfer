package com.international.money.transfer.application.services;

import com.international.money.transfer.infrastructure.http.BcbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class RemittanceServiceImpl implements RemittanceService {

  @Autowired
  private BcbService currencyService;

  public Remittance create(BigDecimal amount) {
//    BigDecimal dollarQuotation = currencyService.getDollarQuotationByDate(LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy")));
//
//    if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
//      throw new IllegalArgumentException("Value must be greater than zero");
//    }
    var dollarQuotation = new BigDecimal("5.2345");
    var amountConvertToDollars = amount.divide(dollarQuotation , 2, RoundingMode.HALF_UP);
    return new Remittance(amountConvertToDollars, dollarQuotation);
  }
}
