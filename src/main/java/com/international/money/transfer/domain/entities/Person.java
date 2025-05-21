package com.international.money.transfer.domain.entities;

import com.international.money.transfer.domain.entities.base.DomainEntity;
import com.international.money.transfer.domain.enums.PersonType;
import com.international.money.transfer.domain.enums.Status;
import com.international.money.transfer.domain.valueObjects.Document;
import com.international.money.transfer.domain.valueObjects.Email;

import javax.print.Doc;

public class Person extends DomainEntity {
  private Long id;
  private String name;
  private String password;
  private PersonType personType;
  private Status status;
  private Email email;
  private Document document;

  public Person(
      Long id,
      String name,
      String password,
      PersonType personType,
      Status status,
      Email email,
      Document document) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.personType = personType;
    this.status = status;
    this.email = email;
    this.document = document;
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

  public PersonType getPersonType() {
    return personType;
  }

  public void setPersonType(PersonType personType) {
    this.personType = personType;
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
