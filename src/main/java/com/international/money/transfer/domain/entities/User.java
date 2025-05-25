package com.international.money.transfer.domain.entities;

import com.international.money.transfer.domain.entities.base.DomainEntity;
import com.international.money.transfer.domain.enums.UserType;
import com.international.money.transfer.domain.enums.Status;
import com.international.money.transfer.domain.valueObjects.Document;
import com.international.money.transfer.domain.valueObjects.Email;

import java.time.LocalDateTime;

public class User extends DomainEntity {
  private Long id;
  private String name;
  private String password;
  private UserType userType;
  private Status status;
  private Email email;
  private Document document;
  private LocalDateTime createdAt;

  public User(
      Long id,
      String name,
      String password,
      UserType userType,
      Status status,
      Email email,
      Document document,
      LocalDateTime createdAt) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.userType = userType;
    this.status = status;
    this.email = email;
    this.document = document;
    this.createdAt = createdAt;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserType getUserType() {
    return userType;
  }

  public void setUserType(UserType userType) {
    this.userType = userType;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Email getEmail() {
    return email;
  }

  public void setEmail(Email email) {
    this.email = email;
  }

  public Document getDocument() {
    return document;
  }

  public void setDocument(Document document) {
    this.document = document;
  }
}
