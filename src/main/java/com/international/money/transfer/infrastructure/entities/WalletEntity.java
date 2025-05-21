package com.international.money.transfer.infrastructure.entities;

import com.international.money.transfer.domain.enums.Status;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity(name = "Wallet")
@Table(name = "wallets", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"currency_id", "person_id"})
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

  @Temporal(TemporalType.DATE)
  @Column(name = "created_at", nullable = false)
  private Date createdAt;

  @ManyToOne
  @JoinColumn(name = "currency_id", nullable = false)
  private CurrencyEntity currency;

  @ManyToOne
  @JoinColumn(name = "person_id", nullable = false)
  private PersonEntity person;

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

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public CurrencyEntity getCurrency() {
    return currency;
  }

  public void setCurrency(CurrencyEntity currency) {
    this.currency = currency;
  }

  public PersonEntity getPerson() {
    return person;
  }

  public void setPerson(PersonEntity person) {
    this.person = person;
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
