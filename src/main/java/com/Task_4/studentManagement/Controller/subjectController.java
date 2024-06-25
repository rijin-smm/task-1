package com.Task_4.studentManagement.Controller;

import com.Task_4.studentManagement.Model.Subject;
import com.Task_4.studentManagement.Service.subjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class subjectController {

    @Autowired
    private subjectService subj_ser;

    @GetMapping(path = "/subject")
    public List<Subject> getAllSubject(){
        return subj_ser.getAllSubject();
    }

    @PostMapping(path = "/subject")
    public void createNewSubject(@RequestBody Subject newSubject){
        subj_ser.createNewSubject(newSubject);
    }

    @DeleteMapping(path = "subject/{subject_id}")
    public void deleteSubject(@PathVariable String subject_id){
        subj_ser.deleteSubject(subject_id);
    }

    public void updateSubject(@RequestBody Subject updatedSubject, @PathVariable String subject_id){
        subj_ser.updateSubject(updatedSubject,subject_id);
    }
}
