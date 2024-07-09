package com.mbti.dao;

import com.mbti.entity.Users;

/**
 * 数据访问
 */
public interface UserDao {
    //根据id获取用户信息
    Users getUserById(int id);
}
