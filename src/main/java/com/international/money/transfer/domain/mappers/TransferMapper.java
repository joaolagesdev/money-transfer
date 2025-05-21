package com.international.money.transfer.domain.mappers;

import com.international.money.transfer.domain.entities.Transfer;
import com.international.money.transfer.infrastructure.entities.TransferEntity;

public class TransferMapper {

  public static Transfer toDomain(TransferEntity entity) {
    return new Transfer(
        entity.getId(),
        entity.getStatus(),
        WalletMapper.toDomain(entity.getSourceWallet()),
        WalletMapper.toDomain(entity.getTargetWallet()),
        entity.getCreatedAt(),
        entity.getValueToTransfer(),
        entity.getTransferredValue(),
        entity.getCurrencyQuote(),
        entity.getCurrencyQuoteDate()
    );
  }

  public static TransferEntity toEntity(Transfer domain) {
    TransferEntity entity = new TransferEntity();
    entity.setId(domain.getId());
    entity.setStatus(domain.getStatus());
    entity.setSourceWallet(WalletMapper.toEntity(domain.getSourceWallet()));
    entity.setTargetWallet(WalletMapper.toEntity(domain.getTargetWallet()));
    entity.setCreatedAt(domain.getCreatedAt());
    entity.setValueToTransfer(domain.getValueToTransfer());
    entity.setTransferredValue(domain.getTransferredValue());
    entity.setCurrencyQuote(domain.getCurrencyQuote());
    entity.setCurrencyQuoteDate(domain.getCurrencyQuoteDate());
    return entity;
  }
}
