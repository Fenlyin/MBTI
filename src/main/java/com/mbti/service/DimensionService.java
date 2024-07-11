package com.mbti.service;

import com.mbti.entity.PersonalityDimension;

import java.util.List;

public interface DimensionService {
    //获取性格维度的列表
    List<PersonalityDimension> getDimensionList();
    PersonalityDimension getPdById(int id);
    //修改性格维度：根据id
    int updatePdById(PersonalityDimension p);
}
