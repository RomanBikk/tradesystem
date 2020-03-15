package com.tradesystem.repository;

import com.tradesystem.repository.entity.UserEntity;

import java.util.Optional;

public interface UserRepository {
    Optional<UserEntity> findUserByUsername(String username);
}
