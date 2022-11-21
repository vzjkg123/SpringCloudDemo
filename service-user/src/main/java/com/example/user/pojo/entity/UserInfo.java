package com.example.user.pojo.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class UserInfo {
    @TableId
    Long id;
    String account;
    String password;
}
