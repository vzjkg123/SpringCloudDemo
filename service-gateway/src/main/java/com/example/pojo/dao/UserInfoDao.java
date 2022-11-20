package com.example.pojo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoDao extends BaseMapper<UserInfo> {
}
