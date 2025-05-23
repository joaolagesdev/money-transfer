package com.international.money.transfer.controllers;


import com.international.money.transfer.application.useCases.user.createUser.CreateUserInput;
import com.international.money.transfer.application.useCases.user.createUser.CreateUserUseCase;
import com.international.money.transfer.application.useCases.user.getUsers.GetUsersUseCase;
import com.international.money.transfer.domain.entities.User;
import com.international.money.transfer.infrastructure.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private CreateUserUseCase createUseCase;

  @Autowired
  private GetUsersUseCase getUseCase;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<User> create(@RequestBody CreateUserInput request) {
    User user = this.createUseCase.execute(request);
    return ResponseEntity.ok(user);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<UserEntity>> getAll() {
    List<UserEntity> users = getUseCase.execute(null);
    return ResponseEntity.ok(users);
  }
}
