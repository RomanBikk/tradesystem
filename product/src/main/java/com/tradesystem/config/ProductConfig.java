package com.tradesystem.config;

import com.tradesystem.controller.ProductRestController;
import com.tradesystem.domain.DefaultAppLogService;
import com.tradesystem.domain.DefaultProductService;
import com.tradesystem.domain.ProductRepository;
import com.tradesystem.domain.ProductService;
import com.tradesystem.repository.JpaAppLogRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@Import(AuthConfig.class)
public class ProductConfig {

    private final ProductRepository productRepository;
    private final DefaultAppLogService defaultAppLogService;


    public ProductConfig(ProductRepository productRepository, DefaultAppLogService defaultAppLogService) {
        this.productRepository = productRepository;
        this.defaultAppLogService = defaultAppLogService;

    }



    @Bean
    ProductService productService() {
        return new DefaultProductService(productRepository, defaultAppLogService);
    }


    @Bean
    public ProductRestController productRestController() {
        return new ProductRestController(productService());
    }
}
