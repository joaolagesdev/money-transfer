package com.international.money.transfer.infrastructure.entities;

import com.international.money.transfer.domain.enums.TransferStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

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

  @Temporal(TemporalType.DATE)
  @Column(name = "created_at", nullable = false)
  private Date CreatedAt;

  @Column(precision = 15, scale = 2)
  private BigDecimal valueToTransfer;

  @Column(precision = 15, scale = 2)
  private BigDecimal transferredValue;

  @Column(precision = 15, scale = 2)
  private BigDecimal currencyQuote;

  @Temporal(TemporalType.DATE)
  @Column(name = "currency_quote_date", nullable = false)
  private Date CurrencyQuoteDate;

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

  public Date getCreatedAt() {
    return CreatedAt;
  }

  public void setCreatedAt(Date createdAt) {
    CreatedAt = createdAt;
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

  public Date getCurrencyQuoteDate() {
    return CurrencyQuoteDate;
  }

  public void setCurrencyQuoteDate(Date currencyQuoteDate) {
    CurrencyQuoteDate = currencyQuoteDate;
  }
}
