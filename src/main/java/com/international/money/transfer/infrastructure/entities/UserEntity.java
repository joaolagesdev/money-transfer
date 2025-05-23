package com.international.money.transfer.infrastructure.entities;

import com.international.money.transfer.domain.enums.UserType;
import com.international.money.transfer.domain.enums.Status;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "User")
@Table(name = "users")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false)
  private String password;

  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private UserType userType;

  @Enumerated(EnumType.ORDINAL)
  @Column(nullable = false)
  private Status status;

  @Column(length = 50, unique = true)
  private String email;

  @Column(length = 50, unique = true)
  private String document;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<WalletEntity> wallets;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDocument() {
    return document;
  }

  public void setDocument(String document) {
    this.document = document;
  }

  public List<WalletEntity> getWallets() {
    return wallets;
  }

  public void setWallets(List<WalletEntity> wallets) {
    this.wallets = wallets;
  }
}
