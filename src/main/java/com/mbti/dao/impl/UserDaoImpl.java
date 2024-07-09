package com.mbti.dao.impl;

import com.mbti.dao.UserDao;
import com.mbti.entity.Users;

public class UserDaoImpl implements UserDao {
    @Override
    public Users getUserById(int id) {
        //连接数据库进行查询操作
        Users users=new Users();
        users.setId(1);
        users.setLogin("admin");
        users.setName("管理员");
        return users;
    }
}
