package com.example.demo.Controller;

import com.example.demo.Model.Subject;
import com.example.demo.Service.Interface.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping(path = "/subjects")
    public List<Subject> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @PostMapping(path = "/subject")
    public void createNewSubject(@RequestBody com.example.demo.Model.Subject newSubject){
        subjectService.createNewSubject(newSubject);
    }

    @DeleteMapping(path = "subject/{subjectId}")
    public void deleteSubject(@PathVariable long subjectId){
        subjectService.deleteSubject(subjectId);
    }
    //
    @PutMapping(path = "subject/{subjectId}")
    public void updateSubject(@RequestBody Subject updatedSubject, @PathVariable long subjectId){
        subjectService.updateSubject(updatedSubject,subjectId);
    }
}
