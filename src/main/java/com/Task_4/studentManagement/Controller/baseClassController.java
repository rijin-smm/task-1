package com.Task_4.studentManagement.Controller;

import com.Task_4.studentManagement.Model.BaseClass;
import com.Task_4.studentManagement.Service.Interface.baseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class baseClassController {
    @Autowired
    private baseClassService bs;

    @PostMapping(path = "/baseClass")
    public void addBaseClassStudent(@RequestBody BaseClass baseClass){
        bs.addBaseClassStudent(baseClass);

    }

    @GetMapping(path = "/baseClasses")
    public List<BaseClass> getAllBaseClass(){
        return bs.getAllBaseClass();

    }

    @PutMapping(path = "/baseClass/{")
}
