package com.tradesystem.domain;

import com.tradesystem.entity.ProductEntity;

import java.util.Optional;

public interface ProductRepository {
    Optional<ProductEntity> findById(Long id);
    ProductEntity save(ProductEntity product);
}
