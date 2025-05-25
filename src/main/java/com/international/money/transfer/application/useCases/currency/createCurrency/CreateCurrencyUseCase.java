package com.international.money.transfer.application.useCases.currency.createCurrency;

import com.international.money.transfer.application.interfaces.UseCase;
import com.international.money.transfer.domain.entities.Currency;
import com.international.money.transfer.domain.mappers.CurrencyMapper;
import com.international.money.transfer.infrastructure.entities.CurrencyEntity;
import com.international.money.transfer.infrastructure.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreateCurrencyUseCase implements UseCase<CreateCurrencyInput, Currency> {

  @Autowired
  private CurrencyRepository currencyRepository;

  @Override
  public Currency execute(CreateCurrencyInput input) {

    Currency entityDomain = new Currency(
        null,
        input.name(),
        input.code(),
        input.status(),
        LocalDateTime.now()
    );
    CurrencyEntity entity = CurrencyMapper.toEntity(entityDomain);
    currencyRepository.save(entity);
    return CurrencyMapper.toDomain(entity);
  }
}
