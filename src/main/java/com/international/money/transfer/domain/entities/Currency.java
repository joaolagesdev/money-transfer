package com.international.money.transfer.domain.entities;

import com.international.money.transfer.domain.entities.base.DomainEntity;
import com.international.money.transfer.domain.enums.Status;

import java.time.LocalDateTime;

public class Currency extends DomainEntity {
  private Short id;
  private String name;
  private String code;
  private Status status;
  private LocalDateTime createdAt;

  public Currency(Short id, String name, String code, Status status, LocalDateTime createdAt) {
    this.id = id;
    this.name = name;
    this.code = code;
    this.status = status;
    this.createdAt = createdAt;
  }

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
