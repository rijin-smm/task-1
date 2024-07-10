package com.example.demo.Controller;


import com.example.demo.Model.Student;
import com.example.demo.Service.Interface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping(path = "/student")
    public void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @GetMapping(path = "/students")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
//
    @PutMapping(path = "/student/{id}")
    public void updateStudent(@RequestBody Student updatedStudent, @PathVariable long id){
        studentService.updateStudent(updatedStudent,id);
    }

    @DeleteMapping(path = "/student/{id}")
    public void deleteStudent(@PathVariable long id){
        studentService.deleteStudent(id);
    }
//
////    @GetMapping(path = "/students/top3")
////    public List<Student> getTop3Student(){
////        return ss.getTop3Student();
////    }

    @GetMapping(path = "/student/{studentName}")
    public Student getStudentByName(@PathVariable String studentName){
        return studentService.getStudentByname(studentName);
    }
////
////    @GetMapping("/students/firstRanked")
////    public List<HighestScoreStudentDTO> getStudentsWithFirstRank() {
////        return ss.getStudentsWithFirstRank();
////    }
}
