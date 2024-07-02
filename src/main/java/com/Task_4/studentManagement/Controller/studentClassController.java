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

    @GetMapping(path = "/studentClass")
    public List<StudentClass>  getAllStudentClass(){
        return stud_ser.getAllStudentClass();
    }

    @PostMapping(path = "/studentClass")
    public void createNewStudentClass(@RequestBody StudentClass newStudentClass){
        stud_ser.createNewStudentClass(newStudentClass);
    }

//    @DeleteMapping(path = "/studentClass/{student_class_id}")
//    public void deleteStudentClass(@PathVariable String student_class_id){
//        stud_ser.deleteStudentClass(student_class_id);
//    }
//
//    @PutMapping(path = "/student/{student_class_id}")
//    public void updateStudentClass(@RequestBody StudentClass updatedStudentClass, @PathVariable String student_class_id){
//        stud_ser.updateStudentClass(updatedStudentClass, student_class_id);
//    }
}
