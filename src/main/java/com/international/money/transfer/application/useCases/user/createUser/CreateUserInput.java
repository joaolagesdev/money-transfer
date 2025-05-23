package com.international.money.transfer.application.useCases.user.createUser;

import com.international.money.transfer.domain.enums.Status;
import com.international.money.transfer.domain.enums.UserType;

public record CreateUserInput(
    String name,
    String password,
    String email,
    String document,
    UserType userType,
    Status status
) {}
