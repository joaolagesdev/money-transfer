package com.international.money.transfer.infrastructure.repositories;

import com.international.money.transfer.infrastructure.entities.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Short> {
}
