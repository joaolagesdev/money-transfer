package com.international.money.transfer.application.useCases.currency.createCurrency;

import com.international.money.transfer.application.interfaces.UseCase;
import com.international.money.transfer.domain.entities.Currency;
import com.international.money.transfer.domain.mappers.CurrencyMapper;
import com.international.money.transfer.infrastructure.entities.CurrencyEntity;
import com.international.money.transfer.infrastructure.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CreateCurrencyUseCase implements UseCase<CreateCurrencyInput, Currency> {

  @Autowired
  private CurrencyRepository currencyRepository;

  @Override
  public Currency execute(CreateCurrencyInput input) {
    CurrencyEntity entity = new CurrencyEntity();
    entity.setName(input.name());
    entity.setAbbreviation(input.abbreviation());
    entity.setStatus(input.status());
    entity.setCreatedAt(new Date());

    CurrencyEntity saved = currencyRepository.save(entity);
    return CurrencyMapper.toDomain(saved);
  }
}
