package com.mbti.dao.impl;

import com.mbti.dao.UserDao;
import com.mbti.entity.Users;
import com.mbti.util.DBUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class UserDaoImpl implements UserDao {
    @Override
    public Users getUserById(int id) {
        //连接数据库进行查询操作
        Users users=null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //获取连接
            connection= DBUtil.getConnection();

            //4、获取Statement对象
            String sql = "SELECT * FROM users where id=?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            //5、执行查询操作

            resultSet = statement.executeQuery();

            //6、处理结果，创建用户对象，属性赋值

            if (resultSet.next()) {
                users = new Users();
                int uid = resultSet.getInt("id");//获取到字段id对应的值
                String lgoin = resultSet.getString("login");//获取到字段title对应的值
                String name = resultSet.getString("name");//获取到字段content对应的值
                String passwd = resultSet.getString("passwd");//获取到字段author对应的值
                //System.out.println(id+" "+title+" "+content+" "+author);
                users.setId(uid);
                users.setName(name);
                users.setLogin(lgoin);
                users.setPasswd(passwd);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //7、关闭资源
            DBUtil.close(connection,statement,resultSet);
        }
        return users;
    }
}
