package com.international.money.transfer.application.useCases.user.getUsers;

import com.international.money.transfer.application.interfaces.UseCase;
import com.international.money.transfer.infrastructure.dtos.UserQueryResponseDto;
import com.international.money.transfer.infrastructure.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUsersUseCase implements UseCase<Void, List<UserQueryResponseDto>> {

  @Autowired
  private UserRepository repository;

  @Override
  public List<UserQueryResponseDto> execute(Void input) {
    return repository.findAllUsers();
  }
}