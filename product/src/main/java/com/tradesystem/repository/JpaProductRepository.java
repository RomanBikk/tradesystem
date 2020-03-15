package com.tradesystem.repository;

import com.tradesystem.domain.ProductRepository;
import com.tradesystem.entity.ProductEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

interface JpaProductRepository extends JpaRepository<ProductEntity, Long>, ProductRepository {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    @Override
    Optional<ProductEntity> findById(Long id);
}
