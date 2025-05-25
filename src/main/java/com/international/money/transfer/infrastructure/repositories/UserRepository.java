package com.international.money.transfer.infrastructure.repositories;

import com.international.money.transfer.infrastructure.dtos.UserQueryResponseDto;
import com.international.money.transfer.infrastructure.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  @Query("""
    SELECT new com.international.money.transfer.infrastructure.dtos.UserQueryResponseDto(
        u.id, u.name, u.userType, u.status, u.email, u.document, u.createdAt
    )
    FROM User u
    """)
  List<UserQueryResponseDto> findAllUsers();
}
