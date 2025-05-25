package com.international.money.transfer.domain.entities;

import com.international.money.transfer.domain.entities.base.DomainEntity;
import com.international.money.transfer.domain.enums.TransferStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class Transfer extends DomainEntity
{
  private final Long id;
  private final TransferStatus status;
  private final Wallet sourceWallet;
  private final Wallet targetWallet;
  private final LocalDateTime createdAt;
  private final BigDecimal transferAmount;
  private final BigDecimal transferredValue;
  private final BigDecimal currencyQuote;
  private final LocalDateTime currencyQuoteDate;

  public Transfer(Long id, TransferStatus status, Wallet sourceWallet, Wallet targetWallet,
                  LocalDateTime createdAt, BigDecimal transferAmount, BigDecimal transferredValue,
                  BigDecimal currencyQuote, LocalDateTime currencyQuoteDate) {
    this.id = id;
    this.status = status;
    this.sourceWallet = sourceWallet;
    this.targetWallet = targetWallet;
    this.createdAt = createdAt;
    this.transferAmount = transferAmount;
    this.transferredValue = transferredValue;
    this.currencyQuote = currencyQuote;
    this.currencyQuoteDate = currencyQuoteDate;
  }

  public Long getId() {
    return id;
  }

  public TransferStatus getStatus() {
    return status;
  }

  public Wallet getSourceWallet() {
    return sourceWallet;
  }

  public Wallet getTargetWallet() {
    return targetWallet;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public BigDecimal getValueToTransfer() {
    return transferAmount;
  }

  public BigDecimal getTransferredValue() {
    return transferredValue;
  }

  public BigDecimal getCurrencyQuote() {
    return currencyQuote;
  }

  public LocalDateTime getCurrencyQuoteDate() {
    return currencyQuoteDate;
  }
}

