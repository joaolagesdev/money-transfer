package com.international.money.transfer.domain.entities;

import com.international.money.transfer.domain.entities.base.DomainEntity;
import com.international.money.transfer.domain.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class Wallet extends DomainEntity {
  private Long id;
  private Status status;
  private BigDecimal balance;
  private LocalDateTime createdAt;
  private Currency currency;
  private User user;

  public Wallet(Long id, Status status, BigDecimal balance, LocalDateTime createdAt,
                Currency currency, User user) {
    this.id = id;
    this.status = status;
    this.balance = balance;
    this.createdAt = createdAt;
    this.currency = currency;
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public Status getStatus() {
    return status;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public Currency getCurrency() {
    return currency;
  }

  public User getUser() {
    return user;
  }

  public void credit(BigDecimal amount) {
    this.balance = this.balance.add(amount);
  }

  public void debit(BigDecimal amount) {
    if (this.balance.compareTo(amount) < 0) {
      throw new IllegalArgumentException("Insufficient balance");
    }
    this.balance = this.balance.subtract(amount);
  }
}
