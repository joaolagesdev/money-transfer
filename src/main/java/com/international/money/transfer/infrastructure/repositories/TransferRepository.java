package com.international.money.transfer.infrastructure.repositories;

import com.international.money.transfer.infrastructure.entities.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<TransferEntity, Short> {
}
