package com.international.money.transfer.infrastructure.entities;

import com.international.money.transfer.domain.enums.Status;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity(name = "Currency")
@Table(name = "currencies")
public class CurrencyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Short id;

  @Column(nullable = false, length = 30)
  private String name;

  @Column(nullable = false, length = 5, unique = true)
  private String abbreviation;

  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private Status status;

  @Temporal(TemporalType.DATE)
  @Column(name = "created_at", nullable = false)
  private Date createdAt;

  @OneToMany(mappedBy = "currency")
  private List<WalletEntity> wallets;

  public Short getId() {
    return id;
  }

  public void setId(Short id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public List<WalletEntity> getWallets() {
    return wallets;
  }

  public void setWallets(List<WalletEntity> wallets) {
    this.wallets = wallets;
  }
}
