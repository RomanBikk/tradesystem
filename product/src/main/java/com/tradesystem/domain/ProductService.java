package com.tradesystem.domain;

import org.apache.tomcat.websocket.AuthenticationException;
import java.util.Optional;

public interface ProductService {
    Optional<Product> findById(long id);
    Product save(Product product) throws AuthenticationException;
}
