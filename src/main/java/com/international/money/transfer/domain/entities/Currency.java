package com.international.money.transfer.domain.entities;

import com.international.money.transfer.domain.entities.base.DomainEntity;
import com.international.money.transfer.domain.enums.Status;

import java.util.Date;

public class Currency extends DomainEntity {
  private Short id;
  private String name;
  private String abbreviation;
  private Status status;
  private Date createdAt;

  public Currency(Short id, String name, String abbreviation, Status status, Date createdAt) {
    this.id = id;
    this.name = name;
    this.abbreviation = abbreviation;
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
}
