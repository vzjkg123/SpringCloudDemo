package com.example.controller;
import com.example.pojo.dto.RegisterBody;
import com.example.service.serviceImpl.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/account/register")
@RestController
public class RegisterController {
    RegisterService registerService;


    @Autowired
    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping
    public Map<String,Object> register(@RequestBody RegisterBody registerBody){
        return registerService.register(registerBody);
    }









}
