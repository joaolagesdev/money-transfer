package com.international.money.transfer.domain.entities;

import com.international.money.transfer.domain.entities.base.DomainEntity;
import com.international.money.transfer.domain.enums.TransferStatus;

import java.math.BigDecimal;
import java.util.Date;

public class Transfer extends DomainEntity
{
  private Long id;
  private TransferStatus status;
  private Wallet sourceWallet;
  private Wallet targetWallet;
  private Date createdAt;
  private BigDecimal valueToTransfer;
  private BigDecimal transferredValue;
  private BigDecimal currencyQuote;
  private Date currencyQuoteDate;

  public Transfer(Long id, TransferStatus status, Wallet sourceWallet, Wallet targetWallet,
                  Date createdAt, BigDecimal valueToTransfer, BigDecimal transferredValue,
                  BigDecimal currencyQuote, Date currencyQuoteDate) {
    this.id = id;
    this.status = status;
    this.sourceWallet = sourceWallet;
    this.targetWallet = targetWallet;
    this.createdAt = createdAt;
    this.valueToTransfer = valueToTransfer;
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

  public Date getCreatedAt() {
    return createdAt;
  }

  public BigDecimal getValueToTransfer() {
    return valueToTransfer;
  }

  public BigDecimal getTransferredValue() {
    return transferredValue;
  }

  public BigDecimal getCurrencyQuote() {
    return currencyQuote;
  }

  public Date getCurrencyQuoteDate() {
    return currencyQuoteDate;
  }
}

