package com.example.demo.controller;


import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
    DiscoveryClient discoveryClient;
    RestTemplate restTemplate;
    ProductService productService;

    @Autowired
    public OrderController(DiscoveryClient discoveryClient, RestTemplate restTemplate, ProductService productService) {
        this.productService = productService;
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }


    @GetMapping("order")
    public String order() {


        return "service-order" + "<br>" + productService.product();
    }
}
