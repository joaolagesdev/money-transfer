package com.international.money.transfer.domain.mappers;

import com.international.money.transfer.domain.entities.Wallet;
import com.international.money.transfer.infrastructure.entities.WalletEntity;

public class WalletMapper {

  public static Wallet toDomain(WalletEntity entity) {
    return new Wallet(
        entity.getId(),
        entity.getStatus(),
        entity.getBalance(),
        entity.getCreatedAt(),
        CurrencyMapper.toDomain(entity.getCurrency()),
        PersonMapper.toDomain(entity.getPerson())
    );
  }

  public static WalletEntity toEntity(Wallet domain) {
    WalletEntity entity = new WalletEntity();
    entity.setId(domain.getId());
    entity.setStatus(domain.getStatus());
    entity.setBalance(domain.getBalance());
    entity.setCreatedAt(domain.getCreatedAt());
    entity.setCurrency(CurrencyMapper.toEntity(domain.getCurrency()));
    entity.setPerson(PersonMapper.toEntity(domain.getPerson()));
    return entity;
  }
}
