package com.Task_4.studentManagement.Controller;

import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Service.Interface.studentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class studentController {
    @Autowired
    private studentService ss;

    @PostMapping(path = "/students")
    public void addStudent(@RequestBody Student student){
        ss.addStudent(student);

    }


    @GetMapping(path = "/students")
    public List<Student>  getAllStudent(){
        return ss.getAllStudent();

    }

    @PutMapping(path = "/students/{roll_no}")
    public void updateStudent(@RequestBody Student student, @PathVariable int roll_no){
        ss.updateStudent(student,roll_no);

    }

    @DeleteMapping(path = "/students/{roll_no}")
    public void deleteStudent(@PathVariable int roll_no){
        ss.deleteStudent(roll_no);

    }

    @GetMapping(path = "/students/top3")
    public List<Student> getTop3Student(){
        return ss.getTop3Student();

    }

    @GetMapping(path = "/students/{studentName}")
    public List<Student> getStudentByName(@PathVariable String studentName){
        return ss.getStudentByname(studentName);

    }

    @GetMapping("/students/firstRanked")
    public List<Student> getStudentsWithFirstRank() {
        return ss.getStudentsWithFirstRank();
    }


//    @GetMapping(path = "/students/{roll_no}")
//    public Student>  getStudent(@PathVariable int roll_no){
//        return ss.getStudent(roll_no);
//
//    }
}
