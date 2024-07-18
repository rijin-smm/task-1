package com.Task_4.studentManagement.Controller;

import com.Task_4.studentManagement.DTO.studentMarksDTO;
import com.Task_4.studentManagement.Model.HighestScoreStudentDTO;
import com.Task_4.studentManagement.Model.Student;
import com.Task_4.studentManagement.Service.Interface.sequenceGeneratorService;
import com.Task_4.studentManagement.Service.Interface.studentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class studentController {
    @Autowired
    private studentService ss;


    @PostMapping(path = "/student")
    public void addStudent(@Valid @RequestBody Student student){
        ss.addStudent(student);
    }

    @GetMapping(path = "/students")
    public List<Student>  getAllStudent(){
        return ss.getAllStudent();
    }

    @PutMapping(path = "/student/{id}")
    public void updateStudent(@Valid @RequestBody Student updatedStudent, @PathVariable long id){
        ss.updateStudent(updatedStudent,id);
    }
//
    @DeleteMapping(path = "/student/{id}")
    public void deleteStudent(@Valid @PathVariable long id){
        ss.deleteStudent(id);
    }

//    @GetMapping(path = "/students/top3")
//    public List<Student> getTop3Student(){
//        return ss.getTop3Student();
//    }

    @GetMapping(path = "/student/{studentName}")
    public Student getStudentByName(@PathVariable String studentName){
        return ss.getStudentByname(studentName);
    }
//
//    @GetMapping("/students/firstRanked")
//    public List<HighestScoreStudentDTO> getStudentsWithFirstRank() {
//        return ss.getStudentsWithFirstRank();
//    }


//
}
