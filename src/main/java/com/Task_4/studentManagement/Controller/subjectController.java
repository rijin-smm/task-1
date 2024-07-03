package com.Task_4.studentManagement.Controller;

import com.Task_4.studentManagement.Model.Subject;
import com.Task_4.studentManagement.Service.Interface.subjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class subjectController {

    @Autowired
    private subjectService subj_ser;

    @GetMapping(path = "/subjects")
    public List<Subject> getAllSubject(){
        return subj_ser.getAllSubject();
    }

    @PostMapping(path = "/subject")
    public void createNewSubject(@RequestBody Subject newSubject){
        subj_ser.createNewSubject(newSubject);
    }

    @DeleteMapping(path = "subject/{subjectId}")
    public void deleteSubject(@PathVariable long subjectId){
        subj_ser.deleteSubject(subjectId);
    }
//
    @PutMapping(path = "subject/{subjectId}")
    public void updateSubject(@RequestBody Subject updatedSubject, @PathVariable long subjectId){
        subj_ser.updateSubject(updatedSubject,subjectId);
    }
}
