package com.international.money.transfer.infrastructure.entities;

import com.international.money.transfer.domain.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "Currency")
@Table(name = "currencies")
public class CurrencyEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Short id;

  @Column(nullable = false, length = 30)
  private String name;

  @Column(nullable = false, length = 5, unique = true)
  private String code;

  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private Status status;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }
}
