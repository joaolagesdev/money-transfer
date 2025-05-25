package com.international.money.transfer.application.useCases.transfer.createTransfer;


import com.international.money.transfer.application.interfaces.UseCase;
import com.international.money.transfer.application.services.RemittanceService;
import com.international.money.transfer.domain.entities.Transfer;
import com.international.money.transfer.domain.entities.Wallet;
import com.international.money.transfer.domain.enums.TransferStatus;
import com.international.money.transfer.domain.enums.UserType;
import com.international.money.transfer.domain.mappers.TransferMapper;
import com.international.money.transfer.domain.mappers.WalletMapper;
import com.international.money.transfer.infrastructure.entities.WalletEntity;
import com.international.money.transfer.infrastructure.repositories.TransferRepository;
import com.international.money.transfer.infrastructure.repositories.WalletRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class CreateTransferUseCase implements UseCase<CreateTransferInput, Transfer> {

  @Autowired
  public TransferRepository transferRepository;

  @Autowired
  public WalletRepository walletRepository;

  @Autowired
  public RemittanceService remittanceService;

  @Override
  @Transactional
  public Transfer execute(CreateTransferInput input) {

    WalletEntity sourceWalletEntity = walletRepository.findById(input.sourceWalletId())
        .orElseThrow(() -> new EntityNotFoundException("Source wallet not found"));

    WalletEntity targetWalletEntity = walletRepository.findById(input.targetWalletId())
        .orElseThrow(() -> new EntityNotFoundException("Target wallet not found"));

    var sourceWallet = WalletMapper.toDomain(sourceWalletEntity);
    var targetWallet = WalletMapper.toDomain(targetWalletEntity);

    validateSourceWalletBalance(input, sourceWallet);
    validateLimitTransfer(input, sourceWallet);

    var remittance = remittanceService.create(input.transferAmount());

    var transfer = new Transfer(
        null,
        TransferStatus.COMPLETED,
        sourceWallet,
        targetWallet,
        LocalDateTime.now(),
        input.transferAmount(),
        remittance.convertedAmount(),
        remittance.purchaseRate(),
        LocalDateTime.now());

    var transferEntity = TransferMapper.toEntity(transfer);

    sourceWallet.debit(input.transferAmount());
    targetWallet.credit(input.transferAmount());
    walletRepository.save(WalletMapper.toEntity(sourceWallet));
    walletRepository.save(WalletMapper.toEntity(targetWallet));
    transferRepository.save(transferEntity);

    return TransferMapper.toDomain(transferEntity);
  }

  private void validateSourceWalletBalance(CreateTransferInput input, Wallet sourceWallet) {
    if (sourceWallet.getBalance().compareTo(input.transferAmount()) < 0) {
      throw new IllegalArgumentException("Insufficient balance");
    }
  }

  private void validateLimitTransfer(CreateTransferInput input, Wallet sourceWallet) {
    var today = LocalDate.now();

    var totalTransferredToday = transferRepository
        .sumOfTransfersByUserAndDate(sourceWallet.getUser().getId(), today.atStartOfDay(), today.atTime(LocalTime.MAX));

    if (sourceWallet.getUser().getUserType() == UserType.PF & totalTransferredToday.add(input.transferAmount()).compareTo(BigDecimal.valueOf(10000)) > 0) {
      throw new IllegalArgumentException("Daily transfer limit exceeded for PF");
    }

    if (sourceWallet.getUser().getUserType() == UserType.PJ & totalTransferredToday.add(input.transferAmount()).compareTo(BigDecimal.valueOf(50000)) > 0) {
      throw new IllegalArgumentException("Daily transfer limit exceeded for PJ");
    }
  }
}

