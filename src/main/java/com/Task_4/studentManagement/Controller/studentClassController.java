package com.Task_4.studentManagement.Controller;


import com.Task_4.studentManagement.Model.BaseClass;
import com.Task_4.studentManagement.Model.studentClass;
import com.Task_4.studentManagement.Service.Interface.studentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class studentClassController {

    @Autowired
    private studentClassService stud_ser;

    @GetMapping(path = "/studentClasses")
    public List<studentClass>  getAllStudentClass(){
        return stud_ser.getAllStudentClass();
    }

    @PostMapping(path = "/studentClass")
    public void createNewStudentClass(@RequestBody studentClass newStudentClass){
        stud_ser.createNewStudentClass(newStudentClass);
    }

    @DeleteMapping(path = "/studentClass/{id}")
    public void deleteStudentClass(@PathVariable long id){
        stud_ser.deleteStudentClass(id);
    }

    @PutMapping(path = "/studentClass/{classId}")
    public void updateStudentClass(@RequestBody studentClass updatedStudentClass, @PathVariable long id){
        stud_ser.updateStudentClass(updatedStudentClass, id);
    }
}
