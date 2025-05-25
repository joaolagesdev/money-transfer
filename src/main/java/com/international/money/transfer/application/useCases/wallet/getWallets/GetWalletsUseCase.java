package com.international.money.transfer.application.useCases.wallet.getWallets;

import com.international.money.transfer.application.interfaces.UseCase;
import com.international.money.transfer.infrastructure.dtos.WalletQueryResponseDto;
import com.international.money.transfer.infrastructure.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetWalletsUseCase implements UseCase<Void, List<WalletQueryResponseDto>> {

  @Autowired
  WalletRepository walletRepository;

  @Override
  public List<WalletQueryResponseDto> execute(Void unused) {
    return walletRepository.findAllWallets();
  }
}
