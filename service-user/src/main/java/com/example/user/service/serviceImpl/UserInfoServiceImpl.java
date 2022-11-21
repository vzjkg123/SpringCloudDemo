package com.example.user.service.serviceImpl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.user.pojo.dao.UserInfoDao;
import com.example.user.pojo.entity.UserInfo;
import com.example.user.service.IUserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements IUserInfoService {
}
