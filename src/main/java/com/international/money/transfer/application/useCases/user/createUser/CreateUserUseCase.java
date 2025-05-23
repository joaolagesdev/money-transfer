package com.international.money.transfer.application.useCases.user.createUser;

import com.international.money.transfer.application.interfaces.UseCase;
import com.international.money.transfer.domain.entities.User;
import com.international.money.transfer.domain.enums.UserType;
import com.international.money.transfer.domain.factories.UserFactory;
import com.international.money.transfer.domain.mappers.UserMapper;
import com.international.money.transfer.infrastructure.entities.UserEntity;
import com.international.money.transfer.infrastructure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase implements UseCase<CreateUserInput, User> {

  @Autowired
  private UserRepository repository;

  @Override
  public User execute(CreateUserInput input) {
    User user = UserFactory.create(
        input.name(),
        input.password(),
        input.userType(),
        input.status(),
        input.document(),
        input.email()
    );

    UserEntity entity = new UserEntity();
    entity.setName(user.getName());
    entity.setPassword(user.getPassword());
    entity.setEmail(user.getEmail().value());
    entity.setDocument(user.getDocument().getValue());
    entity.setUserType(user.getUserType());
    entity.setStatus(user.getStatus());

    repository.save(entity);

    return UserMapper.toDomain(entity);
  }
}
