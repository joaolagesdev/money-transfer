package com.international.money.transfer.infrastructure.repositories;

import com.international.money.transfer.infrastructure.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
