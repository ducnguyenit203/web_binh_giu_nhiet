package com.example.demo.service.impl;

import com.example.demo.entity.OrderDetail;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository repository;

    @Override
    public List<OrderDetail> findAll() {
        return repository.findAll();
    }

    @Override
    public List<OrderDetail> getOrderDetailByOrdOrderById(Integer orderId) {
        return repository.findOrderDetailByOrOrderById(orderId);
    }
}
