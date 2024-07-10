package com.mbti.service.impl;

import com.mbti.dao.DimensionDao;
import com.mbti.dao.impl.DimensionDaoImpl;
import com.mbti.entity.PersonalityDimension;
import com.mbti.service.DimensionService;

import java.util.List;

public class DimensionServiceImpl implements DimensionService {
    DimensionDao dimensionDao=new DimensionDaoImpl();
    @Override
    public List<PersonalityDimension> getDimensionList() {
        //调用数据访问层的相关方法
        return dimensionDao.getDimensionList();
    }
}
