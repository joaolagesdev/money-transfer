package com.international.money.transfer.domain.valueObjects;

public record Cpf(String value) implements Document {

  public Cpf {
    if (value == null || value.trim().isEmpty()) {
      throw new IllegalArgumentException("CPF should not be empty");
    }
    if (!value.matches("\\d{11}")) {
      throw new IllegalArgumentException("CPF is invalid: document should be 11 characters");
    }
  }

  @Override
  public String getValue() {
    return value;
  }
}
