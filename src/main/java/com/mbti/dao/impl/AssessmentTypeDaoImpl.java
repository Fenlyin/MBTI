package com.mbti.dao.impl;

import com.mbti.dao.AssessmentTypeDao;
import com.mbti.entity.AssessmentType;
import com.mbti.entity.PersonalityDimension;
import com.mbti.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AssessmentTypeDaoImpl implements AssessmentTypeDao {
    @Override
    public List<AssessmentType> getAssessmentTypeList() {
        List<AssessmentType> assessmentTypeList=new ArrayList<>();
        //数据库相关操作
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection= DBUtil.getConnection();
            String sql="SELECT * FROM assessments;";
            statement=connection.prepareStatement(sql);

            resultSet=statement.executeQuery();
            while (resultSet.next()) {
                AssessmentType assessmentType=new AssessmentType();
                int uid = resultSet.getInt("id");//获取到字段id对应的值
                String title=resultSet.getString("title");
                double cost=resultSet.getDouble("cost");
                assessmentType.setId(uid);
                assessmentType.setTitle(title);
                assessmentType.setCost(cost);
                //把性格维度对象添加到集合中
                assessmentTypeList.add(assessmentType);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return assessmentTypeList;
    }

    @Override
    public AssessmentType getAssessmentTypeById(int id) {
        //查询数据库
        AssessmentType assessmentType=null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try{
            connection= DBUtil.getConnection();
            String sql="SELECT * FROM assessments where id=?;";
            statement=connection.prepareStatement(sql);
            statement.setInt(1,id);

            resultSet=statement.executeQuery();
            if (resultSet.next()) {
                assessmentType=new AssessmentType();
                int uid = resultSet.getInt("id");//获取到字段id对应的值
                String title=resultSet.getString("title");
                double cost=resultSet.getDouble("cost");
                assessmentType.setId(uid);
                assessmentType.setTitle(title);
                assessmentType.setCost(cost);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,resultSet);
        }
        return assessmentType;
    }
}
