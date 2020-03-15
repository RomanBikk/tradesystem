package com.tradesystem.domain;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserDetailsRepository {
    Optional<UserDetails> findByUsername(String username);
}
