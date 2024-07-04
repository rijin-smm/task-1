package com.Task_4.studentManagement.Service.Implements;

import com.Task_4.studentManagement.Model.BaseClass;
import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Repository.baseClassRepo;
import com.Task_4.studentManagement.Service.Interface.baseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class baseClassServiceImpl implements baseClassService {

    @Autowired
    private baseClassRepo br;

    @Override
    public void addBaseClassStudent(BaseClass newBaseClass){
        br.save(newBaseClass);
    }

    @Override
    public List<BaseClass> getAllBaseClass(){
        return br.findAll();
    }


}
