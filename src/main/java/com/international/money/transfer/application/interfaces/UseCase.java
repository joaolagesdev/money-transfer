package com.international.money.transfer.application.interfaces;

public interface UseCase<Input, Output> {
  Output execute (Input input);
}
