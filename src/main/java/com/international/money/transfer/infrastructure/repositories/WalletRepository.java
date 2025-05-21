package com.international.money.transfer.infrastructure.repositories;

import com.international.money.transfer.infrastructure.entities.WalletEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletEntity, Short> {
}
