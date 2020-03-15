package com.tradesystem.repository;

import com.tradesystem.domain.DefaultUserDetails;
import com.tradesystem.repository.entity.UserEntity;
import com.tradesystem.repository.entity.UserRoleEntity;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserConverter {
    public static UserDetails convertToUser(UserEntity userEntity) {
        return new DefaultUserDetails(
                userEntity.getUsername(),
                userEntity.getPassword(),
                Optional.ofNullable(userEntity.getRoles())
                        .stream()
                        .flatMap(Collection::stream)
                        .map(UserRoleEntity::getRole)
                        .collect(Collectors.toSet())
        );
    }
}
