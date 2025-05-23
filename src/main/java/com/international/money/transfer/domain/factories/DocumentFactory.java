package com.international.money.transfer.domain.factories;

import com.international.money.transfer.domain.enums.UserType;
import com.international.money.transfer.domain.valueObjects.Cnpj;
import com.international.money.transfer.domain.valueObjects.Cpf;
import com.international.money.transfer.domain.valueObjects.Document;

public class DocumentFactory {
  public static Document create(String value, UserType type) {
    return switch (type) {
      case PF -> new Cpf(value);
      case PJ -> new Cnpj(value);
    };
  }
}
