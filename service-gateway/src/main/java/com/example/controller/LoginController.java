package com.example.controller;


import com.example.pojo.dto.RegisterBody;
import com.example.pojo.entity.UserInfo;
import com.example.service.serviceImpl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/account/login")
@RestController
public class LoginController {
    LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public Map<String, Object> Login(@RequestBody RegisterBody registerBody) {
        return loginService.login(registerBody);
    }


}
