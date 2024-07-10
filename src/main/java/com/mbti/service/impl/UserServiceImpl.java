package com.mbti.service.impl;

import com.mbti.dao.UserDao;
import com.mbti.dao.impl.UserDaoImpl;
import com.mbti.entity.Users;
import com.mbti.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public Users getUserById(int id) {
        //业务处理

        //调用数据访问层dao
        Users users=userDao.getUserById(id);
        return users;
    }

    @Override
    public Users getLoginUser(String login, String passwd) {
        //调用数据访问层进行身份验证的方法
        return userDao.getLoginUser(login,passwd);
    }
}
