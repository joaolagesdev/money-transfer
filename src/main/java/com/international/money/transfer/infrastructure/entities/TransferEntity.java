package com.international.money.transfer.infrastructure.entities;

import com.international.money.transfer.domain.enums.TransferStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transfer")
@Table(name = "transfers", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"source_wallet_id", "target_wallet_id", "created_at"})
})
public class TransferEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private TransferStatus status;

  @ManyToOne
  @JoinColumn(name = "source_wallet_id", nullable = false)
  private WalletEntity sourceWallet;

  @ManyToOne
  @JoinColumn(name = "target_wallet_id", nullable = false)
  private WalletEntity targetWallet;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @Column(precision = 15, scale = 2)
  private BigDecimal valueToTransfer;

  @Column(precision = 15, scale = 2)
  private BigDecimal transferredValue;

  @Column(precision = 15, scale = 2)
  private BigDecimal currencyQuote;

  @Column(name = "currency_quote_date", nullable = false)
  private LocalDateTime currencyQuoteDate;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TransferStatus getStatus() {
    return status;
  }

  public void setStatus(TransferStatus status) {
    this.status = status;
  }

  public WalletEntity getSourceWallet() {
    return sourceWallet;
  }

  public void setSourceWallet(WalletEntity sourceWallet) {
    this.sourceWallet = sourceWallet;
  }

  public WalletEntity getTargetWallet() {
    return targetWallet;
  }

  public void setTargetWallet(WalletEntity targetWallet) {
    this.targetWallet = targetWallet;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public BigDecimal getValueToTransfer() {
    return valueToTransfer;
  }

  public void setValueToTransfer(BigDecimal valueToTransfer) {
    this.valueToTransfer = valueToTransfer;
  }

  public BigDecimal getTransferredValue() {
    return transferredValue;
  }

  public void setTransferredValue(BigDecimal transferredValue) {
    this.transferredValue = transferredValue;
  }

  public BigDecimal getCurrencyQuote() {
    return currencyQuote;
  }

  public void setCurrencyQuote(BigDecimal currencyQuote) {
    this.currencyQuote = currencyQuote;
  }

  public LocalDateTime getCurrencyQuoteDate() {
    return currencyQuoteDate;
  }

  public void setCurrencyQuoteDate(LocalDateTime currencyQuoteDate) {
    this.currencyQuoteDate = currencyQuoteDate;
  }
}
