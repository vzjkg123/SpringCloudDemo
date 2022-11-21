package com.example.user.controller;



import com.example.common.pojo.R;
import com.example.user.pojo.dto.RegisterBody;
import com.example.user.service.serviceImpl.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("login")
@RestController
public class LoginController {
    LoginService loginService;

    @Autowired
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping
    public R<String> test(){
        return R.success("TEST SUCCESS!");
    }
    @PostMapping
    public R<String> Login(@RequestBody RegisterBody registerBody) {
        return loginService.login(registerBody);
    }


}
