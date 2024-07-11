package com.mbti.service;

import com.mbti.entity.AssessmentType;

import java.util.List;

public interface AssessmentTypeService {
    List<AssessmentType> getAssessmentTypeList();
    AssessmentType getAssessmentTypeById(int id);
}
