package com.Task_4.studentManagement.Controller;

import com.Task_4.studentManagement.Model.Teacher;
import com.Task_4.studentManagement.Service.Interface.teacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class teacherController {

    @Autowired
    private teacherService ts;

    @GetMapping(path = "/teachers")
    public List<Teacher> getAllTeacher(){
        return ts.getAllTeacher();
    }

    @PostMapping(path = "/teacher")
    public void createTeacher(@RequestBody Teacher newTeacher){
        ts.createTeacher(newTeacher);
    }

    @DeleteMapping(path = "/teacher/{teacherId}")
    public void deleteTeacher(@PathVariable long teacherId){
        ts.deleteTeacher(teacherId);
    }
//
    @PutMapping(path = "/teacher/{teacherId}")
    public void updateTeacher(@RequestBody Teacher updatedTeacher, @PathVariable long teacherId){
        ts.updateTeacher(updatedTeacher,teacherId);
    }

    @GetMapping("/teachers/subject/{subjectName}")
    public List<Teacher> getTeachersBySubjectName(@PathVariable String subjectName) {
        return ts.getTeachersBySubjectName(subjectName);
    }

}
