package com.mbti.service;

import com.mbti.entity.Users;

/**
 * 业务逻辑
 */
public interface UserService {
    //根据id获取用户信息
    Users getUserById(int id);
}
