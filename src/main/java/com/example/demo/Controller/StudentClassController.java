package com.example.demo.Controller;

import com.example.demo.Model.StudentClass;
import com.example.demo.Service.Interface.StudentClassService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class StudentClassController {
    @Autowired
    private StudentClassService studentClassService;

    @GetMapping(path = "/studentClasses")
    public List<StudentClass> getAllStudentClass(){
        return studentClassService.getAllStudentClass();
    }

    @PostMapping(path = "/studentClass")
    public void createNewStudentClass(@Valid @RequestBody StudentClass newStudentClass){
        studentClassService.createNewStudentClass(newStudentClass);
    }

    @DeleteMapping(path = "/studentClass/{id}")
    public void deleteStudentClass(@PathVariable long id){
        studentClassService.deleteStudentClass(id);
    }

    @PutMapping(path = "/studentClass/{classId}")
    public void updateStudentClass(@Valid @RequestBody StudentClass updatedStudentClass, @PathVariable long id){
        studentClassService.updateStudentClass(updatedStudentClass, id);
    }
}
