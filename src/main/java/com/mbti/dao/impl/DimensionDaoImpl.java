package com.mbti.dao.impl;

import com.mbti.dao.DimensionDao;
import com.mbti.entity.PersonalityDimension;
import com.mbti.entity.Users;
import com.mbti.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DimensionDaoImpl implements DimensionDao {
    @Override
    public List<PersonalityDimension> getDimensionList() {
        List<PersonalityDimension> dimensionList=new ArrayList<>();
        //数据库相关操作
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection= DBUtil.getConnection();
            String sql="SELECT * FROM personality_dimension;";
            statement=connection.prepareStatement(sql);

            resultSet=statement.executeQuery();
            while (resultSet.next()) {
                PersonalityDimension p=new PersonalityDimension();
                int uid = resultSet.getInt("id");//获取到字段id对应的值
                String title=resultSet.getString("title");
                String depict=resultSet.getString("depict");
                p.setId(uid);
                p.setTitle(title);
                p.setDepict(depict);
                //把性格维度对象添加到集合中
                dimensionList.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return dimensionList;
    }

    @Override
    public PersonalityDimension getPdById(int id) {
        PersonalityDimension p=null;
        //进行数据库查询操作
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //获取连接
            connection= DBUtil.getConnection();

            //4、获取Statement对象
            String sql = "SELECT * FROM personality_dimension where id=?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            //5、执行查询操作

            resultSet = statement.executeQuery();

            //6、处理结果，创建用户对象，属性赋值

            if (resultSet.next()) {
                p = new PersonalityDimension();
                int uid = resultSet.getInt("id");//获取到字段id对应的值
                String title=resultSet.getString("title");
                String depict=resultSet.getString("depict");
                int assmentId=resultSet.getInt("assessment_id");
                p.setId(uid);
                p.setTitle(title);
                p.setDepict(depict);
                p.setAssessmentId(assmentId);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //7、关闭资源
            DBUtil.close(connection,statement,resultSet);
        }
        return p;
    }

    @Override
    public int updatePdById(PersonalityDimension p) {
        int count=0;
        //进行数据库查询操作
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //获取连接
            connection= DBUtil.getConnection();

            //4、获取Statement对象
            String sql = "UPDATE personality_dimension SET title=?,depict=?,assessment_id=? WHERE id=?";

            statement = connection.prepareStatement(sql);
            statement.setString(1,p.getTitle());
            statement.setString(2,p.getDepict());
            statement.setInt(3,p.getAssessmentId());
            statement.setInt(4,p.getId());

            //5、执行更新操作

            count = statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //7、关闭资源
            DBUtil.close(connection,statement,resultSet);
        }
        return count;
    }

    @Override
    public int deletePdById(int id) {
        int count=0;
        //进行数据库查询操作
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //获取连接
            connection= DBUtil.getConnection();

            //4、获取Statement对象
            String sql = "DELETE FROM personality_dimension WHERE id=?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);


            //5、执行更新操作

            count = statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //7、关闭资源
            DBUtil.close(connection,statement,resultSet);
        }
        return count;
    }

    @Override
    public int addPd(PersonalityDimension p) {
        int count=0;
        //进行数据库查询操作
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            //获取连接
            connection= DBUtil.getConnection();

            //4、获取Statement对象
            String sql = "INSERT INTO personality_dimension(title,depict,assessment_id) VALUES(?,?,?);";

            statement = connection.prepareStatement(sql);
            statement.setString(1,p.getTitle());
            statement.setString(2,p.getDepict());
            statement.setInt(3,p.getAssessmentId());

            //5、执行更新操作

            count = statement.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //7、关闭资源
            DBUtil.close(connection,statement,resultSet);
        }
        return count;
    }
}
