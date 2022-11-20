package com.example.demo.service.impl;


import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductService productService;

    @Override
    public String queryProduct() {
        return productService.product();
    }
}
