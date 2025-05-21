package com.international.money.transfer.domain.valueObjects;

import java.util.regex.Pattern;

public record Email(String value) {
  private static final Pattern VALIDATOR = Pattern.compile("^(.+)@(\\S+)$");

  public Email {
    if (value == null || value.trim().isEmpty()) {
      throw new IllegalArgumentException("Email should not be empty");
    }

    if (!VALIDATOR.matcher(value).matches()) {
      throw new IllegalArgumentException("Email is invalid");
    }
  }
}
