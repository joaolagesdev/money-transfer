package com.international.money.transfer.infrastructure.repositories;

import com.international.money.transfer.infrastructure.entities.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, Long> {
  @Query(value = "SELECT COALESCE(SUM(t.transferred_value), 0) " +
      "FROM transfers t " +
      "JOIN wallets w ON t.source_wallet_id = w.id " +
      "WHERE w.user_id = :userId " +
      "AND t.created_at BETWEEN :start AND :end",
      nativeQuery = true)
  BigDecimal sumOfTransfersByUserAndDate(@Param("userId") Long userId,
                                         @Param("start") LocalDateTime start,
                                         @Param("end") LocalDateTime end);
}
