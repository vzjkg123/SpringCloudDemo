package com.example.user.service.serviceImpl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.common.pojo.R;
import com.example.common.util.JwtUtils;
import com.example.user.pojo.dto.RegisterBody;
import com.example.user.pojo.entity.UserInfo;
import com.example.user.service.IUserInfoService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginService {
    StringRedisTemplate stringRedisTemplate;
    IUserInfoService userInfoService;
    Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }


    @Autowired
    public void setUserInfoService(IUserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    @Autowired
    private void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }


    public R<String> login(RegisterBody registerBody) {

        UserInfo userInfo = userInfoService.getOne(new LambdaQueryWrapper<UserInfo>().eq(UserInfo::getAccount, registerBody.getAccount()).eq(UserInfo::getPassword, registerBody.getPassword()));
        if (userInfo == null) return R.fail();

        HashMap<String, Object> header = new HashMap<>();
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id",userInfo.getId());
        Date expireDate = DateUtils.addDays(new Date(), 30);

        String token = JwtUtils.createToken(env.getProperty("secret-key"), header, claims, expireDate);
        if (Objects.isNull(token)) {
            return R.fail();
        }
        return R.success(token);


    }


}
