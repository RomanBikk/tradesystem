package com.tradesystem.repository;

import com.tradesystem.domain.UserDetailsRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public class UserDetailsRepositoryAdapter implements UserDetailsRepository {

    private final com.tradesystem.repository.UserRepository userRepository;

    public UserDetailsRepositoryAdapter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserDetails> findByUsername(String username) {
        return userRepository.findUserByUsername(username).map(UserConverter::convertToUser);
    }
}
