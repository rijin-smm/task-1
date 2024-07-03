package com.Task_4.studentManagement.Controller;


import com.Task_4.studentManagement.Model.StudentClass;
import com.Task_4.studentManagement.Service.Interface.studentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class studentClassController {

    @Autowired
    private studentClassService stud_ser;

    @GetMapping(path = "/studentClasses")
    public List<StudentClass>  getAllStudentClass(){
        return stud_ser.getAllStudentClass();
    }

    @PostMapping(path = "/studentClass")
    public void createNewStudentClass(@RequestBody StudentClass newStudentClass){
        stud_ser.createNewStudentClass(newStudentClass);
    }

    @DeleteMapping(path = "/studentClass/{classId}")
    public void deleteStudentClass(@PathVariable long classId){
        stud_ser.deleteStudentClass(classId);
    }

    @PutMapping(path = "/student/{classId}")
    public void updateStudentClass(@RequestBody StudentClass updatedStudentClass, @PathVariable long classId){
        stud_ser.updateStudentClass(updatedStudentClass, classId);
    }
}
