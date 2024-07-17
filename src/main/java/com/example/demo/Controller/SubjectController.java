package com.example.demo.Controller;

import com.example.demo.Model.Subject;
import com.example.demo.Service.Interface.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping(path = "/subjects")
    public List<Subject> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @PostMapping(path = "/subject")
    public void createNewSubject(@Valid @RequestBody com.example.demo.Model.Subject newSubject){
        subjectService.createNewSubject(newSubject);
    }

    @DeleteMapping(path = "subject/{subjectId}")
    public void deleteSubject(@PathVariable long subjectId){
        subjectService.deleteSubject(subjectId);
    }
    //
    @PutMapping(path = "subject/{subjectId}")
    public void updateSubject(@Valid @RequestBody Subject updatedSubject, @PathVariable long subjectId){
        subjectService.updateSubject(updatedSubject,subjectId);
    }
}
