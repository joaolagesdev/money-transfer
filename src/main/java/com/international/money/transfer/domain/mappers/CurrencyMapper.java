package com.international.money.transfer.domain.mappers;

import com.international.money.transfer.domain.entities.Currency;
import com.international.money.transfer.infrastructure.entities.CurrencyEntity;

public class CurrencyMapper {

  public static Currency toDomain(CurrencyEntity entity) {
    return new Currency(
        entity.getId(),
        entity.getName(),
        entity.getAbbreviation(),
        entity.getStatus(),
        entity.getCreatedAt()
    );
  }

  public static CurrencyEntity toEntity(Currency domain) {
    CurrencyEntity entity = new CurrencyEntity();
    entity.setId(domain.getId());
    entity.setName(domain.getName());
    entity.setAbbreviation(domain.getAbbreviation());
    entity.setStatus(domain.getStatus());
    entity.setCreatedAt(domain.getCreatedAt());
    return entity;
  }
}
