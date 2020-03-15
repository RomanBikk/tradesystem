package com.tradesystem.controller;

import com.tradesystem.domain.Product;
import com.tradesystem.domain.ProductService;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.PermitAll;

@RequestMapping("rest/product")
@ResponseBody
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    //@PreAuthorize("isAuthenticated()")
    @Secured("ROLE_USER")
    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        return productService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(this::createNotFoundResponse);
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public Product save(@RequestBody Product product) throws AuthenticationException {
        return productService.save(product);
    }

    private ResponseEntity<Product> createNotFoundResponse() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
