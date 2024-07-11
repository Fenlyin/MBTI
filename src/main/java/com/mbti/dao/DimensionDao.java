package com.mbti.dao;

import com.mbti.entity.PersonalityDimension;

import java.util.List;

public interface DimensionDao {
    //获取性格维度的列表
    List<PersonalityDimension> getDimensionList();
    PersonalityDimension getPdById(int id);
    //修改性格维度：根据id
    int updatePdById(PersonalityDimension p);

    //根据id删除性格维度
    int deletePdById(int id);
}
