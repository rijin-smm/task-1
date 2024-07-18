package com.Task_4.studentManagement.Service.Interface;

import com.Task_4.studentManagement.Model.BaseClass;
import jakarta.validation.Valid;

import java.util.List;

public interface baseClassService {
    void updateBaseClass(@Valid long id, BaseClass updatedBaseClass);

    void addBaseClassStudent(@Valid BaseClass baseClass);
    List<BaseClass> getAllBaseClass();
}
