package com.international.money.transfer.domain.valueObjects;

public record Cnpj(String value) implements Document {

  public Cnpj {
    if (value == null || value.trim().isEmpty()) {
      throw new IllegalArgumentException("CNPJ should not be empty");
    }
    if (!value.matches("\\d{14}")) {
      throw new IllegalArgumentException("CNPJ is invalid: document should be 11 characters");
    }
  }

  @Override
  public String getValue() {
    return value;
  }
}
