package com.international.money.transfer.controllers;

import com.international.money.transfer.application.useCases.wallet.createWallet.CreateWalletInput;
import com.international.money.transfer.application.useCases.wallet.createWallet.CreateWalletUseCase;
import com.international.money.transfer.application.useCases.wallet.getWallets.GetWalletsUseCase;
import com.international.money.transfer.domain.entities.Wallet;
import com.international.money.transfer.infrastructure.dtos.WalletQueryResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wallets")
public class WalletController {

  @Autowired
  private CreateWalletUseCase createWalletUseCase;

  @Autowired
  private GetWalletsUseCase getUseCase;
  @PostMapping
  public ResponseEntity<Wallet> create(@RequestBody CreateWalletInput input) {
    Wallet wallet = createWalletUseCase.execute(input);
    return ResponseEntity.ok(wallet);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<WalletQueryResponseDto>> getAll() {
    List<WalletQueryResponseDto> wallets = getUseCase.execute(null);
    return ResponseEntity.ok(wallets);
  }
}
