package com.example.demo.service.impl;

import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderDetailService;
import com.example.demo.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public Order create(JsonNode orderData) {
        ObjectMapper mapper=new ObjectMapper();
        Order order=mapper.convertValue(orderData, Order.class);
        repository.save(order);

        TypeReference<List<OrderDetail>> type=new TypeReference<List<OrderDetail>>(){};
        List<OrderDetail> details=mapper.convertValue(orderData.get("orderDetails"), type).stream()
                .peek(d->d.setOrder(order)).collect(Collectors.toList());
        orderDetailRepository.saveAll(details);
        return order;
    }

    @Override
    public Order findById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Order> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }
}
