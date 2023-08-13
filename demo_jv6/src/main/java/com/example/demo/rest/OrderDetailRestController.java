package com.example.demo.rest;

import com.example.demo.entity.OrderDetail;
import com.example.demo.service.OrderDetailService;
import com.example.demo.service.impl.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class OrderDetailRestController {
    @Autowired
    private OrderDetailServiceImpl orderDetailService;

    @GetMapping("/rest/orderdetailall")
    public List<OrderDetail> findAll() {
        return orderDetailService.findAll();
    }

    @GetMapping("/rest/orderdetailall/{orderid}")
    public List<OrderDetail> findAllByOrderId(@PathVariable("orderid") Integer id) {
        return orderDetailService.getOrderDetailByOrdOrderById(id);
    }
}
