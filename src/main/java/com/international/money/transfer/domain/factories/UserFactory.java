package com.international.money.transfer.domain.factories;

import com.international.money.transfer.domain.entities.User;
import com.international.money.transfer.domain.enums.UserType;
import com.international.money.transfer.domain.enums.Status;
import com.international.money.transfer.domain.valueObjects.Document;
import com.international.money.transfer.domain.valueObjects.Email;

public class UserFactory {

  public static User create(String name,
                            String password,
                            UserType userType,
                            Status status,
                            String document,
                            String email) {

    Document createdDocument = DocumentFactory.create(document, userType);
    Email createdEmail = new Email(email);

    return new User(
        null,
        name,
        password,
        userType,
        status,
        createdEmail,
        createdDocument
    );
  }
}
