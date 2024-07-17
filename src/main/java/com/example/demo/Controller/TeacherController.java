package com.example.demo.Controller;

import com.example.demo.Model.Teacher;
import com.example.demo.Service.Interface.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping(path = "/teachers")
    public List<Teacher> getAllTeacher(){
        return teacherService.getAllTeacher();
    }

    @PostMapping(path = "/teacher")
    public void createTeacher(@Valid @RequestBody Teacher newTeacher){
        teacherService.createTeacher(newTeacher);
    }

    @DeleteMapping(path = "/teacher/{teacherId}")
    public void deleteTeacher(@PathVariable long teacherId){
        teacherService.deleteTeacher(teacherId);
    }
    //
    @PutMapping(path = "/teacher/{teacherId}")
    public void updateTeacher(@Valid @RequestBody Teacher updatedTeacher, @PathVariable long teacherId){
        teacherService.updateTeacher(updatedTeacher,teacherId);
    }

    @GetMapping("/teachers/subject/{subjectName}")
    public List<Teacher> getTeachersBySubjectName(@PathVariable String subjectName) {
        return teacherService.getTeachersBySubjectName(subjectName);
    }
}
