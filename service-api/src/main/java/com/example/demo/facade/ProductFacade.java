package com.example.demo.facade;

import org.springframework.web.bind.annotation.GetMapping;

public interface ProductFacade {
    @GetMapping("product")
    public String product();
}
