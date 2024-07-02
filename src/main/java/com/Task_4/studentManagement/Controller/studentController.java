package com.Task_4.studentManagement.Controller;

import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService;
import com.Task_4.studentManagement.Service.Interface.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class studentController {
    @Autowired
    private studentService ss;


    @PostMapping(path = "/student")
    public void addStudent(@RequestBody Student student){
        ss.addStudent(student);
    }

    @GetMapping(path = "/students")
    public List<Student>  getAllStudent(){
        return ss.getAllStudent();
    }

//    @PutMapping(path = "/student/{studentId}")
//    public void updateStudent(@RequestBody Student updatedStudent, @PathVariable String studentId){
//        ss.updateStudent(updatedStudent,studentId);
//    }
//
//    @DeleteMapping(path = "/student/{studentId}")
//    public void deleteStudent(@PathVariable String studentId){
//        ss.deleteStudent(studentId);
//    }

//    @GetMapping(path = "/students/top3")
//    public List<Student> getTop3Student(){
//        return ss.getTop3Student();
//    }

//    @GetMapping(path = "/students/{studentName}")
//    public List<Student> getStudentByName(@PathVariable String studentName){
//        return ss.getStudentByname(studentName);
//    }

//    @GetMapping("/students/firstRanked")
//    public List<Student> getStudentsWithFirstRank() {
//        return ss.getStudentsWithFirstRank();
//    }

}
