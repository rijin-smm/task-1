package com.example.demo.Service.Interface;

import com.example.demo.Model.BaseClass;

import java.util.List;

public interface BaseClassService {
    void updateBaseClass(long id, BaseClass updatedBaseClass);

    void addBaseClassStudent(BaseClass baseClass);
    List<BaseClass> getAllBaseClass();
}
