package com.international.money.transfer.application.useCases.wallet.getWallets;

import com.international.money.transfer.application.interfaces.UseCase;
import com.international.money.transfer.infrastructure.entities.WalletEntity;
import com.international.money.transfer.infrastructure.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetWalletsUseCase implements UseCase<Void, List<WalletEntity>> {

  @Autowired
  WalletRepository walletRepository;

  @Override
  public List<WalletEntity> execute(Void unused) {
    return walletRepository.findAll();
  }
}
