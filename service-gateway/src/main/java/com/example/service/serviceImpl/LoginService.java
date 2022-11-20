package com.example.service.serviceImpl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.pojo.dto.RegisterBody;
import com.example.pojo.entity.UserInfo;
import com.example.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class LoginService {
    StringRedisTemplate stringRedisTemplate;
    IUserInfoService userInfoService;

    @Autowired
    public void setUserInfoService(IUserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    @Autowired
    private void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    public Map<String, Object> login(RegisterBody registerBody) {
        Map<String, Object> res = new HashMap<>();
        UserInfo userInfo = userInfoService.getOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getAccount, registerBody.getAccount()).eq(UserInfo::getPassword, registerBody.getPassword()));
        if (userInfo == null) {
            res.put("status", "failed");
        }else {
            String token = UUID.randomUUID().toString();
            stringRedisTemplate.opsForValue().set("user:token",token);
            res.put("status","success");
            res.put("token",token);
        }
        return res;
    }


}
