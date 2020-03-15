package com.tradesystem.domain;

import com.tradesystem.entity.AppLogEntity;
import com.tradesystem.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;

import org.apache.tomcat.websocket.AuthenticationException;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;
    private final DefaultAppLogService defaultAppLogService;
    @Autowired
    private EntityManager entityManager;


    public DefaultProductService(ProductRepository productRepository, DefaultAppLogService defaultAppLogService) {
        this.productRepository = productRepository;
        this.defaultAppLogService = defaultAppLogService;

    }

      @Override
    public Optional<Product> findById(long id) {
        return productRepository.findById(id).map(this::convertToProduct);
    }

    @Transactional
    @Override
    public Product save(Product product) throws AuthenticationException {


        Product returnedProduct=null;
       try {
            returnedProduct = convertToProduct(productRepository
                    .save(convertToProductEntity(product)));


            ProductEntity et = entityManager.find(ProductEntity.class,11);

           defaultAppLogService.save(AppLogEntity.builder()
                           .message(String.format("Product with id = %d has been saved",
                                   returnedProduct.getId()))
                           .build()
                   );

       }
       catch (Exception e) {
           throw e;
       }
       //if(true) throw new RuntimeException("");
        return returnedProduct;
    }

    private ProductEntity convertToProductEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .name(product.getName())
                .build();
    }

    private Product convertToProduct(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .build();
    }
}
