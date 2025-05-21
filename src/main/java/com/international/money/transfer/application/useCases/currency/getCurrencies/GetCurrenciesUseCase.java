package com.international.money.transfer.application.useCases.currency.getCurrencies;

import com.international.money.transfer.application.interfaces.UseCase;
import com.international.money.transfer.infrastructure.entities.CurrencyEntity;
import com.international.money.transfer.infrastructure.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCurrenciesUseCase implements UseCase<Void, List<CurrencyEntity>> {

  @Autowired
  private CurrencyRepository repository;

  @Override
  public List<CurrencyEntity> execute(Void input) {
    return repository.findAll();
  }
}
