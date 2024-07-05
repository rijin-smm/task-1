package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.Model.BaseClass;

import java.util.List;

public interface baseClassService {
    void updateBaseClass(long studentId, long classId, BaseClass updatedBaseClass);

    void addBaseClassStudent(BaseClass baseClass);
    List<BaseClass> getAllBaseClass();
}
