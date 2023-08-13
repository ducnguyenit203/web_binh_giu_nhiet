package com.example.demo.rest;

import com.example.demo.entity.Order;
import com.example.demo.service.impl.OrderDetailServiceImpl;
import com.example.demo.service.impl.OrderServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class OrderRestController {
    @Autowired
    private OrderServiceImpl orderService;

    @PostMapping("/rest/orders")
    public Order create(@RequestBody JsonNode orderData) {
        return orderService.create(orderData);
    }

    @GetMapping("/rest/ordersall")
    public List<Order> findAll() {
        return orderService.findAll();
    }
}
