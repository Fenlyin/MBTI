package com.mbti.dao;

import com.mbti.entity.Users;

/**
 * 数据访问
 */
public interface UserDao {
    //根据id获取用户信息
    Users getUserById(int id);
    //根据登录名、密码进行用户的身份验证
    Users getLoginUser(String login,String passwd);
}
