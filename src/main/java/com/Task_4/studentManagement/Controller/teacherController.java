package com.Task_4.studentManagement.Controller;

import com.Task_4.studentManagement.Model.Teacher;
import com.Task_4.studentManagement.Service.teacherService;
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

    @PostMapping(path = "/teachers")
    public void createTeacher(@RequestBody Teacher newTeacher){
        ts.createTeacher(newTeacher);
    }

    @DeleteMapping(path = "/teachers/{teacher_id}")
    public void deleteTeacher(@PathVariable String teacher_id){
        ts.deleteTeacher(teacher_id);
    }

    @PutMapping(path = "/teachers/{teacher_id}")
    public void updateTeacher(@RequestBody Teacher updatedTeacher, @PathVariable String teacher_id){
        ts.updateTeacher(updatedTeacher,teacher_id);
    }

    @GetMapping(path = "/teachers/{teacher_subject}")
    public List<Teacher> getTeacherBySubject(@PathVariable String teacher_subject){
        return ts.getTeacherBySubjectName(teacher_subject);

    }

}
