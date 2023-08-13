package com.example.demo.service;

import com.example.demo.entity.OrderDetail;

import java.util.List;

public interface OrderDetailService {
	List<OrderDetail> findAll();
	List<OrderDetail> getOrderDetailByOrdOrderById(Integer orderId);

}
