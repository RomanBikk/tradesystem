package com.tradesystem.repository;

import com.tradesystem.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<UserEntity, Long>, UserRepository {
    @Override
    Optional<UserEntity> findUserByUsername(String username);
}
