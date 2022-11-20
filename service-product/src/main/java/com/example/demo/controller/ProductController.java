package com.example.demo.controller;


import com.example.demo.facade.ProductFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductFacade {

    @GetMapping("product")
    public String product() {
        return "service-product";
    }

}
