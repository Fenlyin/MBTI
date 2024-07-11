package com.mbti.service.impl;

import com.mbti.dao.AssessmentTypeDao;
import com.mbti.dao.impl.AssessmentTypeDaoImpl;
import com.mbti.entity.AssessmentType;
import com.mbti.service.AssessmentTypeService;

import java.util.List;

public class AssessmentTypeServiceImpl implements AssessmentTypeService {
    AssessmentTypeDao assessmentTypeDao=new AssessmentTypeDaoImpl();
    @Override
    public List<AssessmentType> getAssessmentTypeList() {
        //调用数据访问层
        return assessmentTypeDao.getAssessmentTypeList();
    }

    @Override
    public AssessmentType getAssessmentTypeById(int id) {
        return assessmentTypeDao.getAssessmentTypeById(id);
    }
}
