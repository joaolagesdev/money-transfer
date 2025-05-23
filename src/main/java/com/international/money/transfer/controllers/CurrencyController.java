package com.international.money.transfer.controllers;

import com.international.money.transfer.application.useCases.currency.createCurrency.CreateCurrencyInput;
import com.international.money.transfer.application.useCases.currency.createCurrency.CreateCurrencyUseCase;
import com.international.money.transfer.application.useCases.currency.getCurrencies.GetCurrenciesUseCase;
import com.international.money.transfer.domain.entities.Currency;
import com.international.money.transfer.infrastructure.entities.CurrencyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

  @Autowired
  private CreateCurrencyUseCase createUseCase;

  @Autowired
  private GetCurrenciesUseCase getUseCase;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<Currency> create(@RequestBody CreateCurrencyInput request) {
    Currency currency = this.createUseCase.execute(request);
    return ResponseEntity.ok(currency);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<CurrencyEntity>> getAll() {
    List<CurrencyEntity> currencies = getUseCase.execute(null);
    return ResponseEntity.ok(currencies);
  }
}
