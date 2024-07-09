package com.mbti.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 工具类：读取数据库属性文件、加载驱动、获取连接、关闭资源
 */
public class DBUtil {
    private static String driver=null;
    private static String url=null;
    private static String user=null;
    private static String password=null;

    private static Connection conn=null;
    //加载类的同时执行读取数据库属性文件、加载驱动
    static {//静态代码块
        try {
            InputStream in=DBUtil .class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties=new Properties();
            properties.load(in);
            driver=properties.getProperty("driver");
            url=properties.getProperty("url");
            user= properties.getProperty("user");
            password=properties.getProperty("password");
            //2、加载驱动
            Class.forName(driver);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    //获取连接
    public static Connection getConnection(){
        //建立连接
        try {
            if(conn==null||conn.isClosed()){
                conn= DriverManager.getConnection(url,user,password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    //关闭资源
    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}