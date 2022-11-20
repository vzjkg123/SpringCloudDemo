package com.example.controller;


import com.example.service.serviceImpl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @Autowired
    LoginService loginService;

    @GetMapping("gateway")
    public String gateway() {
        return loginService.testRedis();
    }


}
