package com.international.money.transfer.application.useCases.wallet.createWallet;

import com.international.money.transfer.domain.entities.Currency;
import com.international.money.transfer.domain.entities.User;
import com.international.money.transfer.domain.entities.Wallet;
import com.international.money.transfer.domain.enums.Status;
import com.international.money.transfer.domain.mappers.CurrencyMapper;
import com.international.money.transfer.domain.mappers.UserMapper;
import com.international.money.transfer.domain.mappers.WalletMapper;
import com.international.money.transfer.infrastructure.entities.CurrencyEntity;
import com.international.money.transfer.infrastructure.entities.UserEntity;
import com.international.money.transfer.infrastructure.repositories.CurrencyRepository;
import com.international.money.transfer.infrastructure.repositories.UserRepository;
import com.international.money.transfer.infrastructure.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

@Service
public class CreateWalletUseCase {

  @Autowired
  private WalletRepository walletRepository;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CurrencyRepository currencyRepository;

  public Wallet execute(CreateWalletInput input) {

    UserEntity user = userRepository.findById(input.userId())
        .orElseThrow(() -> new IllegalArgumentException("User not found"));

    CurrencyEntity currency = currencyRepository.findById(input.currencyId())
        .orElseThrow(() -> new IllegalArgumentException("Currency not found"));

    Wallet wallet = new Wallet(
        null,
        Status.valueOf(String.valueOf(input.status())),
        input.balance(),
        new Date(),
        CurrencyMapper.toDomain(currency),
        UserMapper.toDomain(user)
    );

    var entity = WalletMapper.toEntity(wallet);

    walletRepository.save(entity);

    return WalletMapper.toDomain(entity);
  }
}
