package com.Task_4.studentManagement.Controller;

import com.Task_4.studentManagement.Model.BaseClass;
import com.Task_4.studentManagement.Service.Interface.baseClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
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

    @PutMapping(path = "/baseClass/update/{id}")
    public void updateBaseClass(@PathVariable long id, @RequestBody BaseClass updatedBaseClass) {
        bs.updateBaseClass(id, updatedBaseClass);
    }

}
