package com.international.money.transfer.infrastructure.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.international.money.transfer.domain.enums.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity(name = "Wallet")
@Table(name = "wallets", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"currency_id", "user_id"})
})
public class WalletEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private Status status;

  @Column(nullable = false, precision = 15, scale = 2)
  private BigDecimal balance;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @ManyToOne
  @JoinColumn(name = "currency_id", nullable = false)
  private CurrencyEntity currency;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user;

  @OneToMany(mappedBy = "targetWallet")
  private List<TransferEntity> transfersReceived;

  @OneToMany(mappedBy = "sourceWallet")
  private List<TransferEntity> transferSent;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public CurrencyEntity getCurrency() {
    return currency;
  }

  public void setCurrency(CurrencyEntity currency) {
    this.currency = currency;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public List<TransferEntity> getTransfersReceived() {
    return transfersReceived;
  }

  public void setTransfersReceived(List<TransferEntity> transfersReceived) {
    this.transfersReceived = transfersReceived;
  }

  public List<TransferEntity> getTransferSent() {
    return transferSent;
  }

  public void setTransferSent(List<TransferEntity> transferSent) {
    this.transferSent = transferSent;
  }
}
