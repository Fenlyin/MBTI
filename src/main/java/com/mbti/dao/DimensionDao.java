package com.mbti.dao;

import com.mbti.entity.PersonalityDimension;

import java.util.List;

public interface DimensionDao {
    //获取性格维度的列表
    List<PersonalityDimension> getDimensionList();
}
