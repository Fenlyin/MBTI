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
}
