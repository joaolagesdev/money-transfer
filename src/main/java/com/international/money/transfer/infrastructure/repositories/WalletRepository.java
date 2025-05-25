package com.international.money.transfer.infrastructure.repositories;

import com.international.money.transfer.infrastructure.dtos.WalletQueryResponseDto;
import com.international.money.transfer.infrastructure.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, Long> {
  @Query("""
        SELECT new com.international.money.transfer.infrastructure.dtos.WalletQueryResponseDto(
            w.id, w.status, w.balance, w.createdAt, w.currency.id, w.user.id
        ) 
        FROM Wallet w
        """)
  List<WalletQueryResponseDto> findAllWallets();
}
