package com.international.money.transfer.domain.mappers;

import com.international.money.transfer.domain.entities.User;
import com.international.money.transfer.domain.factories.DocumentFactory;
import com.international.money.transfer.domain.valueObjects.Email;
import com.international.money.transfer.infrastructure.entities.UserEntity;

public class UserMapper {
  public static User toDomain(UserEntity entity) {
    return new User(
        entity.getId(),
        entity.getName(),
        entity.getPassword(),
        entity.getUserType(),
        entity.getStatus(),
        new Email(entity.getEmail()),
        DocumentFactory.create(entity.getDocument(), entity.getUserType()),
        entity.getCreatedAt()
    );
  }

  public static UserEntity toEntity(User domain) {
    UserEntity entity = new UserEntity();
    entity.setId(domain.getId());
    entity.setName(domain.getName());
    entity.setPassword(domain.getPassword());
    entity.setUserType(domain.getUserType());
    entity.setStatus(domain.getStatus());
    entity.setEmail(domain.getEmail().value());
    entity.setDocument(domain.getDocument().getValue());
    entity.setCreatedAt(domain.getCreatedAt());
    return entity;
  }
}
