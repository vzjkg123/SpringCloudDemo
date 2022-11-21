package com.example.user.pojo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.user.pojo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao extends BaseMapper<UserInfo> {
}
