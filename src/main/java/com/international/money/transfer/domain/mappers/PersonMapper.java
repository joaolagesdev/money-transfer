package com.international.money.transfer.domain.mappers;

import com.international.money.transfer.domain.entities.Person;
import com.international.money.transfer.domain.factories.DocumentFactory;
import com.international.money.transfer.domain.valueObjects.Email;
import com.international.money.transfer.infrastructure.entities.PersonEntity;

public class PersonMapper {
  public static Person toDomain(PersonEntity entity) {
    return new Person(
        entity.getId(),
        entity.getName(),
        entity.getPassword(),
        entity.getPersonType(),
        entity.getStatus(),
        new Email(entity.getEmail()),
        DocumentFactory.create(entity.getDocument(), entity.getPersonType())
    );
  }

  public static PersonEntity toEntity(Person domain) {
    PersonEntity entity = new PersonEntity();
    entity.setId(domain.getId());
    entity.setName(domain.getName());
    entity.setPassword(domain.getPassword());
    entity.setPersonType(domain.getPersonType());
    entity.setStatus(domain.getStatus());
    entity.setEmail(domain.getEmail().value());
    entity.setDocument(domain.getDocument().getValue());
    return entity;
  }
}
