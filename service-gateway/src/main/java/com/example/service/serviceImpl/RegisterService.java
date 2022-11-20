package com.example.service.serviceImpl;


import com.example.pojo.dto.RegisterBody;
import com.example.pojo.entity.UserInfo;
import com.example.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterService {
    IUserInfoService userInfoService;

    @Autowired
    public void setUserInfoService(IUserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    public Map<String, Object> register(RegisterBody registerBody) {

        UserInfo userInfo = new UserInfo();

        userInfo.setAccount(registerBody.getAccount());
        userInfo.setPassword(registerBody.getPassword());

        Map<String, Object> res = new HashMap<>();
        if (userInfoService.getById(userInfo.getAccount()) != null) {
            res.put("status", "账号已经存在");
        } else
            res.put("status", userInfoService.save(userInfo) ? "注册成功" : "注册失败");

        return res;
    }


}
