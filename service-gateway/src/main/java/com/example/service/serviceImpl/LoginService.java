package com.example.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    private void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    public String testRedis() {
        stringRedisTemplate.opsForValue().set("test", "1");
        return stringRedisTemplate.opsForValue().get("test");
    }


}
