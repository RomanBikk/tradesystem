package com.tradesystem.controller;

import com.tradesystem.model.Order;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("rest/order")
public class OrderRestController {

    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public List<Order> findAll() {
        return Collections.singletonList(Order.builder().id(1).build());
    }
}
